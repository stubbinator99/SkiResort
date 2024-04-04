import {Injectable} from '@angular/core';
import {HttpClient, HttpHeaders} from "@angular/common/http";
import {Observable} from "rxjs";
import {User} from "../model/user";

@Injectable({
  providedIn: 'root'
})
export class UserService {
  private readonly usersUrl: string;

  constructor(private http: HttpClient) {
    this.usersUrl = 'http://localhost:8080/users/';
  }

  public getUser(username: string): Observable<User> {
    return this.http.get<User>(this.usersUrl + encodeURIComponent(username));
  }

  public getAllUsers(): Observable<User[]> {
    return this.http.get<User[]>(this.usersUrl + 'all');
  }

  public newUser(user: User): Observable<User> {
    return this.http.post<User>(this.usersUrl + 'new', user);
  }
}
