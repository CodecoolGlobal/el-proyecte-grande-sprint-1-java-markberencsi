import React, { useEffect, useState } from "react";
import CSSModules from "react-css-modules";
import styles from "./houses.module.css"
import 'bootstrap/dist/css/bootstrap.min.css';
import { fetchGetAll } from "./api/houseApi";

const Houses = () => {
    const [houses, setHouses] = useState([]);

    useEffect(() => {
        const getData = async () => {
            const data = await fetchGetAll();
            setHouses(data);
        }
        getData();
    }, [])
    
    return  <div className="row">
                <div className="container">
                    {
                        houses.map((house) => {
                            return <div className="col-xs-6" key={house.id} styleName="box">
                                        <div styleName="inner">
                                            <a href="/" styleName="click">
                                                <div styleName="flex_this">
                                                    <h1 styleName="title">{house.name}</h1>
                                                    <p>{house.description}</p>
                                                </div>
                                            </a>
                                        </div>
                                    </div>
                        })
                    }
                    </div>
            </div>;
}

export default CSSModules(Houses, styles);