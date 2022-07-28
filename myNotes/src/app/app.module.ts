import { NgModule } from '@angular/core';
import { BrowserModule } from '@angular/platform-browser';

import { AppRoutingModule } from './app-routing.module';
import { AppComponent } from './app.component';
import { NotesComponent } from './components/notes/notes.component';
import { NavBarComponent } from './components/nav-bar/nav-bar.component';
import { UserFormComponent } from './components/user-form/user-form.component';
import { FormsModule } from '@angular/forms';
import { NewNoteComponent } from './components/new-note/new-note.component';
import { HttpClientModule } from '@angular/common/http';
import { LoginComponent } from './components/login/login.component';
import { NoteItemComponent } from './components/note-item/note-item.component';
@NgModule({
  declarations: [
    AppComponent,
    NotesComponent,
    NavBarComponent,
    UserFormComponent,
    NewNoteComponent,
    LoginComponent,
    NoteItemComponent
  ],
  imports: [
    BrowserModule,
    AppRoutingModule,
    FormsModule,
    HttpClientModule
  ],
  providers: [],
  bootstrap: [AppComponent]
})
export class AppModule { }
