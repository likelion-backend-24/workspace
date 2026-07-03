import DeleteButton from "./DeleteButton";
import ToggleButton from "./ToggleButton";

function TodoItem({ todo }) {
    return(
        <li className="flex items-center gap-3 p-4 bg-gray-50 rounded-lg mb-3 transition hover:translate-x-1 hover:shadow">
            <ToggleButton id={todo.id} completed={todo.completed} />
            <span className={`flex-1 text-base ${todo.completed ? "line-through text-gray-500" : ""}`}>{todo.text}</span>
        <DeleteButton id={todo.id} />
        </li>
    );

}

export default TodoItem;