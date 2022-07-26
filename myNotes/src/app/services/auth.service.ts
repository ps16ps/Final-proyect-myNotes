import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
 
  readonly BASE_URL = 'http://localhost:8080';

  constructor(
    private http: HttpClient
  ) { }

  isAuthenticated(): boolean {
    const token: string | null = localStorage.getItem('currentUser');
    return token !== null;
  }

  register(name:string, username: string, email:string, password: string): Observable<User> {

    const user: User = new User(
      null,
      name,
      username,
      email,
      password,
      []
    );

    return this.http.post<User>(`${this.BASE_URL}/users`, user);
          
  }

  login(username: string, password: string): Observable<User> {
    let headers = new HttpHeaders();
    headers = headers.append('Authorization', 'Basic ' + btoa(`${username}:${password}`));

    return this.http.get<User>(`${this.BASE_URL}/login`, { headers: headers });
        
}

logout(): void {
    // Remove user from local storage to log user out
    localStorage.removeItem('currentUser');
}
 //Llamamos a nuestro Backend 
 getTeam(trainerId: number): Observable<any>{
  return this.http.get(`${this.BASE_URL}/teams/${trainerId}`);
}
}
