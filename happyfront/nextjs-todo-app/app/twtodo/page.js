import { fetchTodos } from "@/lib/api";
import AddTodoForm from "./components/AddTodoForm";
import TodoList from "./components/TodoList";

export default async function TodosPage() {
  const todos = await fetchTodos();

  console.log(todos.length, "개 데이터 조회");

  return (
    <div className="max-w-xl mx-auto p-5 space-y-6">
      <h1 className="text-center text-gray-800 text-4xl font-semibold pb-5 mb-8 border-b border-gray-200">
        Todos Page
      </h1>
      <AddTodoForm />
      <TodoList todos={todos} />
    </div>
  );
}
