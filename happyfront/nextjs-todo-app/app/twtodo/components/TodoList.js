import TodoItem from "./TodoItem";

function TodoList({ todos }) {

return(
    <>
    <ul className="list-none p-0 m-0">
    {todos.map((todo) => (
        <TodoItem key={todo.id} todo={todo} />
    ))}
    </ul>
    {todos.length === 0 && (
        <div className="text-center text-gray-500 text-base mt-10">할 일이 없습니다.</div>
    )}
    </>
);
}

export default TodoList;