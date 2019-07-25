import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';
import { Car } from '../models/car';

@Injectable({
  providedIn: 'root'
})
export class CarService {

  constructor(private _httpService: HttpClient) {}

  deleteCar(carId: number){
    return this._httpService.delete("http://localhost:8090/springCarShow/api/cars/" + carId);
    //return null;
  }

  getCarByID(carId: number): Observable<any>{
    return this._httpService.get("http://localhost:8090/springCarShow/api/cars/" + carId);
    //return null;
  }
  
  getCarByModel(carMod: string): Observable<any>{
    console.log("before exit, carMod = " + carMod);
    return this._httpService.get("http://localhost:8090/springCarShow/api/car/" + carMod);
    //return null;
  }

  getCars(): Observable<any>{
    //return this._httpService.get("http://localhost:3000/books"); 
    return this._httpService.get("http://localhost:8090/springCarShow/api/cars");
    
    //return null;
  }

  addCar(car: Car){
    let body = JSON.parse(JSON.stringify(car));
    if(!car.id){
      console.log(" Entered for updates ");
      return this._httpService.put("http://localhost:8090/springCarShow/api/car", body);
      //return null;
    } else{
      console.log(" Entered in new");
      return this._httpService.post("http://localhost:8090/springCarShow/api/cars/", body);
      //return null;
    }
    
  }

}

