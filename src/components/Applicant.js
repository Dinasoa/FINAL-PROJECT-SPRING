import { Navbar } from "./Navbar"
import React, { useState, useEffect, useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import '../styles/Applicant.css'

const baseURL = `http://localhost:8080/applicants?pageSize=6&page=1`;

export const Applicant = () => {
    const navigate = useNavigate();
    const [result, setResult] = useState();
    const [page, setPage] = useState(1);
    const [idApplicant, setIdApplicant] = useState();
    const [firstName, setFirstName] = useState();
    const [lastName, setLastName] = useState();
    const [email, setEmail] = useState();
    const [degree, setDegree] = useState();
    const [birthdate, setBirthdate] = useState();
    const [lastAverage, setLastAverage] = useState();
    const [scholarshipIds, setScholarshipIds] = useState();

    const ref = useRef(null);


    useEffect(() => {
        axios.get(baseURL).then((response) => {
            setResult(response.data);
            console.log(result)
        })
            .catch(error => console.log(error));
    }, []);

    const Increment = () => {
        setPage(page + 1);
    }

    function Decrement() {
        if (page >= 2) {
            setPage(page - 1);
        }
    }

    const displayForm = (idApplicant, firstName, lastName, email, degree, birthdate, lastAverage, scholarshipIds) => {
        ref.current.style.display = 'block'
        setIdApplicant(idApplicant)
        setLastName(lastName)
        setFirstName(firstName)
        setEmail(email)
        setDegree(degree)
        setBirthdate(birthdate)

    }

    const hideForm = () => {
        ref.current.style.display = 'none'
    }

    return (
        <>
            <div className="bg bgs table-wrapper">
            <Navbar />
                <table className="table table-striped table-dark table-bordered fl-table container" onClick={displayForm}>
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Fist Name</th>
                            <th>Last Name</th>
                            <th>Degree</th>
                            <th>Email</th>
                            <th>Last average</th>
                            <th>Birthdate</th>
                            <th>Status</th>
                            <th>Scholarship</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            (result || []).map((item) => (
                                <tr key={`${item.idApplicant}`}>
                                    <td>{item?.idApplicant}</td>
                                    <td>{item?.firstName}</td>
                                    <td>{item?.lastName}</td>
                                    <td>{item?.degree}</td>
                                    <td>{item?.email}</td>
                                    <td>{item?.lastAverage}</td>
                                    <td>{item?.birthdate}</td>
                                    <td>{item?.status}</td>
                                    <td>{item?.scholarshipIds}</td>
                                </tr>
                            ))
                        }
                    </tbody>
                </table>
            </div>


            <div class="form formulaire" ref={ref}>
                <svg onClick={hideForm} className="closing" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
                    <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
                </svg>
                <div class="title">Postulate to {scholarshipIds}</div>
                <div class="subtitle">Let's create your account!</div>
                <div class="input-container ic1">
                    <input id="firstname" class="input" type="text" value={firstName} placeholder="First name" />
                    <div class="cut"></div>
                    <label for="firstname" class="placeholder" />
                </div>
                <div class="input-container ic2">
                    <input id="lastname" class="input" type="text" placeholder="Last name" />
                    <div class="cut"></div>
                    <label for="lastname" class="placeholder">Last name</label>
                </div>
                <div class="input-container ic2">
                    <input id="email" class="input" type="text" placeholder="email" />
                    <div class="cut cut-short"></div>
                    <label for="email" class="placeholder" value="email" />
                </div>
                <button type="text" class="submit" onClick={hideForm}>submit</button>
            </div>


        </>
    )
}

