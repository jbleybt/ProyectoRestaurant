export class Empleado {
    id?: number;
    nombre: string;
    apellido: string;
    tipodocumento: string;
    numerodocumento: string;
    correo: string;
    password:string;

    constructor(nombre: string, apellido: string,tipodocumento: string,numerodocumento: string,correo: string,password:string) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipodocumento = tipodocumento;
        this.numerodocumento = numerodocumento;
        this.correo = correo;
        this.password = password;

    }

}
