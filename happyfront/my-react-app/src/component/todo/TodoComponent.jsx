import { useEffect, useRef, useState } from "react";
import TodoList from "./TodoList";
import TodoInput from "./TodoInput";
const API_URL = "http://localhost:8080/api/todos";
const TodoComponent = () => {
  console.log("❤️");
  //   const [todos, setTodos] = useState([
  //     { id: 1, text: "리엑트 공부하기", completed: true },
  //     { id: 2, text: "쉬기", completed: true },
  //     { id: 3, text: "책보기", completed: false },
  //     { id: 4, text: "점심먹기", completed: false },
  //   ]);

  const [todos, setTodos] = useState([]);

  useEffect(() => {
    fetchTodos();
  }, []);

  const fetchTodos = async () => {
    // 컴포넌트가 마운트될 때 backend api 서버에서 데이터를 가져와서 todos를 초기화 하도록!!

    const response = await fetch("http://localhost:8080/api/todos");
    if (!response.ok) {
      throw new Error("서버응답오류");
    }
    const data = await response.json();
    setTodos(data);
  };

  const handleDelete = async (id) => {
    try {
      const response = await fetch(`${API_URL}/${id}`, {
        method: "DELETE",
      });

      if (!response.ok) {
        throw new Error("삭제 실패");
      }

      // 삭제 성공 시 화면에서도 제거
      setTodos(todos.filter((todo) => todo.id !== id));
    } catch (err) {
      console.error("삭제 실패:", err);
      alert("할 일 삭제에 실패했습니다.");
    }
  };

  //   const handleDelete = (id) => {
  //     setTodos(todos.filter((todo) => todo.id !== id));
  //   };
  const handleToggle = async (id) => {
    try {
      const response = await fetch(`${API_URL}/${id}/toggle`, {
        method: "PATCH",
      });

      if (!response.ok) {
        throw new Error("수정 실패");
      }
      const updatedTodo = await response.json();

      // 화면 업데이트
      setTodos(todos.map((t) => (t.id === id ? updatedTodo : t)));
    } catch (err) {
      console.error("토글 실패:", err);
      alert("상태 변경에 실패했습니다.");
    }
  };
  //   const handleToggle = (id) => {
  //     setTodos(
  //       todos.map((todo) =>
  //         todo.id === id ? { ...todo, completed: !todo.completed } : todo,
  //       ),
  //     );
  //   };

  const idGen = useRef(5);
  const handleAdd = async (text) => {
    try {
      const response = await fetch(API_URL, {
        method: "POST",
        headers: {
          "Content-Type": "application/json",
        },
        body: JSON.stringify({ text }),
      });

      if (!response.ok) {
        throw new Error("추가 실패");
      }

      const newTodo = await response.json();

      // 서버에서 반환한 데이터를 목록에 추가
      setTodos([...todos, newTodo]);
    } catch (err) {
      console.error("추가 실패:", err);
      alert("할 일 추가에 실패했습니다.");
    }
  };

  //   const handleAdd = (text) => {
  //     console.log("id::::::::" + idGen);
  //     setTodos([...todos, { id: idGen.current++, text, completed: false }]);
  //   };

  return (
    <div style={{ padding: "20px" }}>
      <h1>할 일 목록</h1>
      <TodoInput onAdd={handleAdd} />
      <TodoList todos={todos} onDelete={handleDelete} onToggle={handleToggle} />
    </div>
  );
};

export default TodoComponent;
