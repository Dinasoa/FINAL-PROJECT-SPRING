import { Link } from "react-router-dom"
import { Navbar } from "./Navbar"
import '../styles/Scholarship.css';
import { ScholarshipContainer } from "./ScholarshipContainer";
import { useEffect, useRef, useState } from "react";
import axios from "axios";
import Pagination from "./Pagination";

const baseURL = `http://localhost:8080/scholarships?pageSize=6&pageNumber=1`;
const baseURL1 = `http://localhost:8080/criterias?pageSize=6&pageNumber=1`;

export const Scholarship = () => {
    const [scholarshipData, setScholarshipData] = useState();
    const [idScholarship , setIdScholarship] = useState() ;
    const [scholarshipTitle, setScholarshipTitle] = useState("");
    const [scholarshipDescription, setScholarshipDescription] = useState("");
    const [university, setUniversity] = useState("");
    const [degree, setDegree] = useState("");
    const [branch, setBranch] = useState("");
    const [country, setCountry] = useState("");
    const [amount, setAmount] = useState(0);
    const [benefits, setBenefits] = useState("");
    const [dateLimit, setDateLimit] = useState();
    const [criteria, setCriteria] = useState([{}]);
    const [minimumAverage, setMinimumAverage] = useState("")
    const [scholarshipId, setScholarshipId] = useState();
    const [idCriteria, setIdCriteria] = useState();
    const [criteriaDescription, setCriteriaDescription] = useState();
    const ref = useRef(null);
    const update = useRef(null);
    const postRef = useRef(null);
    const criteriaRef = useRef(null);
    const [datas, setDatas] = useState();
    const [page, setPage] = useState(0);
    useEffect(() => {
        axios.get(baseURL).then((response) => {
            setScholarshipData(response.data);
            console.log(scholarshipData)
        })
            .catch(error => console.log(error));
        const criteria = axios.get(baseURL1);
        criteria.then((res) => setDatas(res.data))
            .catch((err) => console.log(err))
    }, [] , page , setPage , scholarshipData);

    const displayCard = (scholarshipTitle, univ, scholarshipDescription, degree, branch, country, amount, benefits, dateLimit, criteria, minimumAverage) => {
        setScholarshipTitle(scholarshipTitle)
        setUniversity(univ)
        setScholarshipDescription(scholarshipDescription)
        setDegree(degree)
        setBranch(branch)
        setCountry(country)
        setAmount(amount)
        setBenefits(benefits)
        setDateLimit(dateLimit)
        setCriteria(criteria)
        setMinimumAverage(minimumAverage)
        ref.current.style.display = "block";
    }

    const hideCard = () => {
        ref.current.style.display = 'none'
    }

    const hideForm = () => {
        update.current.style.display = 'none'
        postRef.current.style.display = 'none'
        ref.current.style.display = 'none'
        criteriaRef.style.display = 'none'
    }

    const updateScholarship = () => {
        update.current.style.display = 'none'
        const promise = axios.put(
            `http://localhost:8080/scholarships/9`, {
                "id": 9,
                "scholarshipTitle": scholarshipTitle,
                "scholarshipDescription": scholarshipDescription,
                "university": university,
                "degree": degree,
                "branch": branch,
                "country": country,
                "amount": amount,
                "benefits": benefits,
                "dateLimit": dateLimit,
                "minimumAverage": minimumAverage ,
                "criteria": minimumAverage
        });
        promise
            .then((response) => {
                console.log(response);
            })
            .catch((error) => {
                console.error(error);
            })
        // .finally(() => {
        //     // CleanningForms();
        // })
        hideForm();
    }
    const data = {
        "scholarshipTitle": scholarshipTitle,
        "scholarshipDescription": scholarshipDescription,
        "university": university,
        "degree": degree,
        "branch": branch,
        "country": country,
        "amount": amount,
        "benefits": benefits,
        "dateLimit": dateLimit,
        "minimumAverage": minimumAverage,
        "criteria": criteria
    }


    const postScholarship = () => {
        const promise = axios.post(
            `http://localhost:8080/scholarships`, {
            "scholarshipTitle": "scholarshipTitle",
            "scholarshipDescription": scholarshipDescription,
            "university": university,
            "degree": degree,
            "branch": branch,
            "country": country,
            "amount": amount,
            "benefits": benefits,
            "dateLimit": dateLimit,
            "minimumAverage": minimumAverage,
            "criteria": criteria
        });

        promise
            .then((response) => {
                console.log(response);
                alert('success')
            })
            .catch((error) => {
                console.error(error);
            })
        postRef.current.style.display = 'none';
    }

    const addingCriteriaInScholarship = (id) => {
        const promise = axios.post(
            `http://localhost:8080/scholarships/postCriteriaInScholarship/${id}`, {
            "idCriteria": scholarshipTitle,
            "criteriaDescription": scholarshipDescription
        });
        promise
            .then((response) => {
                console.log(response);
                alert('success')
            })
            .catch((error) => {
                console.error(error);
            })
        hideForm();
    }

    const displayForm = (scholarshipTitle, univ, scholarshipDescription, degree, branch, country, amount, benefits, dateLimit, criteria, minimumAverage) => {
        update.current.style.display = 'block'
        setScholarshipTitle(scholarshipTitle)
        setUniversity(univ)
        setScholarshipDescription(scholarshipDescription)
        setDegree(degree)
        setBranch(branch)
        setCountry(country)
        setAmount(amount)
        setBenefits(benefits)
        setDateLimit(dateLimit)
        setCriteria(criteria)
        setMinimumAverage(minimumAverage)
    }

    const deleteScholarhsipById = (id) => {
    //     const promise = axios.delete(`http://localhost:8080/scholarships/${id}}`);
        
    // hideForm();
    }


    const addingScholarship = () => {
        postRef.current.style.display = "block"
    }

    const displayCriteriaForm = (idScholarship , idCriteria , criteriaDescription) => {
        criteriaRef.current.style.display = "block"
        setIdScholarship(idScholarship)
    }




    return (
        <>
            <div className='bg-scholarship'>
                <Navbar
                    Children={<button className="btn btn-primary" onClick={addingScholarship}>ADD SCHOLARSHIP</button>}

                />
                <div className="container">
                    <div className="row">
                        {
                            console.log(scholarshipData)
                        }
                        {(scholarshipData || []).map((item) => (
                            <>
                                <ScholarshipContainer
                                    scholarshipId={item?.id}
                                    scholarshipDescription={item?.scholarshipDescription}
                                    title={item?.scholarshipTitle}
                                    university={item?.university}
                                    amount={item?.amount + "$"}
                                    branch={item?.branch}
                                    country={item?.country}
                                    degree={item?.degree}
                                    benefits={item?.benefits}
                                    criteria={
                                        ((item.criteria).map((criteria) => {
                                            return <li className="widget-49-meeting-item"><span>{criteria.criteriaDescription}</span></li>
                                        }))
                                    }
                                    dateLimit={item?.dateLimit}
                                    minimumAverage={item?.minimumAverage}
                                    Children=
                                    {
                                        <>
                                            <svg className="delete" onClick={deleteScholarhsipById(item?.id)} xmlns="http://www.w3.org/2000/svg" width="16" height="16" fill="currentColor" class="bi bi-trash-fill" viewBox="0 0 16 16">
                                                <path d="M2.5 1a1 1 0 0 0-1 1v1a1 1 0 0 0 1 1H3v9a2 2 0 0 0 2 2h6a2 2 0 0 0 2-2V4h.5a1 1 0 0 0 1-1V2a1 1 0 0 0-1-1H10a1 1 0 0 0-1-1H7a1 1 0 0 0-1 1H2.5zm3 4a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 .5-.5zM8 5a.5.5 0 0 1 .5.5v7a.5.5 0 0 1-1 0v-7A.5.5 0 0 1 8 5zm3 .5v7a.5.5 0 0 1-1 0v-7a.5.5 0 0 1 1 0z" />
                                            </svg>
                                            <button onClick={() => displayCard(item?.scholarshipTitle, item?.university, item?.benefits, item?.degree, item?.branch, item?.country, item?.amount, item?.scholarshipDescription, item?.dateLimit, item?.criteria, item?.minimumAverage)} className="btn btn-sm btn-secondary">View All</button>

                                            <button onClick={() => displayCriteriaForm(item?.idScholarship , criteria?.criteriaDescription, criteria?.idCriteria)} className="btn btn-sm btn-primary">Add criteria</button>

                                            <button onClick={() => displayForm(item?.scholarshipTitle, item?.university, item?.benefits, item?.degree, item?.branch, item?.country, item?.amount, item?.scholarshipDescription, item?.dateLimit, item?.criteria, item?.minimumAverage)} className="btn btn-sm btn-secondary">Update</button>
                                        </>
                                    }
                                />
                            </>


                        ))}
                        <Pagination page={page} setPage={setPage} data={scholarshipData}/>

                        <div className="containerr" ref={ref}>
                            <div class="card text-center">
                                <div class="card-header">
                                    {scholarshipTitle}
                                </div>
                                <div class="card-body">
                                    <h5 class="card-title">{university} of {country} </h5>
                                    <p class="card-text">Date limit : {dateLimit}</p>
                                    <p>{amount}$ | {degree} | {branch}</p>
                                    <p class="card-text">Average minimum required: {minimumAverage}</p>
                                    <p class="card-text">{scholarshipDescription}</p>
                                    <p class="card-text">{benefits}</p>
                                    <button href="#" class="btn btn-primary" onClick={() => hideCard()}>See less</button>
                                </div>
                                <div class="card-footer text-muted">
                                    2 days ago
                                </div>
                            </div>
                        </div>
                    </div>
                </div>

                <div class="form" ref={update}>
                    <button type="button" class="btn-close" onClick={hideForm} aria-label="Close"></button>

                    <div class="title">Update this scholarship</div>
                    <div class="subtitle">Let's create your account!</div>
                    <div class="input-container ic1">
                        <label>Scholarship Title</label>
                        <input id="firstname" class="input" type="text" value={scholarshipTitle} onChange={(e) => setScholarshipTitle(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>University</label>
                        <input id="lastname" class="input" type="text" value={university} onChange={(e) => setUniversity(e.target.value)} />
                    </div>

                    <div class="input-container ic2">
                        <label>Country</label>
                        <input id="lastname" class="input" type="text" value={country} onChange={(e) => setCountry(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Scholarship Description</label>
                        <textarea id="lastname" class="input" type="text" value={scholarshipDescription} onChange={(e) => setScholarshipDescription(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Branch</label>
                        <input id="lastname" class="input" type="text" value={branch} onChange={(e) => setBranch(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Degree</label>
                        <input id="lastname" class="input" type="text" value={degree} onChange={(e) => setDegree(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Amount</label>
                        <input id="lastname" class="input" type="text" value={amount} onChange={(e) => setAmount(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Date Limit</label>
                        <input id="lastname" class="input" type="text" value={dateLimit} onChange={(e) => setDateLimit(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Benefits</label>
                        <input id="lastname" class="input" type="text" value={benefits} onChange={(e) => setBenefits(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Minimum average</label>
                        <input id="lastname" class="input" type="text" value={minimumAverage} onChange={(e) => setMinimumAverage(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Criterias</label>
                        <select name="cars" id="cars" value={console.log(criteria)} onChange={(e) => { setCriteria(e.target.value) }}>
                            {(datas || []).map((elt, key) => (
                                <option value={elt?.idCriteria}>{elt?.criteriaDescription}</option>
                            ))}
                        </select>
                    </div>

                    <button type="text" class="submit" onClick={updateScholarship}>UPDATE</button>
                </div>
                <button type="button" class="btn-close hideForm" aria-label="Close"></button>

                <div class="form" ref={postRef}>
                    <button type="button" class="btn-close hideForm" aria-label="Close"></button>

                    <div class="title">Create Scholarhip</div>
                    <div class="subtitle">Let's create your account!</div>
                    <div class="input-container ic1">
                        <label>Scholarship Title</label>
                        <input id="firstname" class="input" type="text" placeholder="scholarship title" value={scholarshipTitle} onChange={(e) => setScholarshipTitle(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>University</label>
                        <input id="lastname" class="input" type="text" placeholder="university" value={university} onChange={(e) => setUniversity(e.target.value)} />
                    </div>

                    <div class="input-container ic2">
                        <label>Country</label>
                        <input id="lastname" class="input" type="text" placeholder="country" value={country} onChange={(e) => setCountry(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Scholarship Description</label>
                        <textarea id="lastname" class="input" type="text" placeholder="scholarship description" value={scholarshipDescription} onChange={(e) => setScholarshipDescription(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Branch</label>
                        <input id="lastname" class="input" type="text" placeholder="branch" value={branch} onChange={(e) => setBranch(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Degree</label>
                        <input id="lastname" class="input" type="text" placeholder="degree" value={degree} onChange={(e) => setDegree(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Amount</label>
                        <input id="lastname" class="input" type="text" placeholder="amount" value={amount} onChange={(e) => setAmount(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Date Limit</label>
                        <input id="lastname" class="input" type="text" placeholder="date limit" value={dateLimit} onChange={(e) => setDateLimit(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Benefits</label>
                        <input id="lastname" class="input" type="text" placeholder="benefits" value={benefits} onChange={(e) => setBenefits(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Minimum average</label>
                        <input id="lastname" class="input" type="text" placeholder="minimum average" value={minimumAverage} onChange={(e) => setMinimumAverage(e.target.value)} />
                    </div>
                    <div class="input-container ic2">
                        <label>Criterias</label>
                        <select name="cars" id="cars" value={criteria} onChange={(e) => { setCriteria(e.target.value) }}>
                            {(datas || []).map((elt, key) => (
                                <option value={elt?.idCriteria}>{elt?.criteriaDescription}</option>
                            ))}
                        </select>
                    </div>

                    <button type="text" class="submit" onClick={postScholarship}>Create</button>
                    <button type="text" class="submit" onClick={hideCard}>Cancel</button>
                </div>

                <div class="form criteriaForm" ref={criteriaRef}>
                    <button type="button" onClick={hideForm} class="btn-close hideForm" aria-label="Close"></button>
                    <div class="title">Adding Criteria in scholarship</div>
                    <div class="input-container ic2">
                        <label>Criterias</label>
                        <select name="cars" id="cars" value={console.log(criteria)} onChange={(e) => { setCriteria(e.target.value) }}>
                            {(datas || []).map((elt, key) => (
                                <option value={elt?.idCriteria}>{elt?.criteriaDescription}</option>
                            ))}
                        </select>
                    </div>
                    <button type="text" class="submit" onClick={addingCriteriaInScholarship}>Create</button>
                </div>
            </div>


        </>
    )
}