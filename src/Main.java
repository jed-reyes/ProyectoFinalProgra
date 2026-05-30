import java.util.Scanner;
public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        GestorListas gestor = new GestorListas();
        int opcion;
        String archivo;
        do {
         System.out.println("\n==========================");
         System.out.println(" PROYECTO 3 LISTAS");
         System.out.println("==========================");
         System.out.println("1. Cargar archivo");
         System.out.println("2. Mostrar simulacion");
         System.out.println("3. Mostrar por Nombre");
         System.out.println("4. Mostrar por Carnet");
         System.out.println("5. Mostrar por Nota");
         System.out.println("6. Mostrar 5 mas altas y 5 mas bajas");
         System.out.println("7. Mostrar Promedio");
         System.out.println("8. Salir");
         System.out.print("Opcion: ");
           opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion) {
                case 1:
                System.out.print("Ingrese nombre del archivo: ");
                archivo = teclado.nextLine();
                gestor.cargarArchivo(archivo);
                break;
                case 2:
                gestor.simularListaNombre();
                break;
                case 3:
                gestor.mostrarPorNombre();
                break;
                case 4:
                gestor.mostrarPorCarnet();
                break;
                case 5:
                gestor.mostrarPorNota();
                break;
                case 6:

                gestor.mostrar5MasAltas();

                gestor.mostrar5MasBajas();
                break;
                case 7: gestor.promedioPorGrupo();
                break;
                case 8:
                System.out.println("Programa finalizado.");
                break;
                default:
                   System.out.println(
                   "Opcion incorrecta.");
           }
        } while (opcion != 8);
        teclado.close();
    }
}