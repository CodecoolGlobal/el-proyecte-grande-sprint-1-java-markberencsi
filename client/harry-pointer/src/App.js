import './App.css';
import Navbar from './Navbar';
import{ Heading } from './Navbar';
import background from './hogwarts.jpg'
import Houses from './houses/Houses'
import { fetchGetAll } from './houses/api/houseApi';
import { Route, BrowserRouter, Routes } from 'react-router-dom';

import Students from "./Students";

function App() {
  fetchGetAll();
  return (
    <div className="App" style={{ 
        backgroundImage: `url(${background})`,
        backgroundSize:"contain",
        backgroundRepeat: "no-repeat",
        width: "auto",
        height: "850px"
    }}>
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route exact path='/' element={<Heading />} />
          <Route path='/houses' element={<Houses />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
