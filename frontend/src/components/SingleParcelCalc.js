import React from "react"

const SingleParcelCalc = props =>{
    const liste = []
    for(let i=1; i < 36; i++){
        liste.push(i)
    }
    return(
        <div className ="SingleParcelCalculator">
            
            <div className ="VektWrapper">
                <div className ="KgDescriptor">Vekt på pakken</div>
                <select onChange = {props.weightHandler} className ="Kg">
                    {liste.map((el, index) =>{
                        return <option key ={index}>{el}</option>
                    })}
                </select>
            </div>
            
            <div className = "AntallWrapper">
                <div className ="AntallDescriptor">Antall pakker</div>
                <input onChange = {props.countHandler} className ="Antall" type="number" defaultValue = "1"></input>
            </div>
            <div className ="CalculatedWrapper">
                <div>Din sending vil koste {props.price} kroner</div>
                <button onClick = {props.clickHandler}>Kalkuler pris</button>
            </div>
            
        </div>
    )
}
export default SingleParcelCalc