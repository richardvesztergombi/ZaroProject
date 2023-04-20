import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, Validators} from "@angular/forms";
import {UserService} from "../services/user.service";
import {Router} from "@angular/router";
import {UserRegisterRequestModel} from "../models/UserRegisterRequestModel";
@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent implements OnInit{
  registerForm: FormGroup = new FormGroup({
    userName: new FormControl(null,[Validators.required]),
    email: new FormControl(null, [Validators.required]),
    password: new FormControl(null, [Validators.required]),
  })

  constructor(private formBuilder: FormBuilder,
    private userService: UserService, private router: Router) {
  }

  ngOnInit(): void{
  }

  register() {
    let userRegisterModel: UserRegisterRequestModel = this.registerForm.value;
    this.userService.registerUser(userRegisterModel)
      .subscribe({
        next: (response) => {
          console.log('Register response: '+ JSON.stringify(response))
        },
        error: (error) => {
          console.log(error)
        },
        complete: () => {
          console.log('completed')

          this.router.navigate(['/login']);
        }

      })
  }
}
