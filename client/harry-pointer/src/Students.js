import api from "./api";
import {useEffect, useState} from "react";


const Students =  () => {

    const [data, setData] = useState([])
    const [filteredData,setFilteredData] = useState([])
    const searchItems = (searchValue) => {
        setFilteredData(data.filter((item) => {
            return Object.values(item).join('').toLowerCase().includes(searchValue.toLowerCase())
        }))
        console.log("search input: "+searchValue )
    }

    useEffect(() => {
        api.get("/api/student/all").then((response) => {
            setData(response.data)


        });
    }, []);
    const students = filteredData.length > 0 ? filteredData  : data


    return (

        <div className='p-5 text-center bg-dark' style={{
            margin: "40px 50px 0",
            borderRadius: "10px"}}>
            <h1>Our students</h1>
            <ol type="1">
                 <> {students.map(student => <li style={{color: "whitesmoke"}}  key={student.id}>{student.first_name} {student.last_name} {student.email} {student.house.name} </li>)}</>
            </ol>
        </div>

    )
}

export default Students