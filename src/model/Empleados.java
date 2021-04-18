package model;

public class Empleados {
    private String nombre;
    private String apellido;
    private String direccion;
    private int edad;
    private double salario;
    private String cedula;
    private double bono;
    private double salarioTotal;

    //public final double Bonificacion = 100;
    public  Empleados(){}

    public Empleados(String nombre, String apellido, String direccion, int edad, double salario, String cedula, double bono, double salarioTotal) {
        this.nombre = nombre;
        this.apellido = apellido;
        this.direccion = direccion;
        this.edad = edad;
        this.salario = salario;
        this.cedula = cedula;
        this.bono = bono;
        this.salarioTotal = salarioTotal;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public int getEdad() {
        return edad;
    }

    public void setEdad(int edad) {
        this.edad = edad;
    }

    public double getSalario() {
        return salario;
    }

    public void setSalario(double salario) {
        this.salario = salario;
    }

    public String getCedula() {
        return cedula;
    }

    public void setCedula(String cedula) {
        this.cedula = cedula;
    }

    public void setBono(double bono) {
        this.bono = bono;
    }

    public double getBono() {
        return bono;
    }

    public double getSalarioTotal() {
        return salarioTotal;
    }

    public void setSalarioTotal(double salarioTotal) {
        this.salarioTotal = salarioTotal;
    }

    @Override
    public String toString() {
        return "Empleados" + nombre + '\'' +
                "apellido='" + apellido + '\'' +
                "direccion='" + direccion + '\'' +
                "edad=" + edad +
                "salario=" + salario +
                "cedula='" + cedula + '\'' ;
    }
}
