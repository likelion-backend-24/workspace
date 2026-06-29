import ChildrenExam from "./component/exam/ChildrenExam";
import Counter from "./component/exam/Counter";
import ParentComponent from "./component/exam/ParentComponent";
import TextInput from "./component/useState/TextInput";
import Time from "./component/useState/Time";
import UseStateExam01 from "./component/useState/UseStateExam01";
import UseStateExam02 from "./component/useState/UseStateExam02";
import Hello from "./Hello";
import Welcome from "./Welcome";

function App() {
  console.log("👍 App 컴포넌트 실행!!");
  return (
    <div className="card">
      {/* <Welcome />
      <Hello userName="김둘리" age={20} />
      <Hello userName="강경미" age={15} />
      <Hello userName="이영희" age={30} /> */}

      {/* <ChildrenExam /> */}

      {/* <UseStateExam01 />
      <br></br>
      <Time /> */}
      {/* <TextInput /> */}
      {/* <UseStateExam02 /> */}
      {/* <ParentComponent /> */}
      <Counter />
    </div>
  );
}

export default App;
