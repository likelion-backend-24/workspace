import Image from "next/image";
import Link from "next/link";

export default function Home() {
  return (
    <div className="flex flex-col flex-1 items-center justify-center bg-zinc-50 font-sans dark:bg-black">
      <h1>Next.js Todo App</h1>
      <p>React Todo App을 Next.js로 업그레이드했습니다!</p>

      {/* Next.js의 Link 컴포넌트 */}
      <Link href="/todos">📝 Todo App 시작하기</Link>
    </div>
  );
}
