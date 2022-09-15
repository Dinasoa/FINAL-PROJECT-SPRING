import '../styles/Home.css' ;
import { Link, useNavigate } from "react-router-dom";
import { Scholarship } from './Scholarship';
import { Navbar } from './Navbar';

export const Home = () => {
    const navigate = useNavigate()
    return (
        <>
            <div className='bg'>
                <Navbar/>
                <div className="center__title">
                    <h1 className="title">Get scholarship</h1>
                    <button className="btn btn-primary" onClick={() => navigate("/Scholarship")}>
                        Scholarship List
                    </button>
                </div>
            </div>
        </>
    )
}