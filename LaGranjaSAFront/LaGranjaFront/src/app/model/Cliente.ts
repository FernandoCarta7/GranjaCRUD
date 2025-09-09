export class Cliente {
    public cedula: String;
    public nombres: String;
    public apellidos: String;
    public direccion: String;
    public telefono: String;
    constructor(cedula: String, nombres: String, apellidos: String, direccion: String, telefono: String ) {
        this.cedula = cedula;
        this.nombres = nombres;
        this.apellidos = apellidos;
        this.direccion = direccion;
        this.telefono = telefono;
    }
    
}