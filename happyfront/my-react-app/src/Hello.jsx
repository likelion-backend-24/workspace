function Hello({ userName, age }) {
  //   const userName = "carami";
  //   const age = 20;
  return (
    <div>
      <h2>hello~~~!!{userName}</h2>
      <p>성인여부:{age > 20 ? "성인" : "미성년자"}</p>
    </div>
  );
}

export default Hello;
