import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { Observable, catchError, throwError } from 'rxjs';
import { Message } from '../models/message';
import { User } from '../models/user';

@Injectable({
  providedIn: 'root',
})
export class MessageService {
  private baseUrl = 'http://localhost:8090/';
  private url = environment.baseUrl + 'api/';

  constructor(private http: HttpClient, private auth: AuthService) {}

  getHttpOptions() {
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }

  getMessage(messageId: number): Observable<Message[]> {
    return this.http.get<Message[]>(this.url + 'messages/' + messageId, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('getMessage()' + err)
        );
      })
    );
  }

  indexMessage(receiverId : number): Observable<Message[]> {
    return this.http.get<Message[]>(this.url + 'users/' + receiverId + '/messages', this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
          new Error(
            'MessageService.index(): error retrieving Message: ' + err
            )
        );
      })
    );
  }

  createMessage(receiverId : number): Observable<Message> {
    return this.http.post<Message>(this.url + 'users/' + receiverId + '/messages', this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
          () => new Error(
            'MessageService.createAppointment(): error creating Message: ' + err
            )
        );
      })
    );
  }

  updateMessage(userId: number, messageId: number): Observable<Message> {
    return this.http.put<Message>(this.url + 'users/' + userId + '/messages' + messageId, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
          () => new Error('MessageService.updateAppointment(): error updating Message: ' + err)
        );
      })
    );
  }

  deleteMessage(messageId: number): Observable<void> {
    return this.http.delete<void>(this.url + 'users/messages/' + messageId, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
          () => new Error('MessageService.deleteAppointment(): error deleting Message: ' + err)
        );
      })
    );
  }

}
