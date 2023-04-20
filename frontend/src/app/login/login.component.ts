import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {UserLoginRequestModel} from "../models/UserLoginRequestModel";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit{

  loginForm: FormGroup = new FormGroup({
    email: new FormControl(null, [Validators.required]),
    password: new FormControl(null, [Validators.required]),
  })

  constructor(private formBuilder: FormBuilder,
              private userService: UserService, private router: Router) {
  }

  ngOnInit(): void {
  }

  login() {
    let userLoginModel: UserLoginRequestModel = this.loginForm.value;
    this.userService.loginUser(userLoginModel)
      .subscribe({
        next: (response) => {
          console.log('Login response: '+ JSON.stringify(response))
        },
        error: (error) => {
          console.log(error)
        },
        complete: () => {
          console.log('completed')

          this.router.navigate(['/main']);
        }

      })

  }
}
