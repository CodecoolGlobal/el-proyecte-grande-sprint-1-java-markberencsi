import { useContext } from "react"
import CSSModules from "react-css-modules"
import { HouseNameContext, StudentContext } from "./Leaderboard";
import styles from "./studentLeaderboard.module.css"

const StudentLeaderboard = () => {
    const students = useContext(StudentContext);
    const houseName = useContext(HouseNameContext);

    return <div styleName="container">
                <div styleName="leaderboard">
                    <div styleName="head">
                        <h1>{houseName}</h1>
                    </div>
                    <div styleName="body">
                        <ol>
                            {
                                students
                                .sort((a, b) => a.points > b.points ? -1 : 1)
                                .map((student) => {
                                    return <li key={student.id}>
                                        <mark>{student.first_name} {student.last_name}</mark>
                                        <small>{student.points} pts</small>
                                    </li>
                                })
                            }
                        </ol>
                    </div>
                </div>
            </div>
}

export default CSSModules(StudentLeaderboard, styles, {allowMultiple: true})