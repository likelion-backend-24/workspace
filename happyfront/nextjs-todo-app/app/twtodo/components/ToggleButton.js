"use client";

import { toggleTodo } from "@/lib/api";
import { useRouter } from "next/navigation";

function ToggleButton({ id, completed }) {
    const router = useRouter();

    const handleToggle = async () => {
        await toggleTodo(id);
        router.refresh();
    };

    return(
        <input
            type="checkbox"
            className="w-5 h-5 accent-green-500 cursor-pointer"
            checked={completed}
            onChange={handleToggle}
            aria-label="할 일 완료 토글"
        />
    );
}

export default ToggleButton;