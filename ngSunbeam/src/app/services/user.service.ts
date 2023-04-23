import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { User } from '../models/user';
import { Observable, catchError, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';

@Injectable({
  providedIn: 'root'
})
export class UserService {
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

  getUsers(): Observable<User[]> {
    // return [...this.todos];
    return this.http.get<User[]>(this.url + "api/users", this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('TodoService.index(): error retrieving Todos: ' + err)
        );
      })
    );
  }
}
