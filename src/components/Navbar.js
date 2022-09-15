
import { Children } from "react";
import { Link, useNavigate } from "react-router-dom";

export const Navbar = (props) => {
    const {Children} = props 
    const navigate = useNavigate()
    return (
        <>
            <nav className="navbar navbar-expand-lg navbar-light bg-light">
                <button className="navbar-toggler" type="button" data-toggle="collapse" data-target="#navbarTogglerDemo01" aria-controls="navbarTogglerDemo01" aria-expanded="false" aria-label="Toggle navigation">
                    <span className="navbar-toggler-icon"></span>
                </button>
                <div className="collapse navbar-collapse" id="navbarTogglerDemo01">
                    <Link to="/" className="navbar-brand">Study abroad</Link>
                    <ul className="navbar-nav mr-auto mt-2 mt-lg-0">
                        <li className="nav-item active">
                            <Link to="/scholarship" className='nav-link'>Scholarship</Link>
                        </li>
                        <Link to="/applicants" className='nav-link'>List Applicants</Link>
                        <Link to="/criterias" className="nav-link">Criteria List</Link>
                        <button className="btn btn-primary connection__btn"
                            onClick={() => navigate("/login")}
                        >
                            Se connecter
                        </button>
                        {Children}
                    </ul>
                </div>
               
            </nav>
        </>
    )
}