import { useEffect, useState } from "react";
import CSSModules from "react-css-modules";
import { useParams } from "react-router-dom"
import { fetchGetByName } from "./api/houseApi";
import styles from "./houseDetail.module.css"
import { HouseNameContext, StudentContext } from "./Leaderboard";
import StudentLeaderboard from "./StudentLeaderboard";

const HouseDetail = (props) => {
    const {name} = useParams();
    const [house, setHouse] = useState({});

    useEffect(() => {
        const getData = async () => {
            const data = await fetchGetByName(props.name);
            setHouse(data);
        }
        getData();
    }, [props.name])

    props.name = name;

    return <div>
        <header>
            <div styleName="header-title">
                {house.name}
            </div>
        </header>
        <section styleName="content-block">
            <div styleName="container">
                <p>{house.description}</p>
            </div>
        </section>
        <div styleName="student-container">
            <StudentContext.Provider value={house?.students ?? []}>
                <HouseNameContext.Provider value={house?.name ?? ""}>
                    <StudentLeaderboard/>
                </HouseNameContext.Provider>
            </StudentContext.Provider>
        </div>
    </div>
}

export default CSSModules(HouseDetail, styles, {allowMultiple: true})