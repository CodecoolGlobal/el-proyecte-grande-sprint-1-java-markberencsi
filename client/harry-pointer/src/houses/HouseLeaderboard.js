import CSSModules from "react-css-modules"
import styles from "./houseLeaderboard.module.css"
import { useContext, useEffect, useState } from "react"
import { HousesContext } from "./Leaderboard"

const HouseLeaderboard = () => {
    const houses = useContext(HousesContext);

    const [firstHouse, setFirstHouse] = useState({});
    const [secondHouse, setSecondHouse] = useState({});
    const [thirdHouse, setThirdHouse] = useState({});
    const [fourthHouse, setFourthHouse] = useState({});

    useEffect(() => {
            houses.sort((a, b) => a.standing > b.standing ? -1 : 1)
            setFirstHouse(houses[0]);
            setSecondHouse(houses[1]);
            setThirdHouse(houses[2]);
            setFourthHouse(houses[3]);
    }, [houses])

    return <div styleName="card">
                <div styleName="header">
                    <h3 styleName="title">Leaderboard</h3>
                </div>
                <div styleName="profile">
                    <div styleName="person second">
                        <div styleName="num">2</div>
                        <div styleName="link">{secondHouse?.name ?? ""}</div>
                        <div styleName="points">{secondHouse?.totalPoints ?? 0} pts</div>
                    </div>
                    <div styleName="person first">
                        <div styleName="num">1</div>
                        <i className="fas fa-crown"></i>
                        <div styleName="link">{firstHouse?.name ?? ""}</div>
                        <div styleName="points">{firstHouse?.totalPoints ?? 0} pts</div>
                    </div>
                    <div styleName="person third">
                        <div styleName="num">3</div>
                        <div styleName="link">{thirdHouse?.name ?? ""}</div>
                        <div styleName="points">{thirdHouse?.totalPoints ?? 0} pts</div>
                    </div>
                </div>
                <div className="rest">
                    <div styleName="others flex">
                        <div styleName="rank">
                            <div styleName="num">4</div>
                        </div>
                        <div styleName="info flex">
                        <div styleName="link">{fourthHouse?.name ?? ""}</div>
                        <div styleName="points">{fourthHouse?.totalPoints ?? 0} pts</div>
                        </div>
                    </div>
                </div>
            </div>
}

export default CSSModules(HouseLeaderboard, styles, {allowMultiple: true});