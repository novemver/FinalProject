import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';
import { Observable, catchError, throwError, tap } from 'rxjs';
import { Buffer } from 'buffer';

@Injectable({
  providedIn: 'root'
})
export class AuthService {


  constructor(private http: HttpClient) {}


  private url = environment.baseUrl;


  register(user: User): Observable<User> {
    return this.http.post<User>(this.url + 'register', user).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('AuthService.register(): error registering user.')
        );
      })
    );
  }

  login(username: string, password: string): Observable<User> {
    const credentials = this.generateBasicAuthCredentials(username, password);
    const httpOptions = {
      headers: new HttpHeaders({
        Authorization: `Basic ${credentials}`,
        'X-Requested-With': 'XMLHttpRequest',
      }),
    };

    return this.http.get<User>(this.url + 'authenticate', httpOptions).pipe(
      tap((newUser) => {
        localStorage.setItem('credentials', credentials);
        localStorage.setItem('username', username);
        return newUser;
      }),
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('AuthService.login(): error logging in user.')
        );
      })
    );
  }

  logout(): void {
    localStorage.removeItem('credentials');
  }

  getLoggedInUser(): Observable<User> {
    if (!this.checkLogin()) {
      return throwError(() => {
        new Error('Not logged in.');
      });
    }
    let httpOptions = {
      headers: {
        Authorization: 'Basic ' + this.getCredentials(),
        'X-Requested-with': 'XMLHttpRequest',
      },
    };
    return this.http
      .get<User>(this.url + 'authenticate', httpOptions)
      .pipe(
        catchError((err: any) => {
          console.log(err);
          return throwError(
            () => new Error( 'AuthService.getUserById(): error retrieving user: ' + err )
          );
        })
      );
  }

  checkLogin(): boolean {
    if (localStorage.getItem('credentials')) {
      return true;
    }
    return false;
  }

  generateBasicAuthCredentials(username: string, password: string): string {
    return Buffer.from(`${username}:${password}`).toString('base64');
  }

  getCredentials(): string | null {
    return localStorage.getItem('credentials');
  }

  getUsername(){
    return localStorage.getItem('username');
  }

  getUser(username: string){
    let httpOptions = {
      headers: {
        Authorization: 'Basic ' + this.getCredentials(),
        'X-Requested-with': 'XMLHttpRequest',
      },
    };
    return this.http.get<User>(this.url+'api/users/profile/' + username, httpOptions).pipe(
      catchError((err: any) =>{
        return throwError('Error getting user username');
      })
    );
  }



}
