import { useState } from 'react'
import './App.css'

// 새 할 일 입력 컴포넌트
function Input({ onAdd }) {
  const [text, setText] = useState('')

  const handleAdd = () => {
    const trimmed = text.trim()
    if (trimmed === '') return // 빈 입력 무시
    onAdd(trimmed)
    setText('')
  }

  const handleKeyDown = (e) => {
    if (e.key === 'Enter') handleAdd()
  }

  return (
    <div className="todo-input">
      <input
        type="text"
        value={text}
        placeholder="할 일을 입력하세요"
        onChange={(e) => setText(e.target.value)}
        onKeyDown={handleKeyDown}
      />
      <button type="button" onClick={handleAdd}>
        추가
      </button>
    </div>
  )
}

// 개별 할 일 컴포넌트
function TodoItem({ todo, onToggle, onDelete }) {
  return (
    <li className="todo-item">
      <input
        type="checkbox"
        checked={todo.completed}
        onChange={() => onToggle(todo.id)}
      />
      <span
        className="todo-text"
        style={{ textDecoration: todo.completed ? 'line-through' : 'none' }}
      >
        {todo.text}
      </span>
      <button type="button" onClick={() => onDelete(todo.id)}>
        삭제
      </button>
    </li>
  )
}

// 할 일 목록 컴포넌트
function TodoList({ todos, onToggle, onDelete }) {
  if (todos.length === 0) {
    return <p className="todo-empty">할 일이 없습니다.</p>
  }

  return (
    <ul className="todo-list">
      {todos.map((todo) => (
        <TodoItem
          key={todo.id}
          todo={todo}
          onToggle={onToggle}
          onDelete={onDelete}
        />
      ))}
    </ul>
  )
}

// 전체 상태 관리 컴포넌트
function App() {
  const [todos, setTodos] = useState([])

  // 할 일 추가
  const addTodo = (text) => {
    const newTodo = {
      id: Date.now(),
      text,
      completed: false,
    }
    setTodos((prev) => [...prev, newTodo])
  }

  // 할 일 완료 상태 토글
  const toggleTodo = (id) => {
    setTodos((prev) =>
      prev.map((todo) =>
        todo.id === id ? { ...todo, completed: !todo.completed } : todo
      )
    )
  }

  // 할 일 삭제 (확인 메시지 후 삭제)
  const deleteTodo = (id) => {
    if (!window.confirm('정말 삭제하시겠습니까?')) return
    setTodos((prev) => prev.filter((todo) => todo.id !== id))
  }

  return (
    <div className="todo-app">
      <h1>할 일 목록</h1>
      <Input onAdd={addTodo} />
      <TodoList todos={todos} onToggle={toggleTodo} onDelete={deleteTodo} />
    </div>
  )
}

export default App
