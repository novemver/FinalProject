import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { AuthService } from './auth.service';
import { catchError, throwError } from 'rxjs';
import { User } from '../models/user';
import { environment } from 'src/environments/environment';
import { Elder } from '../models/elder';

@Injectable({
  providedIn: 'root'
})
export class ElderService {
  private baseUrl = 'http://localhost:8090/';
  private url = environment.baseUrl;

  constructor(
    private http: HttpClient,
    private auth: AuthService
  ) { }

  getHttpOptions() {
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }

  getEldersForUser(){
    return this.http.get<Elder[]>(this.url + "api/elders", this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('ElderService.getEldersForUser(): error retrieving Elders: ' + err)
        );
      })
    );
  }
}
