import { fetchTodos } from "@/lib/api";
import AddTodoForm from "./components/AddTodoForm";
import TodoList from "./components/TodoList";

const TodosPage = async () => {
  const todos = await fetchTodos();
  return (
    <div>
      <h1> todos page</h1>
      <AddTodoForm />
      <TodoList todos={todos} />

      {todos.length === 0 && (
        <p className={styles.empty}>할 일이 없습니다. 추가해보세요!</p>
      )}
    </div>
  );
};

export default TodosPage;
