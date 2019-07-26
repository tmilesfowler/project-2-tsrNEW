import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { FormBuilder, FormGroup, Validators } from '@angular/forms';
import { Router } from '@angular/router';
import { ToastrService } from 'ngx-toastr';
import { Subject } from 'rxjs';
import { delay } from 'rxjs/operators';
import { AuthenticationService } from 'src/app/services/authentication.service';
import { TokenService } from 'src/app/services/token.service';
import { UserService } from 'src/app/services/user.service';
import { User } from 'src/app/models/User';

@Component({
  selector: 'app-login',
  templateUrl: './customer-list.component.html',
  styleUrls: ['./customer-list.component.scss']
})
export class CustomerListComponent implements OnInit {

  users: User[];
  statusMessage: string
  user = new User();

  returnUrl: string;
  private ngUnsubscribe: Subject<void> = new Subject<void>();

  constructor(private _userService:UserService) {}

  ngOnInit() {
    this.getUsers();
  }

  resetUser(){
    this.user.id = null;
    this.user.fname = null;
    this.user.lname = null;
    this.user.email = null;
    this.user.username = null;
    this.user.password = null;
    this.user.role = null;
  }

  getUsers():void{
    console.log("Got a user");
    this._userService.getUsers().subscribe((userData) => this.users = userData, 
    (error) => {console.log(error);
    this.statusMessage = "problem with service, try again later";
      }
  );
  }

}