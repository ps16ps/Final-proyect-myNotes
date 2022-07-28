import { NgModule } from '@angular/core';
import { RouterModule, Routes } from '@angular/router';
import { NotesComponent } from './components/notes/notes.component';
import { NewNoteComponent } from './components/new-note/new-note.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { AuthGuardService } from './services/auth-guard.service';
import { LoginComponent } from './components/login/login.component';

const routes: Routes = [
  //{ path: '', pathMatch: 'full', redirectTo: 'notes' },
  //{ path: 'notes', canActivate:[AuthGuardService], component: NotesComponent },
  { path: 'notes', component: NotesComponent },
  { path: 'new-note', component: NewNoteComponent },
  { path: 'user-form', component: UserFormComponent },
  { path: 'login', component: LoginComponent }
];

@NgModule({
  imports: [RouterModule.forRoot(routes)],
  exports: [RouterModule]
})
export class AppRoutingModule { }