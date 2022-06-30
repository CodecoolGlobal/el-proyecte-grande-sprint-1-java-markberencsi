import { createContext, useEffect, useState } from "react"
import { fetchGetAll } from "./api/houseApi";
import CSSModules from "react-css-modules";
import styles from "./leaderboard.module.css"
import StudentLeaderboard from "./StudentLeaderboard";
import HouseLeaderboard from "./HouseLeaderboard";

export const StudentContext = createContext(null);
export const HouseNameContext = createContext(null);
export const HousesContext = createContext(null);

const Leaderboard = () => {
    const [houses, setHouses] = useState([]);

    useEffect(() => {
        const getData = async () => {
            const data = await fetchGetAll();
            setHouses(data);
        }
        getData();
    }, [])

    return <div styleName="container">
                <HousesContext.Provider value={houses}>
                    <HouseLeaderboard />
                </HousesContext.Provider>
                
                <div styleName="students-container">
                    {
                        houses.map((house) => {
                            return <StudentContext.Provider value={house?.students ?? []} key={house?.id ?? ""}>
                                        <HouseNameContext.Provider value={house?.name ?? ""}>
                                            <StudentLeaderboard/>
                                        </HouseNameContext.Provider>
                                    </StudentContext.Provider>
                        })
                    }
                </div>
            </div>
}

export default CSSModules(Leaderboard, styles, {allowMultiple: true})