import { Injectable } from '@angular/core';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';
import { Observable, catchError, throwError } from 'rxjs';
import { HttpClient } from '@angular/common/http';
import { Appointment } from '../models/appointment';
import { DatePipe } from '@angular/common';

@Injectable({
  providedIn: 'root',
})
export class AppointmentService {
  private baseUrl = 'http://localhost:8090/';
  private url = environment.baseUrl + 'api/';

  constructor(
    private http: HttpClient,
    private auth: AuthService,
    private datepipe: DatePipe
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
  return this.http.get<Appointment[]>(this.url + 'appointments', this.getHttpOptions()).pipe(
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
  return this.http.get<Appointment>(this.url + 'appointments' + appointmentId, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(
        () => new Error('AppointmentService.seeAppt(): error retrieving Appointment: ' + err)
      );
    })
  );
}

createAppointment(appointment: Appointment, elderId: number): Observable<Appointment> {
  console.log(appointment);

  return this.http.post<Appointment>(this.url + 'elders' + '/' + elderId + '/' + 'appointments', appointment, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.error(err);
      return throwError(
        () => new Error('AppointmentService.createAppointment(): error creating Appointment: ' + err)
      );
    })
  );
}

updateAppointment(appointment: Appointment, elderId: number): Observable<Appointment> {
  return this.http.put<Appointment>(this.url + 'elders' + '/' + elderId + '/' + 'appointments' + '/' + appointment.id, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.error(err);
      return throwError(
        () => new Error('AppointmentService.updateAppointment(): error updating Appointment: ' + err)
      );
    })
  );
}

deleteAppointment(appointmentId: number): Observable<void> {
  return this.http.delete<void>(this.url + 'elders/appointments' + '/' + appointmentId, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.error(err);
      return throwError(
        () => new Error('AppointmentService.deleteAppointment(): error deleting Appointment: ' + err)
      );
    })
  );
}



}
