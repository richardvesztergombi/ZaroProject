import { Injectable } from '@angular/core';
import {UserLoginRequestModel} from "../models/UserLoginRequestModel";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private LOGIN_URL = 'http://localhost:8080/login'
  constructor(private http: HttpClient) { }

  loginEmployee(userLoginModel: UserLoginRequestModel): Observable<any> {
    return this.http.post(this.LOGIN_URL, userLoginModel);
  }

}
