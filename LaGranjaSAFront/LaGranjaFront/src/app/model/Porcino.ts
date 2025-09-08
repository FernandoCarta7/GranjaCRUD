export class Porcino {
    public id_porcino: number;
    public raza: String;
    public fecha_nacimiento: Date;
    public peso: number;
    public edad: number;

    constructor() {
        //his.edad = this.calcularEdad();
        const fechaActual = new Date(); // Fecha actual
        const diferenciaAnos = fechaActual.getFullYear() - this.fecha_nacimiento.getFullYear(); // Años de diferencia

        const mesActual = fechaActual.getMonth(); // Mes actual
        const mesNacimiento = this.fecha_nacimiento.getMonth(); // Mes de nacimiento

        // Si el mes de nacimiento aún no ha ocurrido este año, restamos un año
        if (mesActual < mesNacimiento || (mesActual === mesNacimiento && fechaActual.getDate() < this.fecha_nacimiento.getDate())) {
            this.edad = diferenciaAnos - 1;
        }

        this.edad = diferenciaAnos;
    }

}