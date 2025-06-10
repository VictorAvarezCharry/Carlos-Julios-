import java.util.Date;
import java.util.Scanner;
import java.text.SimpleDateFormat;

public class Main {
    public static void main(String[] args) {
        Scanner teclado = new Scanner(System.in);
        Biblioteca biblioteca = new Biblioteca();
        int opcion;

        do {
            System.out.println("BIBLIOTECA");
            System.out.println("1. Registrar libro");
            System.out.println("2. Registrar lector");
            System.out.println("3. Registrar préstamo");
            System.out.println("4. Devolver libro");
            System.out.println("5. Listar prestamos");
            System.out.println("6. Filtrar libros");
            System.out.println("7. Filtrar lectores");
            System.out.println("8. Generar reporte");
            System.out.println("9. Notificar vencimientos");
            System.out.println("10. Salir");
            System.out.print("Seleccione una opción: ");
            opcion = teclado.nextInt();
            teclado.nextLine(); // Limpiar el buffer

            switch (opcion) {
                case 1:
                    System.out.print("Ingrese ISBN: ");
                    String isbn = teclado.nextLine();
                    System.out.print("Ingrese título: ");
                    String titulo = teclado.nextLine();
                    System.out.print("Ingrese autor: ");
                    String autor = teclado.nextLine();
                    System.out.print("Ingrese género: ");
                    String genero = teclado.nextLine();
                    System.out.print("Ingrese año: ");
                    int anio = teclado.nextInt();
                    teclado.nextLine();
                    biblioteca.registrarLibro(isbn, titulo, autor, genero, anio);
                    System.out.println("Libro registrado");
                    break;

                case 2:
                    System.out.print("Ingrese nombre: ");
                    String nombre = teclado.nextLine();
                    System.out.print("Ingrese apellido: ");
                    String apellido = teclado.nextLine();
                    System.out.print("Ingrese cédula: ");
                    String cedula = teclado.nextLine();
                    System.out.print("Ingrese correo: ");
                    String correo = teclado.nextLine();
                    System.out.print("Ingrese contraseña: ");
                    String contrasena = teclado.nextLine();
                    biblioteca.registrarLector(nombre, apellido, cedula, correo, contrasena);
                    System.out.println("Lector registrado");
                    break;

                case 3:
                    System.out.print("Ingrese ID del préstamo: ");
                    int idPrestamo = teclado.nextInt();
                    teclado.nextLine();
                    System.out.print("Ingrese título del libro: ");
                    String tituloPrestamo = teclado.nextLine();
                    Libro libro = biblioteca.buscarLibro(tituloPrestamo);
                    if (libro != null && libro.isDisponible()) {
                        System.out.print("Ingrese cédula del lector: ");
                        String cedulaLector = teclado.nextLine();
                        Lector lector = biblioteca.buscarLector(cedulaLector);
                        if (lector != null) {
                            biblioteca.registrarPrestamo(idPrestamo, libro, lector);
                            System.out.println("Préstamo registrado");
                        } else {
                            System.out.println("Lector no encontrado");
                        }
                    } else {
                        System.out.println("Libro no encontrado o no Disponible");
                    }
                    break;

                case 4:
                    System.out.print("Ingrese título del libro a devolver: ");
                    String tituloDevolucion = teclado.nextLine();
                    Libro libroDevolver = biblioteca.buscarLibro(tituloDevolucion);
                    if (libroDevolver != null) {
                        biblioteca.devolverLibro(libroDevolver);
                        System.out.println("Libro devuelto");
                    } else {
                        System.out.println("Libro no encontrado");
                    }
                    break;

                case 5:
                    biblioteca.listarPrestamos();
                    break;

                case 6:
                    System.out.print("Ingrese criterio de bUsqueda (título o autor): ");
                    String criterioLibro = teclado.nextLine();
                    biblioteca.filtrarLibros(criterioLibro);
                    break;

                case 7:
                    System.out.print("Ingrese criterio de bUsqueda (nombre o apellido): ");
                    String criterioLector = teclado.nextLine();
                    biblioteca.filtrarLectores(criterioLector);
                    break;

                case 8:
                    System.out.print("Ingrese fecha inicial (YYYY-MM-DD): ");
                    String fechaIniStr = teclado.nextLine();
                    System.out.print("Ingrese fecha final (YYYY-MM-DD): ");
                    String fechaFinStr = teclado.nextLine();
                    SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                    Date[] rangoFechas = new Date[2];
                    try {
                        rangoFechas[0] = sdf.parse(fechaIniStr);
                        rangoFechas[1] = sdf.parse(fechaFinStr);
                    } catch (Exception e) {
                        System.out.println("Formato de fecha inválido. Use YYYY-MM-DD.");
                        break;
                    }
                    System.out.print("Ingrese estado (o presione Enter para todos): ");
                    String estado = teclado.nextLine();
                    biblioteca.generarReporte(rangoFechas, estado.isEmpty() ? null : estado);
                    break;

                case 9:
                    biblioteca.notificarVencimientos();
                    break;

                case 10:
                    System.out.println("Saliendo de la biblioteca...");
                    break;

                default:
                    System.out.println("Opción inválida.");
            }
        } while (opcion != 10);

        teclado.close();
    }
}