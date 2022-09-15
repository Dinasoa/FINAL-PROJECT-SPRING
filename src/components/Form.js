export const Form = (props) => {
    const {ref , title , subtitle , Children } = props ; 
    return(
        <>
            <div class="form" ref={secondRef}>
                <div class="title">{title}</div>
                <div class="subtitle">{subtitle}</div>
                <div class="input-container ic1">
                    <input id="firstname" class="input" type="text" placeholder="First name" />
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
                <button type="text" class="submit" onClick={hideForm}>update</button>
            </div>
        </>
    )
}