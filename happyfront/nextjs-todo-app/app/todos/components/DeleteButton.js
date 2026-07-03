"use client";

import { useRouter } from "next/navigation";
import { deleteTodo } from "@/lib/api";
import styles from "../todos.module.css";

function DeleteButton({ id }) {
  const router = useRouter();

  const handleDelete = async () => {
    if (!confirm("정말 삭제하시겠습니까?")) {
      return;
    }

    try {
      await deleteTodo(id);
      router.refresh(); // 서버 컴포넌트 갱신
    } catch (error) {
      console.error("삭제 실패:", error);
      alert("삭제에 실패했습니다");
    }
  };

  return (
    <button onClick={handleDelete} className={styles.deleteButton}>
      삭제
    </button>
  );
}

export default DeleteButton;
