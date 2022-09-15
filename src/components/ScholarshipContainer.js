import '../styles/Scholarship.css'

export const ScholarshipContainer = (props) => {
    const { idScholarship , title, university, country, branch, amount, criteria , degree , Children , dateLimit , minimumAverage} = props
    

    return (
        <>
            <div className="col-lg-4 fix-card">
                <div className="card card-margin">
                    <div className="card-header no-border">
                        <h5 className="card-title">{title}</h5>
                        <p>{idScholarship}</p>
                    </div>
                    <div className="card-body pt-0">
                        <div className="widget-49">
                            <div className="widget-49-title-wrapper">
                                <div className="widget-49-date-primary">
                                    <span className="widget-49-date-day">09</span>
                                    <span className="widget-49-date-month">apr</span>
                                </div>
                                <div className="widget-49-meeting-info">
                                    <span className="widget-49-pro-title">{university} at {country}</span>
                                    <span className="widget-49-meeting-time">{branch} | {degree} | {amount}</span>
                                    <span className="widget-49-meeting-time">Limit date : {dateLimit}</span>                                
                                    <span className="widget-49-meeting-time">minimum average : {minimumAverage}</span>                                
                                </div>
                            </div>
                            <ol className="widget-49-meeting-points">
                              
                                {criteria}
                            </ol>
                            <div className="widget-49-meeting-action">
                                {Children}
                            </div>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}