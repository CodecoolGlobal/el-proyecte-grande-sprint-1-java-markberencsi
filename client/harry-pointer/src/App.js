import './App.css';
import Navbar from './Navbar';
import{ Heading } from './Navbar';
import background from './hogwarts.jpg'
import Students from "./Students";

function App() {
  return (
    <div className="App" style={{ 
      backgroundImage: `url(${background})`, 
      backgroundSize:"contain", 
      backgroundRepeat: "no-repeat",
      width: "auto",
      height: "850px"
  }}>
      <Navbar />
      <Heading />
        {/*<Students  students={getStudents()}/>*/}
    </div>
  );
}

export default App;
