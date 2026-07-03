"use client";

import { useRouter } from "next/navigation";
import { toggleTodo } from "@/lib/api";
import styles from "../todos.module.css";

function ToggleButton({ id, completed }) {
  const router = useRouter();

  const handleToggle = async () => {
    try {
      await toggleTodo(id);
      router.refresh(); // 서버 컴포넌트 갱신
    } catch (error) {
      console.error("토글 실패:", error);
      alert("상태 변경에 실패했습니다");
    }
  };

  return (
    <button
      onClick={handleToggle}
      className={`${styles.toggleButton} ${completed ? styles.checked : ""}`}
      aria-label={completed ? "완료 취소" : "완료로 표시"}
    >
      {completed ? "✓" : ""}
    </button>
  );
}

export default ToggleButton;
