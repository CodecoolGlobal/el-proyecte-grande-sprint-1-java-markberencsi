import api from "./api";
import {useEffect, useState} from "react";


const Students =  () => {
    const [data, setData] = useState([])
    useEffect(() => {
        api.get("/api/student/all").then((response) => {
            setData(response.data)


        });
    }, []);
    const students = data
    return (
        <ol type="1">
            <> {students.map(student => <li style={{color: "white"}}  key={student.id}>{student.firstName} {student.lastName} {student.email}</li>)}</>
        </ol>
    )
}

export default Students