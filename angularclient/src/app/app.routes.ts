import { Routes } from '@angular/router';
import {UserListComponent} from "./user-list/user-list.component";
import {UserFormComponent} from "./user-form/user-form.component";
import {UserDetailsComponent} from "./user-details/user-details.component";
import {PassListComponent} from "./pass-list/pass-list.component";
import {PassFormComponent} from "./pass-form/pass-form.component";
import {PassDetailsComponent} from "./pass-details/pass-details.component";

export const routes: Routes = [
  { path: 'users', component: UserListComponent },
  { path: 'users/:username', component: UserDetailsComponent },
  { path: 'adduser', component: UserFormComponent },

  { path: 'passes', component: PassListComponent },
  { path: 'passes/:pass-id', component: PassDetailsComponent },
  { path: 'newpass', component: PassFormComponent }
];
