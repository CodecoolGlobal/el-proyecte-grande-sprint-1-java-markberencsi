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

        <div className='p-5 text-center bg-dark' style={{
            margin: "40px 50px 0",
            borderRadius: "10px"}}>
            <h1>Our students</h1>
            <ol type="1">
                <> {students.map(student => <li style={{color: "whitesmoke"}}  key={student.id}>{student.firstName} {student.lastName} {student.email}</li>)}</>
            </ol>
        </div>

    )
}

export default Students