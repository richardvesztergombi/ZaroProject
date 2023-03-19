import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { HomeComponent } from './home/home.component';
import { LoginComponent } from './login/login.component';
import { RegisterComponent } from './register/register.component';
import { MainComponent } from './main/main.component';
import { UserDetailsComponent } from './user-details/user-details.component';
import { AdminPageComponent } from './admin-page/admin-page.component';
import { UsersListComponent } from './users-list/users-list.component';
import { UsersBlogListComponent } from './users-blog-list/users-blog-list.component';
import { NewBlogComponent } from './new-blog/new-blog.component';

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
    AppRoutingModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
