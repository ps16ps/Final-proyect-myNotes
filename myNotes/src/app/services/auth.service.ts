import { HttpClient, HttpHeaders } from '@angular/common/http';
import { Injectable } from '@angular/core';
import { Observable } from 'rxjs';
import { User } from '../models/user.model';
import { Note } from '../models/note.model';
import { NoteItemComponent } from '../components/note-item/note-item.component';

@Injectable({
  providedIn: 'root'
})
export class AuthService {
  readonly BASE_URL = 'http://localhost:8080';

  constructor(private http: HttpClient) { }

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
      null
    );
    return this.http.post<User>(`${this.BASE_URL}/users`, user);        
  }

  login(username: string, password: string): Observable<User> {

    console.log(username, password)

    let headers = new HttpHeaders();
    headers = headers.append('Authorization', 'Basic ' + btoa(username + ':' + password));
   
    return this.http.get<User>(`${this.BASE_URL}/login`, { headers: headers });       
  }

  logout(): void {
    // Remove user from local storage to log user out
    localStorage.removeItem('currentUser');
  }
  //Llamamos a nuestro Backend 
  getAllNotes(): Observable<any>{
    return this.http.get<Note[]>(`${this.BASE_URL}/notes`);
  }

  getNotesById(id: number): Observable<any>{
    return this.http.get<any>(`${this.BASE_URL}/notes/${id}`);
  }

  addNote(name:string, content: string, userId: number): Observable<Note>{
    const note: Note = new Note(
      null,
      name,
      content,
      userId
    );
    return this.http.post<Note>(`${this.BASE_URL}/notes`, note);
  }

  updateNote(id: number): Observable<any>{
    return this.http.put(`${this.BASE_URL}/notes/${id}`, Note);
  }

  deleteNote(id: number): Observable<Object>{
    console.log("Estoy en el auth service")
    return this.http.delete(`${this.BASE_URL}/notes/${id}`);
  }

  usersById(id: number): Observable<any>{
    return this.http.get<any>(`${this.BASE_URL}/users/${id}`);
  }

  deleteUser(id: number): Observable<Object>{
    return this.http.delete(`${this.BASE_URL}/users/${id}`);
  }

  getNotesByUserId(userId: number): Observable<any>{
    return this.http.get<Note[]>(`${this.BASE_URL}/notes/users/${userId}`);
  }


}
