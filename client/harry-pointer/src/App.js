import './App.css';
import Navbar from './Navbar';
import{ Heading } from './Navbar';
import Houses from './houses/Houses'
import { fetchGetAll } from './houses/api/houseApi';
import { Route, BrowserRouter, Routes } from 'react-router-dom';
import {ProjectCardsFlip} from "./Teacher";

import Students from "./Students";
import Leaderboard from './houses/Leaderboard';

function App() {
  fetchGetAll();
  return (
    <div className="App">
      <BrowserRouter>
        <Navbar />
        <Routes>
          <Route exact path='/' element={<Heading />} />
          <Route path='/houses' element={<Houses />} />
          <Route path='/teachers' element={<ProjectCardsFlip/>}/>
          <Route path='/students' element={<Students />} />
          <Route path='/leaderboard' element={<Leaderboard />} />
        </Routes>
      </BrowserRouter>
    </div>
  );
}

export default App;
