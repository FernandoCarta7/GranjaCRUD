import { Raza } from "./Raza";


export class Alimentacion {
    constructor(
        id: number,
        etapa: String,
        descripcion: String,
        dosis: number,
        raza: Raza
    ) {
        this.id = id
        this.etapa = etapa
        this.descripcion = descripcion
        this.dosis = dosis
        this.raza = raza
    } public id: number;
    public etapa: String;
    public descripcion: String;
    public dosis: number;
    public raza: Raza;


}