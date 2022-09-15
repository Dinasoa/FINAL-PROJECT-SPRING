import { ScholarshipContainer } from "./ScholarshipContainer"
import { Navbar } from "./Navbar"
import React, { useState, useEffect, useRef } from 'react';
import { useNavigate } from 'react-router-dom';
import axios from 'axios';
import '../styles/criteria.css'


const baseURL = `http://localhost:8080/criterias?pageNumber=1&pageSize=10`;

export const Criteria = () => {
    const navigate = useNavigate();
    const [result, setResult] = useState();
    const [idCriteria, setIdCriteria] = useState();
    const [criteriaDescription, setCriteriaDescription] = useState();
    const ref = useRef(null);
    const secondRef = useRef(null);
    useEffect(() => {
        axios.get(baseURL).then((response) => {
            setResult(response.data);
            console.log(result)
        })
            .catch(error => console.log(error));
    }, []);

    const displayForm = () => {
        setCriteriaDescription(criteriaDescription)
        setIdCriteria(idCriteria)
        ref.current.style.display = 'block'
    }



    const hideForm = () => {
        ref.current.style.display = 'none'
        secondRef.current.style.display = 'none'

    }

    const postCriteria = () => {
        displayForm();
        const promise = axios.post(
            `http://localhost:8080/criterias`, {
            "criteriaDescription": criteriaDescription
        });

        promise
            .then((response) => {
                console.log(response);
                alert("Criteria has been created successfully")
            })
            .catch((error) => {
                console.error(error);
            })
        hideForm();
    }

    const displayPutForm = () => {
        setCriteriaDescription(criteriaDescription)
        setIdCriteria(idCriteria)
        secondRef.current.style.display = "block";
    }

    const putCriteria = () => {
        const promise = axios.put(
            `http:///localhost/criteria/1`, {
            "idCriteria": 1,
            "criteriaDescription": "criteriaDescription"
        });
        promise
            .then((response) => {
                console.log(response);
                alert("Criteria has been updated successfully")
            })
            .catch((error) => {
                console.error(error);
            })
        hideForm();
    }
    const data = {
        "idCriteria": idCriteria,
        "scholarshipDescription": criteriaDescription
    }

    const deleteScholarshipById = (id) => {
        const promise = axios.delete(
            `http://localhost:8080/criterias/${id}}`);
        promise
            .then((response) => {
                console.log(response);
                alert('success')
            })
            .catch((error) => {
                console.error(error);
            })
    }

    return (
        <>
            
            <div className="bg table-wrapper">
            <Navbar Children={<button className="btn btn-primary" onClick={displayForm}>ADD CRITERIA</button>} />
                <table className="table table-striped table-dark table-bordered fl-table container" onClick={displayPutForm}>
                    <thead>
                        <tr>
                            <th>id</th>
                            <th>Scholarship Description</th>
                            <th>Delete</th>
                        </tr>
                    </thead>

                    <tbody>
                        {
                            (result || []).map((item) => (
                                <tr>
                                    <td>{item?.idCriteria}</td>
                                    <td>{item?.criteriaDescription}</td>
                                    <td><svg onCLick={deleteScholarshipById(item?.idCriteria)} className="delete" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                                        <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z" />
                                    </svg></td>
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
                <div class="title">Create criteria</div>
                <div class="subtitle">PS: criteria id is not mandatory to create a criteria</div>
                <div class="input-container ic1">

                    <label>Criteria Description</label>
                    <input id="firstname" class="input" type="text" placeholder="Criteria description" value={criteriaDescription} onChange={(e) => setCriteriaDescription(e.target.value)} />
                    <div class="cut"></div>
                </div>
                <button type="text" class="submit" onClick={postCriteria}>submit</button>
            </div>

            <div class="form formulaire" ref={secondRef}>
                <svg onClick={hideForm} className="closing" xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-x-circle" viewBox="0 0 16 16">
                    <path d="M8 15A7 7 0 1 1 8 1a7 7 0 0 1 0 14zm0 1A8 8 0 1 0 8 0a8 8 0 0 0 0 16z" />
                    <path d="M4.646 4.646a.5.5 0 0 1 .708 0L8 7.293l2.646-2.647a.5.5 0 0 1 .708.708L8.707 8l2.647 2.646a.5.5 0 0 1-.708.708L8 8.707l-2.646 2.647a.5.5 0 0 1-.708-.708L7.293 8 4.646 5.354a.5.5 0 0 1 0-.708z" />
                </svg>
                <div class="title">Update criteria</div>
                <div class="subtitle">Let's update your criteria</div>
                <div class="input-container ic1">

                    <label>Criteria ID</label>
                    <input id="firstname" class="input" type="text" placeholder="Criteria description" onChange={(e) => setCriteriaDescription(e.target.value)} />
                    <div class="cut"></div>
                </div>
                <div class="input-container ic1">

                    <label>Criteria Description</label>
                    <input id="firstname" class="input" type="text" placeholder="Criteria description" onChange={(e) => setCriteriaDescription(e.target.value)} />
                    <div class="cut"></div>
                </div>
                <button type="text" class="submit" onClick={putCriteria}>UPDATE</button>
            </div>

        </>
    )
}