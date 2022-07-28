export class Note {
    
    constructor(
        private _id: number | null,
        private _name: string,
        private _content: string,
        private _userId: number,
    ){}
    
    public get id(): number | null{
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
    public get content(): string {
        return this._content;
    }
    public set content(value: string) {
        this._content = value;
    }
    public get userId(): number {
        return this._userId;
    }
    public set userId(value: number) {
        this._userId = value;
    }

    public toJSON(): object {
        return {
            id: this._id,
            name: this._name,
            content:this._content,
            userId: this._userId,
            
        };
    }

}