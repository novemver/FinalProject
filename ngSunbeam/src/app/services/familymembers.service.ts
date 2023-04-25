import { Injectable } from '@angular/core';
import { Familymember } from '../models/familymember';
import { HttpClient } from '@angular/common/http';
import { Observable, catchError, throwError } from 'rxjs';
import { environment } from 'src/environments/environment';
import { AuthService } from './auth.service';

@Injectable({
  providedIn: 'root'
})
export class FamilymembersService {
  private baseUrl = 'http://localhost:8090/';
  private url = environment.baseUrl;
  reminderService: any;
  newFamilyMember: Familymember | undefined;

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

  index(): Observable<Familymember[]> {
    return this.http.get<Familymember[]>(this.url + 'familymembers', this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () =>
          new Error(
            'Familymember Service index error ' + err
            )
        );
      })
    );
  }

  // seeFamilyMember(familyMemberId: number): Observable<Familymember> {
  //   return this.http.get<Familymember>(this.url + 'appointments' + appointmentId, this.getHttpOptions()).pipe(
  //     catchError((err: any) => {
  //       console.log(err);
  //       return throwError(
  //         () => new Error('AppointmentService.seeAppt(): error retrieving Appointment: ' + err)
  //       );
  //     })
  //   );
  // }


  public addFamilyMember(familyMember: Familymember): Observable<Familymember>{
    return this.http.post<Familymember>(this.url, familyMember, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('Reminder Service ' + err)
        );
      })
    );

  }
}
