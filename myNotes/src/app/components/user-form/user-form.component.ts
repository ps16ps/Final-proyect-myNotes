import { Component, OnInit } from '@angular/core';
import { User } from 'src/app/models/user.model';
import { AuthService } from 'src/app/services/auth.service';
import { Router } from '@angular/router';
@Component({
  selector: 'app-user-form',
  templateUrl: './user-form.component.html',
  styleUrls: ['./user-form.component.css']
})
export class UserFormComponent implements OnInit {
 
  user: User;

  constructor(private authService:AuthService, private router: Router) {
    this.user = new User( 0,'', '', '', '', []);
  }

  ngOnInit(): void {
  }

  register() {
    this.authService
      .register(this.user.name, this.user.username, this.user.email, this.user.password )
      .subscribe( () => this.router.navigate(['/login']));
  }
}