import {NgModule} from '@angular/core';
import {BrowserModule} from '@angular/platform-browser';
import {AppComponent} from './app.component';
import {HomeComponent} from './home/home.component';
import {LoginComponent} from './login/login.component';
import {RegisterComponent} from './register/register.component';
import {MainComponent} from './main/main.component';
import {UserDetailsComponent} from './user-details/user-details.component';
import {AdminPageComponent} from './admin-page/admin-page.component';
import {UsersListComponent} from './users-list/users-list.component';
import {UsersBlogListComponent} from './users-blog-list/users-blog-list.component';
import {NewBlogComponent} from './new-blog/new-blog.component';
import {Routes, RouterModule} from "@angular/router";

const routes: Routes = [
  {path: "", component: HomeComponent},
  {path: "login", component: LoginComponent},
  {path: "register", component: RegisterComponent}
];


@NgModule({
  declarations: [
    AppComponent,
    HomeComponent,
    LoginComponent,
    RegisterComponent,
    MainComponent,
    UserDetailsComponent,
    AdminPageComponent,
    UsersListComponent,
    UsersBlogListComponent,
    NewBlogComponent
  ],
  imports: [
    BrowserModule,
    RouterModule.forRoot(routes),
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule {
}
