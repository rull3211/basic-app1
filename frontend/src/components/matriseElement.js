import React from "react"

const MatriseElement = props =>{


    return(
        <div key = {props.k} className = "MatriseElement">
            {props.price},-
        </div>
    )

}

export default MatriseElement