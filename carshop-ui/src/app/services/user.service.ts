import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from '../../environments/environment';
import { User } from '../models/User';
import { Observable } from 'rxjs';
​
@Injectable({
  providedIn: 'root'
})
export class UserService {
​
  url: string = environment.API_URL + '/users';
​
  constructor(
private http: HttpClient,
private _httpService: HttpClient
  ) { }
​
  findByUsername(username: string, password: string): Observable<any>{
    return this.http.get("http://localhost:8090/springCarShow/api/user?user=" + username + "&pass=" + password);
  }

  // findByUsername(username: string): Observable<any>{
  //   return this.http.get(this.url + '/username/' + username);
  // }
​
  updateUser(user: User) {
    return this.http.put(this.url, user);
  }
​
  getAuthenticatedUser() {
    return this.http.get(this.url + '/authenticated');
  }
​
  // getUsers() {
  //   return this.http.get(this.url);
  // }
​
  delete(id) {
    return this.http.delete(this.url + '/' + id);
  }
​
  getUsers(): Observable<any>{
    return this._httpService.get("http://localhost:8090/springCarShow/api/users")
  }
​
  save(user: User) {
    let body = JSON.parse(JSON.stringify(user)); 
    if (!user.id){
      console.log("Entered for updates "); 
      return this._httpService.put("http://localhost:8090/springCarShow/api/user",body);
    } else{
      console.log("Entered in new"); 
      return this._httpService.post("http://localhost:8090/springCarShow/api/users/",body);
    }
    //return this.http.post(this.url, user);
  }
​
  findById(id) {
    return this.http.get(this.url + '/' + id);
  }
​
}