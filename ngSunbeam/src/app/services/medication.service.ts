import { DatePipe } from '@angular/common';
import { HttpClient } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable, catchError, throwError } from 'rxjs';
import { AuthService } from './auth.service';
import { Medication } from '../models/medication';
import { environment } from 'src/environments/environment';
import { Reminder } from '../models/reminder';

@Injectable({
  providedIn: 'root'
})
export class MedicationService {
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


getMedication(): Observable<Medication[]> {
  return this.http.get<Medication[]>(this.url, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(
        () => new Error('Medication index ' + err)
      );
    })
  );
}


public addMedication(medication:Medication): Observable<Medication>{
  return this.http.post<Medication>(this.url, medication, this.getHttpOptions()).pipe(
    catchError((err: any) => {
      console.log(err);
      return throwError(
        () => new Error('Medication Service ' + err)
      );
    })
  );

}

}
