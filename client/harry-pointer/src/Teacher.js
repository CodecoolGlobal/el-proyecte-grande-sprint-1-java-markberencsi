import React, {useEffect, useState} from 'react';
import api from "./api";
import "./teacher.css";



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

export const ProjectCardsFlip = () => {

    const [data, setData] = useState([])
    useEffect(() => {
        api.get("/api/teachers/all").then((response) => {
            setData(response.data)
        });
    }, []);
    const teachers = data

    return (
        <>
            <div className="teacherTitle"><h1>Our Teachers</h1></div>
            {teachers.map(teacher =>
        <div key={teacher.id}>
            <div className="wrapper">
                <div className="cols">
                    <div className="col" onTouchStart="this.classList.toggle('hover');">
                        <div className="container">
                            <div className="front">
                                <div className="inner">
                                    <p>{teacher.firstName} {teacher.lastName}</p>
                                    <span>{teacher.taughtSubject}</span>
                                </div>
                            </div>
                            <div className="back">
                                <div className="inner">
                                    <span>
                    Click here to apply for this subject!{" "}
                                    </span>
                                </div>
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </div>
    )}
        </>


    );
};
