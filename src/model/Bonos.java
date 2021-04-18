package model;

public class Bonos extends Empleados {
    private double bonos;

    public Bonos(String nombre, String apellido, String direccion, int edad, double salario, String cedula, double bono, double salarioTotal, double bonos) {
        super(nombre, apellido, direccion, edad, salario, cedula, bono, salarioTotal);
        this.bonos = bonos;
    }

    @Override
    public String toString() {
        return super.toString()+ "bono" + bonos ;
    }

   // @Override
   /* public boolean showDataEmpleado() {

        if (super.getEdad() > 35 && this.bono > 0.08) {
            double nuevoSalario = super.getSalario() + super.Bonificacion;
            super.setSalario(nuevoSalario);
            return true;
        }
        return false;
    }*/
}
