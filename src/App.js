import './App.css';
import { Home } from './components/Home';
import { BrowserRouter as Router, Route, Routes } from "react-router-dom";
import { Scholarship } from './components/Scholarship';
import { Login } from './components/LoginPage';
import { Applicant } from './components/Applicant';
import { Criteria } from './components/Criteria';

function App() {
  return (
  <>
    <Router>
        <Routes>
          <Route path="/" element={<Home />} />
          <Route path="/scholarship" element={<Scholarship />} />
          <Route path="/login" element={<Login/>} />
          <Route path="/applicants" element={<Applicant/>} />
          <Route path="/criterias" element={<Criteria/>} />
        </Routes>
    </Router>
  </>
  );
}

export default App;
