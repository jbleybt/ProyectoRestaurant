export class Cliente {
    id?: number;
    nombre: string;
    apellido: string;
    tipodocumento: string;
    numerodocumento: string;
    correo: string;

    constructor(nombre: string, apellido: string,tipodocumento: string,numerodocumento: string,correo: string) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.tipodocumento = tipodocumento;
        this.numerodocumento = numerodocumento;
        this.correo = correo;
    }

}
