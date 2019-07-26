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
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.scss']
})
export class LoginComponent implements OnInit {
  @ViewChild('userCh', {static: false}) userCh: ElementRef;
  @ViewChild('passCh', {static: false}) passCh: ElementRef;

  title = 'Login';
  form: FormGroup;
  submitted = false;
  myUser = new User();
  statusMessage: string

  returnUrl: string;
  private ngUnsubscribe: Subject<void> = new Subject<void>();

  constructor(private formBuilder: FormBuilder,
    private router: Router,
    private userService: UserService,
    private authService: AuthenticationService,
    private tokenService: TokenService,
    private toastr: ToastrService,
    private _userService:UserService) {
  }

  ngOnInit() {
    this.form = this.formBuilder.group({
      username: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(64)])],
      password: ['', Validators.compose([Validators.required, Validators.minLength(3), Validators.maxLength(32)])]
    });
  }

  signup() {
    this.router.navigate(['/signup']);
  }

  // //FOR TESTING PURPOSES
  bypass(){
    this.router.navigate(['/edit']);
  }

  resetUser(){
    this.myUser.id = null;
    this.myUser.fname = null;
    this.myUser.lname = null;
    this.myUser.email = null;
    this.myUser.username = null;
    this.myUser.password = null;
    this.myUser.role = null;
  }

  login(username: string, password: string){
    this.resetUser;
    
    username = this.userCh.nativeElement.value;
    password = this.passCh.nativeElement.value;

    console.log("User info: " + username + " " + password);
    
    this._userService.findByUsername(username, password).subscribe((userData) => {this.myUser = userData;}),
    
      (error) => {console.log(error); this.statusMessage = "Problem with service"}
  }

  // onSubmit() {
  //   this.submitted = true;
  //   this.authService.login(this.form.value).pipe(delay(1000)).subscribe((resp: any) => {
  //     this.tokenService.saveToken(resp);
  //     this.userService.findByUsername(this.form.value.username).subscribe(resp => {
  //       this.authService.setConnectedUser(resp);
  //       if (this.returnUrl) {
  //         this.router.navigate([this.returnUrl]);
  //       } else {
  //         this.router.navigate(['home']);
  //       }
  //     });
  //   }, resp => {
  //     this.submitted = false;
  //     if (resp.status === 401 || resp.status === 403) {
  //       resp.error ? this.toastr.error(resp.error) : this.toastr.error('Incorrect credentials');
  //     } else {
  //       this.toastr.error('Login error. Try again later');
  //     }
  //   });
  // }
}
