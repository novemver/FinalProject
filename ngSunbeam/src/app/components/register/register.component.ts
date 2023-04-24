import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';

@Component({
  selector: 'app-register',
  templateUrl: './register.component.html',
  styleUrls: ['./register.component.css']
})
export class RegisterComponent {
  newUser: User = new User();

  constructor(
    private auth: AuthService,
    private router: Router
   ){

   }
   register(): void {
    console.log('Registering user:');
    console.log("USER", this.newUser);
    this.auth.register(this.newUser).subscribe({
      next: (registeredUser) => {
        console.log("registeredUser", registeredUser);
        this.auth.login(this.newUser.username, this.newUser.password).subscribe({
          next: (loggedInUser) => {
            this.router.navigateByUrl('/home');
          },
          error: (problem) => {
            console.error('RegisterComponent.register(): Error logging in user:');
            console.error(problem);
          }
        });

}})}}
