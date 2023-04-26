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

  seeFamilyMember(familymemberId: number): Observable<Familymember> {
    return this.http.get<Familymember>(this.url + 'appointments' + familymemberId, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('Family memeber see memeber is broken ' + err)
        );
      })
    );
  }


  public addFamilyMember(familymember: Familymember): Observable<Familymember>{
    return this.http.post<Familymember>(this.url, familymember, this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.log(err);
        return throwError(
          () => new Error('Reminder Service ' + err)
        );
      })
    );

  }

  createFamilyMember(familymember: Familymember, familymemeberId: number): Observable<Familymember> {
    return this.http.post<Familymember>(this.url + 'familymembers' + '/' + familymemeberId + '/' + 'elder', this.getHttpOptions()).pipe(
      catchError((err: any) => {
        console.error(err);
        return throwError(
          () => new Error('createFamilyMember broken Service ' + err)
        );
      })
    );
  }

}
