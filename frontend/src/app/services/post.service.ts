import { Injectable } from '@angular/core';
import {AddNewBlogModel} from "../models/AddNewBlogModel";
import {Observable} from "rxjs";
import {HttpClient} from "@angular/common/http";

@Injectable({
  providedIn: 'root'
})
export class PostService {
  private BLOG_URL = 'http://localhost:8080/post'
  constructor(private http: HttpClient) { }

  createANewBlog(addNewBlogModel: AddNewBlogModel): Observable<any> {
    return this.http.post(this.BLOG_URL, addNewBlogModel);
  }
}
