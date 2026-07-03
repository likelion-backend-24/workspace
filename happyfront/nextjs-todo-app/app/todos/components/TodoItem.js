// 서버 컴포넌트
import ToggleButton from "./ToggleButton";
import DeleteButton from "./DeleteButton";
import styles from "../todos.module.css";

function TodoItem({ todo }) {
  return (
    <li className={styles.item}>
      {/* 클라이언트 컴포넌트: 토글 버튼 */}
      <ToggleButton id={todo.id} completed={todo.completed} />

      <span className={todo.completed ? styles.completed : ""}>
        {todo.text}
      </span>

      {/* 클라이언트 컴포넌트: 삭제 버튼 */}
      <DeleteButton id={todo.id} />
    </li>
  );
}

export default TodoItem;
