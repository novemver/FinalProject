import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { Observable, catchError, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Appointment } from '../models/appointment';

@Injectable({
  providedIn: 'root',
})
export class AppointmentService {
  private baseUrl = 'http://localhost:8090/';
  private url = environment.baseUrl + 'api/appointments';

  constructor(
    private http: HttpClient,
    private auth: AuthService
    ) {}

  getHttpOptions() {
    let options = {
      headers: {
        Authorization: 'Basic ' + this.auth.getCredentials(),
        'X-Requested-With': 'XMLHttpRequest',
      },
    };
    return options;
  }


index(): Observable<Appointment[]> {
  // return [...this.todos];
  return this.http.get<Appointment[]>(this.url, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(
        () =>
        new Error(
          'AppointmentService.index(): error retrieving Appointment: ' + err
          )
      );
    })
  );
}

seeAppt(appointmentId: number): Observable<Appointment> {
  // return [...this.todos];
  return this.http.get<Appointment>(this.url + '/' + appointmentId, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(
        () => new Error('AppointmentService.seeAppt(): error retrieving Appointment: ' + err)
      );
    })
  );
}

create(appointment: Appointment): Observable<Appointment> {
  appointment.description = '';
  return this.http.post<Appointment>(this.url, appointment, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.error(err);
      return throwError(
        () => new Error('AppointmentService.create(): error creating Appointment: ' + err)
      );
    })
  );
}


update(appointment: Appointment): Observable<Appointment> {

  return this.http.put<Appointment>(this.url + '/' + appointment.id, appointment, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.error(err);
      return throwError(
        () => new Error('AppointmentService.update(): error updating Appointment: ' + err)
      );
    })
  );
}

delete(appointmentId: number): Observable<void> {
  return this.http.delete<void>(this.url + '/' + appointmentId, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.error(err);
      return throwError(
        () => new Error('AppointmentService.delete(): error deleting Appointment: ' + err)
      );
    })
  );
}


}
