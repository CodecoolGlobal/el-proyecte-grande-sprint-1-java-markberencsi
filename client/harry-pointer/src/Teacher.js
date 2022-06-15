import React, {useEffect, useState} from 'react';
import api from "./api";
import style from "./teacher.module.css";



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
            <div className={style.teacherTitle}><h1>Our Teachers</h1></div>
            {teachers.map(teacher =>
        <div key={teacher.id}>
            <div className={style.wrapper}>
                <div className={style.cols}>
                    <div className={style.col} onTouchStart="this.classList.toggle('hover');">
                        <div className={style.container}>
                            <div className={style.front}>
                                <div className={style.inner}>
                                    <p>{teacher.firstName} {teacher.lastName}</p>
                                    <span>{teacher.taughtSubject}</span>
                                </div>
                            </div>
                            <div className={style.back}>
                                <div className={style.inner}>
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
