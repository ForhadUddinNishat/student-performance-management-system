import React from "react";
import { searchStudents } from "../api/studentApi";

const SearchBar = ({ setStudents }) => {
  return (
    <div
      style={{
        display: "flex",
        justifyContent: "center",
        margin: "20px 0",

      }}
    >
      <input
        type="text"
        placeholder="Search"
        onChange={(e) =>
          searchStudents(e.target.value).then((res) =>
            setStudents(res.data)
          )
        }
        style={{
          width: "70%",
          maxWidth: "600px",
          fontSize: "16px",
          borderRadius: "25px",
          border: "1px solid #ccc",
          outline: "none",
          padding: "12px 16px"
        }}
      />
    </div>
  );
};

export default SearchBar;
