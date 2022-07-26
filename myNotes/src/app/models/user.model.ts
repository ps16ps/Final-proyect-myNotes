import { Note } from "./note.model";

export class User {
    
    constructor(
        private _id: number | null,
        private _name: string,
        private _username: string,
        private _email: string,
        private _password: string,
       private _noteList: Note[]
    ) { }

    public get id(): number | null {
        return this._id;
    }
    public set id(value: number | null) {
        this._id = value;
    }
    public get name(): string {
        return this._name;
    }
    public set name(value: string) {
        this._name = value;
    } 
    public get username(): string {
        return this._username;
    }
    public set username(value: string) {
        this._username = value;
    }
    public get email(): string {
        return this._email;
    }
    public set email(value: string) {
        this._email = value;
    }
    public get password(): string {
        return this._password;
    }
    public set password(value: string) {
        this._password = value;
    }
    public get noteList(): Note[] {
        return this._noteList;
    }
    public set noteList(value: Note[]) {
        this._noteList = value;
    }

    public toJSON(): object {
        return {
            id: this._id,
            name: this._name,
            username: this._username,
            email: this._email,
            password: this._password,
            noteList:this._noteList
        };
    }

}
