import {Injectable} from '@angular/core';
import {HttpClient} from "@angular/common/http";
import {Observable} from "rxjs";
import {Pass, PassWithPrice} from "../model/pass";

@Injectable({
  providedIn: 'root'
})
export class PassService {
  private readonly passesUrl: string;

  constructor(private http: HttpClient) {
    this.passesUrl = 'http://localhost:8080/passes/'
  }

  public getPassWithPrice(passId: number): Observable<PassWithPrice> {
    return this.http.get<PassWithPrice>(this.passesUrl + "id/" + passId);
  }

  public getAllPassesForUser(username: string): Observable<PassWithPrice[]> {
    return this.http.get<PassWithPrice[]>(this.passesUrl + "user/" + encodeURIComponent(username));
  }

  public newPass(pass: Pass): Observable<Pass> {
    return this.http.post<PassWithPrice>(this.passesUrl + "new", pass);
  }
}
