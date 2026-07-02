import { useState } from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "./assets/vite.svg";
import heroImg from "./assets/hero.png";
import "./App.css";
import { Link, NavLink, Route, Routes } from "react-router-dom";
import TodoDetail from "./pages/TodoDetail";
import TodoList from "./pages/TodoList";
import Home from "./pages/Home";
import About from "./pages/About";
import MyComponent from "./pages/MyComponet";

function App() {
  // 할 일 데이터 (상태)
  const [todos, setTodos] = useState([
    { id: 1, text: "운동하기", completed: false },
    { id: 2, text: "책 읽기", completed: true },
    { id: 3, text: "청소하기", completed: false },
  ]);

  // 할 일 추가 함수
  const addTodo = (text) => {
    const newTodo = {
      id: Date.now(), // 고유한 ID 생성
      text,
      completed: false,
    };
    setTodos([...todos, newTodo]);
  };

  // 할 일 삭제 함수
  const deleteTodo = (id) => {
    setTodos(todos.filter((todo) => todo.id !== id));
  };

  // 할일 완료
  const toggleTodo = (id) => {
    setTodos(
      todos.map((todo) => {
        if (todo.id === id) {
          return {
            ...todo,
            completed: !todo.completed,
          };
        }
        return todo;
      }),
    );
  };

  return (
    <div>
      <h1>Todo App with Router</h1>
      <MyComponent />
      <Routes>
        <Route path="/" element={<TodoList todos={todos} onAdd={addTodo} />} />
        <Route
          path="/todos/:id"
          element={
            <TodoDetail
              todos={todos}
              onDelete={deleteTodo}
              onToggle={toggleTodo}
            />
          }
        />
        <Route path="/home" element={<Home />} />
        <Route path="/about" element={<About />} />
      </Routes>
      <Link to="/">todo List</Link> <br />
      {/* <Link to={`/todos/1`}>todo details</Link>
      <br /> */}
      <Link to="/about">about</Link>
      <br />
      <Link to="/home">home</Link>
      <br></br>
      <NavLink
        to="/"
        style={({ isActive }) => ({
          fontWeight: isActive ? "bold" : "normal",
          color: isActive ? "blue" : "black",
        })}
      >
        홈
      </NavLink>
    </div>
  );
}

export default App;
