import React, { useEffect, useState } from "react";
import "./houses.css"
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
                            return <div className="box col-xs-6" key={house.id}>
                                        <div className="inner">
                                            <a href="/" className="click">
                                                <div className="flex_this">
                                                    <h1 className="title">{house.name}</h1>
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

export default Houses;