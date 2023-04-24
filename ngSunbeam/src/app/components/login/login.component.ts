import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';


@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css'],
})


export class LoginComponent {


  loginUser: User = new User();

  constructor(private auth: AuthService, private router: Router) { }




  login(loginUser: User){
    this.auth.login(loginUser.username, loginUser.password).subscribe({
      next: (loginUser) => {
        console.log('User logged in');
        this.router.navigateByUrl('/profile');
      },
      error: (problem) => {
        console.error('RegisterComponent.register(): Error logging in user:');
        console.error(problem);
      }
    });
  }
}
