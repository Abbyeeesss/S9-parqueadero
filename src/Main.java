/*Nombre: Abigail Espinosa
  Tarea: S9-taller
 */
import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Parqueadero parqueadero = new Parqueadero();
        Scanner scanner = new Scanner(System.in);
        boolean running = true;

        while (running) {
            System.out.println("\n-------PARQUEADERO-------");
            System.out.println("1. Ingresar un carro al parqueadero");
            System.out.println("2. Dar salida a un carro del parqueadero");
            System.out.println("3. Informar los ingresos del parqueadero");
            System.out.println("4. Consultar la cantidad de puestos disponibles");
            System.out.println("5. Avanzar el reloj del parqueadero");
            System.out.println("6. Cambiar la tarifa del parqueadero");
            System.out.println("7. Salir");
            System.out.print("Seleccione una opción: ");

            int opcion = scanner.nextInt();
            scanner.nextLine();

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese la placa del carro: ");
                    String placaIngreso = scanner.nextLine();
                    int resultadoIngreso = parqueadero.entrarCarro(placaIngreso);
                    if (resultadoIngreso == Parqueadero.NO_HAY_PUESTO) {
                        System.out.println("No hay puestos disponibles.");
                    } else if (resultadoIngreso == Parqueadero.CARRO_YA_EXISTE) {
                        System.out.println("El carro ya está en el parqueadero.");
                    } else if (resultadoIngreso == Parqueadero.PARQUEADERO_CERRADO) {
                        System.out.println("El parqueadero está cerrado.");
                    } else {
                        System.out.println("Carro ingresado en el puesto: " + resultadoIngreso);
                    }
                    break;

                case 2:
                    System.out.print("Ingrese la placa del carro: ");
                    String placaSalida = scanner.nextLine();
                    int resultadoSalida = parqueadero.sacarCarro(placaSalida);
                    if (resultadoSalida == Parqueadero.CARRO_NO_EXISTE) {
                        System.out.println("El carro no existe en el parqueadero.");
                    } else if (resultadoSalida == Parqueadero.PARQUEADERO_CERRADO) {
                        System.out.println("El parqueadero está cerrado.");
                    } else {
                        System.out.println("El monto a pagar es: " + resultadoSalida);
                    }
                    break;

                case 3:
                    System.out.println("Los ingresos del parqueadero son: " + parqueadero.darMontoCaja());
                    break;

                case 4:
                    System.out.println("La cantidad de puestos disponibles es: " + parqueadero.calcularPuestosLibres());
                    break;

                case 5:
                    parqueadero.avanzarHora();
                    System.out.println("La hora actual es: " + parqueadero.darHoraActual());
                    break;

                case 6:
                    System.out.print("Ingrese la nueva tarifa: ");
                    int nuevaTarifa = scanner.nextInt();
                    parqueadero.cambiarTarifa(nuevaTarifa);
                    System.out.println("La nueva tarifa es: " + parqueadero.darTarifa());
                    break;

                case 7:
                    running = false;
                    System.out.println("Saliendo del programa.");
                    break;

                default:
                    System.out.println("Opción no válida. Intente nuevamente.");
                    break;
            }
        }

        scanner.close();
    }
}
