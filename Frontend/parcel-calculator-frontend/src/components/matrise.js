import React, { Component } from "react"
import ApiService from "./apiService"
import MatriseElement from "./matriseElement"
class Matrise extends Component {
    state = {
        matrisedata : [],
        tabell : null
    }
    pakker = [1,2,3,4,5]
    componentDidMount(){
        ApiService.getPrices("mp?weight=10&count=5&prisid=1").then(response => {
        this.setState({matrisedata : response.data })
    })
    }

    render(){
        
       
        return(
            <div className = "MatriseWrapper">
                {(<div>
                    <div className ="Row">
                        <div className = "MatriseElement">-</div>
                        {this.pakker.map(el =>{
                            return <div className = "MatriseElement">Antall Pakker: {el}</div>
                        })}
                    </div>
                    {this.state.matrisedata.map((el, index) =>{
                    return (<div className = "Row"><div className = "MatriseElement"> Vekt i kg {index+1} </div>
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