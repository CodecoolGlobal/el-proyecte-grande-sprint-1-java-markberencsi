import './App.css';
import Navbar from './Navbar';
import{ Heading } from './Navbar';
import background from './hogwarts.jpg'

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
    </div>
  );
}

export default App;
