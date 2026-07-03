"use client";
import { deleteTodo } from "@/lib/api";
import { useRouter } from "next/navigation";

function DeleteButton({ id }) {
    const router = useRouter();
    const handleDelete = async () => {
        await deleteTodo(id);
        router.refresh();
    };

    return(
        <button className="px-4 py-2 text-sm text-white bg-red-500 rounded-md transition hover:bg-red-600" onClick={handleDelete}>삭제</button>
    );
}

export default DeleteButton;