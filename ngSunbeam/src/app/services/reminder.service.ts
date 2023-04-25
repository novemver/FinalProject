import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { User } from '../models/user';
import { AuthService } from './auth.service';
import { Reminder } from '../models/reminder';

@Injectable({
  providedIn: 'root'
})
export class ReminderService {
  private baseUrl = 'http://localhost:8090/';
  private url = environment.baseUrl;
  reminderService: any;
  newReminder: Reminder | undefined;

  constructor( private http: HttpClient,
    private auth: AuthService) { }


   getHttpOptions() {
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }


  public addReminder(reminder:Reminder): Observable<Reminder>{
    return this.http.post<Reminder>(this.url, reminder, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('Reminder Service ' + err)
        );
      })
    );

  }




  getReminder(): Observable<Reminder[]> {
    // return [...this.todos];
    return this.http.get<Reminder[]>(this.url + "api/reminders", this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('Error in reminder service ' + err)
        );
      })
    );
  }


  destroy(id: number): Observable<void>{
    return this.http.delete<void>(this.url+ "/" + id, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('destroy error in reminder' + err)
        );
      })
    );
    }
}



