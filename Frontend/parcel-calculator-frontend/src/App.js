
import { Component } from 'react';
import './App.css';
import Matrise from "./components/matrise"
import SingleParcelCalc from './components/SingleParcelCalc';
import ApiService from "./components/apiService"
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
    this.setState({count: event.target.value})
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
        <svg className ="Logo"></svg>
      </div>
      <div className = "MainContent">
        <Matrise></Matrise>
        <SingleParcelCalc  
          weightHandler = {this.weightHandler} 
          clickHandler = {this.clickHandler} 
          countHandler = {this.countHandler} 
          price = {this.state.price}>
        </SingleParcelCalc>
      </div>

    </div>)
  }

  
  
}

export default App;
