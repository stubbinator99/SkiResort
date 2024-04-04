import {NgModule} from "@angular/core";
import {AppComponent} from "./app.component";
import {UserListComponent} from "./user-list/user-list.component";
import {UserFormComponent} from "./user-form/user-form.component";
import {BrowserModule} from "@angular/platform-browser";
import {AppRoutingModule} from "./app-routing.module";
import {HttpClientModule} from "@angular/common/http";
import {FormsModule} from "@angular/forms";
import {UserService} from "./services/user.service";
import {UserDetailsComponent} from "./user-details/user-details.component";
import {PassService} from "./services/pass.service";
import {PassListComponent} from "./pass-list/pass-list.component";
import {PassDetailsComponent} from "./pass-details/pass-details.component";
import {PassFormComponent} from "./pass-form/pass-form.component";


@NgModule({
  declarations: [
    AppComponent,

    UserListComponent,
    UserDetailsComponent,
    UserFormComponent,

    PassListComponent,
    PassDetailsComponent,
    PassFormComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    HttpClientModule,
    FormsModule
  ],
  providers: [
    UserService,
    PassService
  ],
  bootstrap: [AppComponent]
})
export class AppModule { }
