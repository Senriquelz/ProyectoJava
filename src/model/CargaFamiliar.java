package model;

public class CargaFamiliar extends Empleados {

    private String tipo;
    private String cedulaEmpleado;

    public CargaFamiliar(){
    }

    public CargaFamiliar(String nombre, String apellido, String direccion, int edad, double salario, String cedula, double bono, double salarioTotal, String tipo, String cedulaEmpleado) {
        super(nombre, apellido, direccion, edad, salario, cedula, bono, salarioTotal);
        this.tipo = tipo;
        this.cedulaEmpleado = cedulaEmpleado;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getcedulaEmpleado() {
        return cedulaEmpleado;
    }

    public void setcedulaEmpleado(String cedulaEmpleado) {
        this.cedulaEmpleado = cedulaEmpleado;
    }

}
