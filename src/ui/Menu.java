package ui;

import model.Bonos;
import model.CargaFamiliar;
import model.Empleados;

import java.util.*;


public class Menu {
    public static final String[] PorcentajeSueldo = {"Casado/a", "Hijos", "Mayor de edad"};
    public static Empleados empleados;
    public static Bonos bono;
    public static void showMenu() {
        System.out.println("Bienvenidos");
        System.out.println("Selecciona la opcion deseada");
        int response = 0;
        do {
            System.out.println("1. Datos del Empleado");
            System.out.println("2. Salir");
            Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());


        }while (response == 0 && response > 3);

        switch (response){
            case 1:
                IngresoDatosEmpleado();
                break;
            case 2:
                Menu.showMenu();
                break;


        }


    }

    public static void  IngresoDatosEmpleado() {
        System.out.println("Ingrese los Datos");
        System.out.print("Ingrese el Nombre Completo: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();

        System.out.print("Ingrese Apellidos: ");
        String apellido = sc.nextLine();

        System.out.print("Ingrese Edad: ");
        String edad = sc.nextLine();
        System.out.print("Ingrese Direccion: ");
        String direccion = sc.nextLine();
        System.out.print("Ingrese Cedula: ");
        String cedula = sc.nextLine();
        System.out.print("Ingrese Salario: ");
        String salario = sc.nextLine();
        System.out.println("El empleado " + nombre +" "+ apellido +" con cedula de identidad "+ cedula+  " ubicado en "+ direccion);
        Empleados empleado = new Empleados() ;
        empleado.setNombre(nombre);
        empleado.setApellido(apellido);
        empleado.setEdad(Integer.parseInt(edad) );
        empleado.setCedula(cedula);
        empleado.setDireccion(direccion);
        if (Double.parseDouble(salario) > 400){
            empleado.setBono(100);

        }
        else{
            empleado.setBono(0);
        }

        empleado.setSalario(Double.parseDouble(salario));
        empleado.setSalarioTotal( empleado.getSalario() + empleado.getBono());
        String carga = tieneCarga();

        CargaFamiliar cargaEmpleado = new CargaFamiliar();
        List listCargas = new ArrayList ();

            // Poner Numeros de Cargas
            //
        if (carga.toLowerCase().equals("Si") || carga.toLowerCase().equals("si")){
            System.out.print(" Ingrese el numero de Cargas: ");
            String nCargas = sc.nextLine();
            Integer nCarga = Integer.parseInt(nCargas);
            for (int i = 0; i < nCarga ; i++) {
                cargaEmpleado = new CargaFamiliar();
                cargaEmpleado = IngresarDatosCargaFamiliar();
                cargaEmpleado.setcedulaEmpleado(empleado.getCedula());
                listCargas.add(cargaEmpleado);

            }

        }
        else if (carga.equals("No") || carga.equals("no")){
            System.out.println("No tiene carga");
        }
        else{
            System.out.println("Error al ingresar Dato");
        }

        System.out.println(empleado.toString());
        System.out.println();
        CargaFamiliar ca = new CargaFamiliar();
        /*
        * Valor / 100
        * esposa = 0.09 / 100 = 0.0009
        * hijo = 0.10 / 100 = 0.001
        * Mayor de edad = 0.08 / 100 = 0.0008
        * */
        double salarioT = 0.0;
        double porcentaje = 0.0;
        for (int i = 0; i < listCargas.size()  ; i++) {
            //System.out.println(listCargas.get(i).toString() );

             ca = (CargaFamiliar) listCargas.get(i);
             salarioT = empleado.getSalarioTotal();
            System.out.println("Tipo de Carga Calculos");
            System.out.println(ca.getTipo().toString());
             if (ca.getTipo().toString().equals("esposa") ){
                 porcentaje = 0.09;//100;
                 salarioT = salarioT + (salarioT * porcentaje);
                 System.out.println("Salario con esposa");
                 System.out.println(salarioT);
                 empleado.setSalarioTotal( salarioT);
             }

            if (ca.getTipo().toString().equals("hijo")){
                porcentaje = 0.10;//100;
                salarioT = salarioT + (salarioT * porcentaje);
                System.out.println("Salario con hijo");
                System.out.println(salarioT);
                empleado.setSalarioTotal( salarioT);
            }

            if (ca.getTipo().toString().equals("padres") ){
                porcentaje = 0.08;//100;
                salarioT = salarioT + (salarioT * porcentaje);
                System.out.println("Salario con tercera edad");
                System.out.println(salarioT);
                empleado.setSalarioTotal( salarioT);
            }
             //System.out.println(ca.toString() +" Tipo de carga "+ ca.getTipo() + " Cedula d empleado " + ca.getcedulaEmpleado());

        }
        //System.out.println(empleado.toString());
        System.out.println("Se ha registrado al empleado " + empleado.getNombre()+ " " + empleado.getApellido() + " con # de Cedula "+empleado.getCedula());
        for (int i = 0; i < listCargas.size()  ; i++) {
            //System.out.println(listCargas.get(i).toString() );
            ca = (CargaFamiliar) listCargas.get(i);
            System.out.println("Carga #"+ (i + 1));
            System.out.println("Nombre Completo: " + ca.getNombre() + " " + ca.getApellido());
            System.out.println("Cedula: "+ ca.getCedula());
            System.out.println("Tipo de Carga: " +ca.getTipo());
        }
        System.out.println();
        System.out.println("Direccion: " + empleado.getDireccion());
        System.out.println("Total del salario con Bonos y Cargas Familiares: $" + empleado.getSalarioTotal());

        //cargaEmpleado.setcedulaEmpleado(empleado.getCedula());



    }
    public static String  tieneCarga( ){
        System.out.println("Posee Cargas Familiares");
        System.out.println("::Si");
        System.out.println("::No");
        Scanner rc = new Scanner(System.in);
        String carga = "";
        carga = String.valueOf(rc.nextLine());
        System.out.println(carga);

        return carga;
    }


    public static CargaFamiliar IngresarDatosCargaFamiliar() {
        System.out.println("Ingrese los Datos de la Carga");
        System.out.print("Ingrese el Nombre Completo: ");
        Scanner sc = new Scanner(System.in);
        String nombre = sc.nextLine();

        System.out.print("Ingrese Apellidos: ");
        String apellido = sc.nextLine();

        System.out.print("Ingrese Edad: ");
        String edad = sc.nextLine();
        System.out.print("Ingrese Cedula: ");
        String cedula = sc.nextLine();
        System.out.println("Ingrese tipo de carga:");
        int response = 0;
        do {
            System.out.println("1. Esposa");
            System.out.println("2. Hijo");
            System.out.println("3. Padres");
            //Scanner sc = new Scanner(System.in);
            response = Integer.valueOf(sc.nextLine());


        }while (response == 0 && response > 4);

        CargaFamiliar cargaF = new CargaFamiliar();
        cargaF.setNombre(nombre);
        cargaF.setApellido(apellido);
        cargaF.setEdad(Integer.parseInt(edad));
        cargaF.setCedula(cedula);
        switch (response){
            case 1:
                cargaF.setTipo("esposa");
                break;
            case 2:
                cargaF.setTipo("hijo");
                break;
            case 3:
                cargaF.setTipo("padres");
                break;

        }
        return  cargaF;
    }
};



