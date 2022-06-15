import React, {useEffect, useState} from 'react';
import api from "./api";



export const TeacherList = () => {
    const [data, setData] = useState([])
    useEffect(() => {
        api.get("/api/teachers/all").then((response) => {
            setData(response.data)
        });
    }, []);
    const teachers = data
    return (
        <ol type="1">
            <> {teachers.map(teacher => <li style={{color: "white"}}  key={teacher.id}>{teacher.firstName} {teacher.lastName} is our {teacher.taughtSubject} professor, learn this subject here: <a href="#">Apply</a></li>)}</>
        </ol>
    )
};