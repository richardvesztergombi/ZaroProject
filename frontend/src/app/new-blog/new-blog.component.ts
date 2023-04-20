import {Component, OnInit} from '@angular/core';
import {FormBuilder, FormControl, FormGroup, isFormControl, Validators} from "@angular/forms";
import {Router} from "@angular/router";
import {AddNewBlogModel} from "../models/AddNewBlogModel";
import {PostService} from "../services/post.service";
import {PostResponseModel} from "../models/PostResponseModel";

@Component({
  selector: 'app-new-blog',
  templateUrl: './new-blog.component.html',
  styleUrls: ['./new-blog.component.css']
})
export class NewBlogComponent{

  newBlogForm: FormGroup = new FormGroup({
    picture_url: new FormControl(null,[Validators.required]),
    title: new FormControl(null, [Validators.required]),
    description: new FormControl(null, [Validators.required]),
  })

  constructor(private formBuilder: FormBuilder,
      private postService: PostService, private router: Router){

  }

  ngOnInit(): void{
  }

  newBlog(){
    let addNewBlogModel: AddNewBlogModel = this.newBlogForm.value;
    let postResponse: PostResponseModel;
    this.postService.createANewBlog(addNewBlogModel)
      .subscribe({
        next: (response) => {
          console.log('Blog response: '+ JSON.stringify(response))
          postResponse = response;
          console.log("Az a már FE-es érték:"+ JSON.stringify(postResponse));
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
