import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { Car } from 'src/app/models/car';
import { CarService } from 'src/app/services/car.service';
import { User } from 'src/app/models/User';
import { Router } from '@angular/router';

@Component({
  selector: 'app-car-edit',
  templateUrl: './car-edit.component.html',
  styleUrls: ['./car-edit.component.scss']
})
export class CarEditComponent implements OnInit {
  @ViewChild('modelSearch', {static: false}) modelSearch: ElementRef;

cars: Car[];
statusMessage: string
car = new Car();
myUser = new User();

  constructor(private _carService:CarService,  private router: Router) {}

  ngOnInit() {
    this.getCars();

    this.myUser = JSON.parse(sessionStorage.getItem("myUser"));
  }

  customerList(){
    this.router.navigate(['/customerlist']);
  }

  getCars():void{
    console.log("Got a car");
    this._carService.getCars().subscribe((carData) => this.cars = carData, 
    (error) => {console.log(error);
    this.statusMessage = "problem with service, try again later";
      }
  );
  }

  addCar(): void{
    this._carService.addCar(this.car).subscribe((response) => {console.log(response);
      this.getCars();    
        },
        (error) => {
          console.log(error);
          this.statusMessage = "problem with service. Please try again later!";
        } 
      ) 
  
      this.reset();
    }

    private reset(){
      this.car.id = null;
      this.car.year = null;
      this.car.model = null;
      this.car.price = null;
      this.car.color = null;
      this.car.type = null;
      this.car.description = null;
    }

    getCar(carId: number){
      this._carService.getCarByID(carId)
      .subscribe((carData) => {this.car = carData; this.getCars();}),
    
      (error) => {console.log(error); this.statusMessage = "Problem with service"}
      
      this.reset();
    }
    
    getCarByModel(carMod: string){
     carMod = this.modelSearch.nativeElement.value;
      console.log(carMod);
      
      this._carService.getCarByModel(carMod)
      .subscribe((carData) => {this.cars = carData;}),
    
      (error) => {console.log(error); this.statusMessage = "Problem with service"}
      
      this.reset();
    }
    
    deleteCar(id: number){
        this._carService.deleteCar(id).subscribe(
          (response) => {console.log(response); this.getCars();}, 
          (error) => {console.log(error); this.statusMessage = "Problemm with service"}
        );
      }
    
    }
