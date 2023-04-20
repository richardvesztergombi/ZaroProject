import { Injectable } from '@angular/core';
import {UserLoginRequestModel} from "../models/UserLoginRequestModel";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";
import {UserRegisterRequestModel} from "../models/UserRegisterRequestModel";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private LOGIN_URL = 'http://localhost:8080/login'
  private REGISTER_URL = 'http://localhost:8080/api/registration'
  constructor(private http: HttpClient) { }

  loginUser(userLoginModel: UserLoginRequestModel): Observable<any> {
    return this.http.post(this.LOGIN_URL, userLoginModel);
  }
  registerUser(userRegisterModel: UserRegisterRequestModel): Observable<any>{
    return this.http.post(this.REGISTER_URL, userRegisterModel);
  }
}
