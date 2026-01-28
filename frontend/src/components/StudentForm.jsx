import { useState } from "react";
import { createStudent } from "../api/studentApi";

const StudentForm = ({ refresh }) => {
  const [form, setForm] = useState({
    name: "",
    email: "",
    course: "",
    gpa: "",
  });

  const submit = (e) => {
    e.preventDefault();
    createStudent(form).then(() => {
      setForm({ name: "", email: "", course: "", gpa: "" });
      refresh();
    });
  };

  const inputStyle = {
    width: "100%",
    padding: "12px 16px",
    marginBottom: "12px",
    fontSize: "15px",
    borderRadius: "25px",
    border: "1px solid #ccc",
    outline: "none",

  };

  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        margin: "30px 0",
      }}
    >
      <form
        onSubmit={submit}
        style={{
          width: "100%",
          maxWidth: "400px",
          textAlign: "center",
        }}
      >
        <input
          placeholder="Name"
          value={form.name}
          onChange={(e) => setForm({ ...form, name: e.target.value })}
          style={inputStyle}
        />

        <input
          placeholder="Email"
          value={form.email}
          onChange={(e) => setForm({ ...form, email: e.target.value })}
          style={inputStyle}
        />

        <input
          placeholder="Course"
          value={form.course}
          onChange={(e) => setForm({ ...form, course: e.target.value })}
          style={inputStyle}
        />

        <input
          placeholder="GPA"
          value={form.gpa}
          onChange={(e) => setForm({ ...form, gpa: e.target.value })}
          style={inputStyle}
        />

        <button
          type="submit"
          style={{
            width: "70%",
            padding: "12px",
            fontSize: "16px",
            borderRadius: "25px",
            border: "none",
            backgroundColor: "#2563eb",
            color: "white",
            cursor: "pointer",
    
          }}
        >
          Add Student
        </button>
      </form>
    </div>
  );
};

export default StudentForm;
