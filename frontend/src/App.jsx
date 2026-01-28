import StudentList from "./components/StudentList.jsx";
import StudentForm from "./components/StudentForm.jsx";
import SearchBar from "./components/SearchBar.jsx";

import { useState, useEffect } from "react";
import { getStudents } from "./api/studentApi";

export default function App() {
  const [students, setStudents] = useState([]);

  const load = () => {
    getStudents().then((res) => {
      setStudents(res.data.content);
    });
  };

  useEffect(load, []);

  return (
    <div>
      <h1 style={{ textAlign: "center", marginBottom: "20px" }}>
        Student Management
      </h1>

      <SearchBar setStudents={setStudents} />

      <StudentForm refresh={load} />

      <StudentList students={students} refresh={load} />
    </div>
  );
}
