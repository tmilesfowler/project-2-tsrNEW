
export class User {
    ​
        id: number;
        fname: string;
        lname: string;
        email: string;
        username: string; 
        password: string; 
        role: string; 
        
    ​
        constructor(id?: number, fname?: string, lname?: string, email?:string, username?: string, password?: string,role?:string) {
    ​
            this.id = id;
            this.fname = fname;
            this.lname = lname;
            this.email = email;
            this.username = username;
            this.password = password;
            this.role = role;
        }
    ​
        getfname() {
            return this.fname;
        }
    ​
        getlname() {
            return this.lname;
        }
    ​
        getEmail() {
            return this.email;
        }
    ​
        getusername() {
            return this.username;
        }
    ​
        getPassword() {
            return this.password;
        }
    ​
        getRole() {
            return this.role;
        }
    ​
    }