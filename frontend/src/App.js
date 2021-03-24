
import { Component } from 'react';
import './App.css';
import Matrise from "./components/matrise"
import SingleParcelCalc from './components/SingleParcelCalc';
import ApiService from "./components/apiService"
import postenLogo from "./Logos/Posten-Norge-Logo.svg"
class App extends Component{

  state = {
    weight : 1,
    count : 1,
    price : 65
  }

  weightHandler = (event) =>{
    this.setState({weight: event.target.value})
  }
  countHandler = (event) =>{
    this.setState({count: Math.round(parseFloat(event.target.value))})
  }
  clickHandler = (event) =>{
    ApiService.getPrices(`sp?weight=${this.state.weight}&count=${this.state.count}&prisid=1`).then(response => {
      this.setState({price : response.data })
  })
  }

  render(){
    return (
    <div className="App">
      <div className = "Header">
        <img src = {postenLogo} className ="Logo" alt ="Posten logo"></img>
      </div>
      <div className = "MainContent">
        <div className ="MainContentWrapper">
          <div className ="Bg">
            <Matrise></Matrise>
            <div className = "Info">
              <p>
                Prisen På pakkene regnes ut basert på antall pakker, totalvekt og en basisavgift.
              </p>
              <p>Basisavgift = 50kr</p>
              <p>Pakker = 10kr/pr</p>
              <p>Vekt = 5kr/kg</p>
            </div>
            <div>
              <p>Priskalkulator for pakker</p>
              <SingleParcelCalc  
                weightHandler = {this.weightHandler} 
                clickHandler = {this.clickHandler} 
                countHandler = {this.countHandler} 
                price = {this.state.price}
                count = {this.state.count}
                >
              </SingleParcelCalc>
            </div>
          </div>
         
         
        </div>
        
      </div>

    </div>)
  }

  
  
}

export default App;
