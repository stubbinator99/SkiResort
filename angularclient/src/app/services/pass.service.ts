import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Pass} from "../model/pass";

@Injectable({
  providedIn: 'root'
})
export class PassService {
  private readonly passesUrl: string;

  constructor(private http: HttpClient) {
    this.passesUrl = 'http://localhost:8080/passes/'
  }

  public getPassWithPrice(passId: number): Observable<Pass> {
    return this.http.get<Pass>(this.passesUrl + "id/" + passId);
  }

  public getAllPassesForUser(username: string): Observable<Pass[]> {
    return this.http.get<Pass[]>(this.passesUrl + "user/" + encodeURIComponent(username));
  }

  public newPass(pass: Pass): Observable<Pass> {
    return this.http.post<Pass>(this.passesUrl + "new", pass);
  }

  getAllPasses() {
    return this.http.get<Pass[]>(this.passesUrl);
  }
}
