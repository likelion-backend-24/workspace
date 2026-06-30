import { useRef, useState } from "react";
import TodoList from "./TodoList";
import TodoInput from "./TodoInput";

const TodoComponent = () => {
  console.log("❤️");
  const [todos, setTodos] = useState([
    { id: 1, text: "리엑트 공부하기", completed: true },
    { id: 2, text: "쉬기", completed: true },
    { id: 3, text: "책보기", completed: false },
    { id: 4, text: "점심먹기", completed: false },
  ]);

  const handleDelete = (id) => {
    setTodos(todos.filter((todo) => todo.id !== id));
  };

  const handleToggle = (id) => {
    setTodos(
      todos.map((todo) =>
        todo.id === id ? { ...todo, completed: !todo.completed } : todo,
      ),
    );
  };

  const idGen = useRef(5);

  const handleAdd = (text) => {
    console.log("id::::::::" + idGen);
    setTodos([...todos, { id: idGen.current++, text, completed: false }]);
  };

  return (
    <div style={{ padding: "20px" }}>
      <h1>할 일 목록</h1>
      <TodoInput onAdd={handleAdd} />
      <TodoList todos={todos} onDelete={handleDelete} onToggle={handleToggle} />
    </div>
  );
};

export default TodoComponent;
