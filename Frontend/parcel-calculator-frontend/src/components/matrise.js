import React, { Component } from "react"
import ApiService from "./apiService"
import MatriseElement from "./matriseElement"
class Matrise extends Component {
    state = {
        matrisedata : [],
        tabell : null
    }
    
    componentDidMount(){
        ApiService.getPrices("mP?weight=6&count=8&prisid=1").then(response => {
        this.setState({matrisedata : response.data })
    })
    }
    
    render(){
        
       
        return(
            <div className = "MatriseWrapper">
                {(<div>
                {this.state.matrisedata.map(el =>{
                    return (<div className = "Row">
                        {el.map(mel => {
                            return <MatriseElement price = {mel}></MatriseElement>
                        })}
                    </div>)
                })}
            </div>)}
            </div>
        )
    }
    
}

export default Matrise