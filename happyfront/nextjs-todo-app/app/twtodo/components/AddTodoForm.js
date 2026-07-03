"use client";
import { createTodo } from "@/lib/api";
import { useRouter } from "next/navigation";
import { useState } from "react";

function AddTodoForm() {
  const [text, setText] = useState("");
  const router = useRouter();

  const handleSubmit = async (e) => {
    e.preventDefault();
    if (text.trim()) {
      await createTodo({ text, completed: false });
      setText("");
    } else {
      return;
    }
    router.refresh(); //페이지 새로고침  핵심!!!
  };
  return (
    <form className="flex gap-3 mb-5" onSubmit={handleSubmit}>
      <input
        type="text"
        className="flex-1 px-3 py-3 text-base border-2 border-gray-200 rounded-lg transition focus:outline-none focus:border-green-500 focus:ring-2 focus:ring-green-100 disabled:bg-gray-100"
        value={text}
        onChange={(e) => setText(e.target.value)}
        placeholder="할 일을 입력하세요"
      />
      <button
        type="submit"
        className="px-6 py-3 text-base font-medium text-white bg-green-500 rounded-lg transition hover:bg-green-600 disabled:bg-gray-300 disabled:cursor-not-allowed"
        disabled={!text.trim()}
      >
        추가
      </button>
    </form>
  );
}

export default AddTodoForm;
