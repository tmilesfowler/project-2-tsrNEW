import { Injectable } from '@angular/core';
import { HttpClient } from '@angular/common/http';
import { Observable } from 'rxjs';

@Injectable({
  providedIn: 'root'
})
export class EmailService {

  constructor(private _httpService: HttpClient) { }

  sendEmail(emAddress: string): Observable<any>{
    console.log("before exit, emAddress = " + emAddress);
    return this._httpService.get("http://localhost:8090/springCarShow/api/resetPassword/" + emAddress);
    //return null;
  }
}
