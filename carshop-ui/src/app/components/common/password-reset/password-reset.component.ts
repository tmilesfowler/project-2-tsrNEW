import { Component, OnInit, ViewChild, ElementRef } from '@angular/core';
import { EmailService } from 'src/app/services/email.service';

@Component({
  selector: 'app-password-reset',
  templateUrl: './password-reset.component.html',
  styleUrls: ['./password-reset.component.scss']
})
export class PasswordResetComponent implements OnInit {
  @ViewChild('emailSend', {static: false}) emailSend: ElementRef;

  constructor(private _emailService:EmailService) {}

  emails: String[];
  statusMessage: string

  ngOnInit() {
  }

  resetPassword(email: string){
    email = this.emailSend.nativeElement.value;
    console.log(email);

    this._emailService.sendEmail(email).subscribe((emailData) => {this.emails = emailData;}),
    
    (error) => {console.log(error); this.statusMessage = "Problem with service"}

  }

}
