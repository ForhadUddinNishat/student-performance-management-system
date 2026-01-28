
import { deleteStudent } from "../api/studentApi.js";

const StudentList = ({ students, refresh }) => {
  return (
    <div>
      <ul style={{ listStyle: "none", padding: 0 }}>
        {students.map((s) => (
          <li
            key={s.id}
            style={{
              display: "flex",
              alignItems: "center",
              justifyContent: "center",
              padding: "8px 0",
              borderBottom: "1px solid #ddd",
            }}
          >
            <span style={{ width: "25%" }}>
              <strong>{s.name}</strong>
            </span>

            <span style={{ width: "25%" }}>
              {s.course}
            </span>

            <span style={{ width: "20%" }}>
              GPA: <b>{s.gpa}</b>
            </span>

            <button onClick={() => deleteStudent(s.id).then(() => refresh())}>
              Delete
            </button>
          </li>
        ))}
      </ul>
    </div>
  );
};

export default StudentList;
