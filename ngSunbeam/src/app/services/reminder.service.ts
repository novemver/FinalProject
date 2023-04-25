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


  addReminder(reminder: Reminder) {
    this.reminderService.create(reminder).subscribe({
      next: () => {
        this.newReminder = new Reminder();
      },
      error: (fail: any) => {
        console.error('Error creating reminder in service');
        console.log(fail);
      },
    });


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
}


