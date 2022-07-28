import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
import { ConditionalExpr } from '@angular/compiler';

@Component({
  selector: 'app-login',
  templateUrl: './login.component.html',
  styleUrls: ['./login.component.css']
})
export class LoginComponent implements OnInit {

  user: User;


  constructor( private authService: AuthService,
    private router: Router) {
    this.user = new User( 0,'', '', '', '', []);
   }

  ngOnInit(): void {
  }

  login() {
    this.authService.login(this.user.username, this.user.password).subscribe(
      (user: User) => {
        // Store user in local storage to keep user logged in between page refreshes
        localStorage.removeItem('currentUser');
        user.password = this.user.password;
        localStorage.setItem('currentUser', JSON.stringify(user));


        // Redirect to home page
        this.router.navigate(['/notes']);
      },
      (error) =>  {
        console.log(error);
      }
    );
  }

}
