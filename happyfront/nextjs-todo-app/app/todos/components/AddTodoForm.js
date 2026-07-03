"use client"; // ⭐ 필수!

import { useState } from "react";
import { useRouter } from "next/navigation"; // ⚠️ 'next/navigation' 사용!
import { createTodo } from "@/lib/api";
import styles from "../todos.module.css";

function AddTodoForm() {
  const [text, setText] = useState("");
  const [isSubmitting, setIsSubmitting] = useState(false);
  const router = useRouter();

  const handleSubmit = async (e) => {
    e.preventDefault();

    if (!text.trim()) {
      alert("할 일을 입력해주세요");
      return;
    }

    setIsSubmitting(true);

    try {
      await createTodo({ text: text.trim(), completed: false });
      setText("");

      // ⭐ 핵심: 서버 컴포넌트 다시 렌더링
      router.refresh();
    } catch (error) {
      console.error("추가 실패:", error);
      alert("할 일 추가에 실패했습니다");
    } finally {
      setIsSubmitting(false);
    }
  };

  return (
    <form onSubmit={handleSubmit} className={styles.form}>
      <input
        type="text"
        value={text}
        onChange={(e) => setText(e.target.value)}
        placeholder="할 일을 입력하세요"
        disabled={isSubmitting}
        className={styles.input}
      />
      <button
        type="submit"
        disabled={isSubmitting || !text.trim()}
        className={styles.addButton}
      >
        {isSubmitting ? "추가 중..." : "추가"}
      </button>
    </form>
  );
}

export default AddTodoForm;
