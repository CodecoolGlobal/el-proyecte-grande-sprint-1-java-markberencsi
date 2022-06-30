import { createContext, useEffect, useState } from "react"
import { fetchGetAll } from "./api/houseApi";
import CSSModules from "react-css-modules";
import styles from "./leaderboard.module.css"
import StudentLeaderboard from "./StudentLeaderboard";

export const StudentContext = createContext(null);
export const HouseNameContext = createContext(null)

const Leaderboard = () => {
    const [firstHouse, setFirstHouse] = useState({});
    const [secondHouse, setSecondHouse] = useState({});
    const [thirdHouse, setThirdHouse] = useState({});
    const [fourthHouse, setFourthHouse] = useState({});

    useEffect(() => {
        const getData = async () => {
            const data = await fetchGetAll();
            await data.sort((a, b) => a.standing > b.standing ? -1 : 1)
            setFirstHouse(data[0]);
            setSecondHouse(data[1]);
            setThirdHouse(data[2]);
            setFourthHouse(data[3]);
        }
        getData();
    }, [])

    return <div styleName="container">
                <div styleName="card">
                    <div styleName="header">
                        <h3 styleName="title">Leaderboard</h3>
                    </div>
                    <div styleName="profile">
                        <div styleName="person second">
                            <div styleName="num">2</div>
                            <div styleName="link">{secondHouse.name}</div>
                            <div styleName="points">{secondHouse.totalPoints} pts</div>
                        </div>
                        <div styleName="person first">
                            <div styleName="num">1</div>
                            <i className="fas fa-crown"></i>
                            <div styleName="link">{firstHouse.name}</div>
                            <div styleName="points">{firstHouse.totalPoints} pts</div>
                        </div>
                        <div styleName="person third">
                            <div styleName="num">3</div>
                            <div styleName="link">{thirdHouse.name}</div>
                            <div styleName="points">{thirdHouse.totalPoints} pts</div>
                        </div>
                    </div>
                    <div className="rest">
                        <div styleName="others flex">
                            <div styleName="rank">
                                <div styleName="num">4</div>
                            </div>
                            <div styleName="info flex">
                            <div styleName="link">{fourthHouse.name}</div>
                            <div styleName="points">{fourthHouse.totalPoints} pts</div>
                            </div>
                        </div>
                    </div>
                </div>
                <div styleName="students-container">
                    <StudentContext.Provider value={firstHouse?.students ?? []}>
                        <HouseNameContext.Provider value={firstHouse?.name ?? ""}>
                            <StudentLeaderboard/>
                        </HouseNameContext.Provider>
                    </StudentContext.Provider>
                    <StudentContext.Provider value={secondHouse?.students ?? []}>
                    <HouseNameContext.Provider value={secondHouse?.name ?? ""}>
                            <StudentLeaderboard/>
                        </HouseNameContext.Provider>
                    </StudentContext.Provider>
                    <StudentContext.Provider value={thirdHouse?.students ?? []}>
                    <HouseNameContext.Provider value={thirdHouse?.name ?? ""}>
                            <StudentLeaderboard/>
                        </HouseNameContext.Provider>
                    </StudentContext.Provider>
                    <StudentContext.Provider value={fourthHouse?.students ?? []}>
                    <HouseNameContext.Provider value={fourthHouse?.name ?? ""}>
                            <StudentLeaderboard/>
                        </HouseNameContext.Provider>
                    </StudentContext.Provider>
                </div>
            </div>
}

export default CSSModules(Leaderboard, styles, {allowMultiple: true})