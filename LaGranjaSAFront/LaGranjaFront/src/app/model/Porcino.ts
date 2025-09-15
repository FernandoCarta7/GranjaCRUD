import { Cliente } from "./Cliente";
import { Raza } from "./Raza";

export class Porcino {
    public id_porcino: number;
    public fecha_nacimiento: Date;
    public peso: number;
    public edad : number;
    public raza: Raza;
    public cliente: Cliente;
    
    constructor(fecha_nacimiento: Date, peso: number) {
        this.fecha_nacimiento = fecha_nacimiento; 
        this.peso = peso; 
    }


}