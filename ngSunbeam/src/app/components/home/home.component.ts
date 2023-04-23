import { Component } from '@angular/core';
import { Router } from '@angular/router';
import { User } from 'src/app/models/user';
import { AuthService } from 'src/app/services/auth.service';
import { UserService } from 'src/app/services/user.service';

@Component({
  selector: 'app-home',
  templateUrl: './home.component.html',
  styleUrls: ['./home.component.css']
})
export class HomeComponent {


users:User[] = [];
showList: boolean = false;
loggedInUser: User| null = null;


  constructor(
    private router: Router,
    private userService:UserService,
    private authService:AuthService
  ){

  }
  ngOnInit() {

    // this.authService.getLoggedInUser().subscribe({
    //   next: (user: User) => {
    //     this.loggedInUser = user;
    //   },
    //   error: (nojoy) => {
    //     console.log(nojoy);
    //   }

    //  });

    this.loadUsers();
  }
  viewUserProfile(user:User) {
    this.router.navigate(['/user-profile', user.id]);

  }
  loadUsers(){
    this.userService.getUsers().subscribe({
      next: (users:User[]) => {
        this.users = users;
      },
      error: (nojoy) => {
        console.log(nojoy);
      }
    });

  }
}
