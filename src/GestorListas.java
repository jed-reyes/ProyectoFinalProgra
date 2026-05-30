import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
public class GestorListas {
    private String archivoActual;
    private ListaGrupos grupos;
    private ListaNombre listaNombre;
    private ListaCarnet listaCarnet;
    private ListaNota listaNota;
    public GestorListas() {
        listaNombre = new ListaNombre();
        listaCarnet = new ListaCarnet();
        listaNota = new ListaNota();
        grupos = new ListaGrupos();
    }
    public void simularPorNota(){
        listaNota.simular();
    }
    public void cargarArchivo(String nombreArchivo) {
        archivoActual = nombreArchivo;
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            while ((linea = br.readLine()) != null) {
                String[] datos = linea.split(",");
                long carnet = Long.parseLong(datos[0].trim());
                String nombre = datos[1].trim();
                String codigoCurso = datos[2].trim();
                String seccion = datos[3].trim();double nota = Double.parseDouble(datos[4].trim());
                Alumno alumno = new Alumno(carnet, nombre, codigoCurso, seccion, nota);
                listaNombre.insertar(alumno);
                listaCarnet.insertar(alumno);
                listaNota.insertar(alumno);
                Grupo grupo = grupos.buscarGrupo(codigoCurso, seccion);
                if (grupo == null) {grupo = new Grupo(codigoCurso, seccion);
                    grupos.agregarGrupo(grupo);
                }
                grupo.insertarAlumno(alumno);
            }
            br.close();
            System.out.println("\nDatos cargados correctamente.");
        } catch (IOException e) {
            System.out.println("Error al leer archivo.");
        }
    }
    public void mostrarPorNombre() {
        NodoGrupo actualGrupo = grupos.getInicio();
        while(actualGrupo != null){Grupo g = actualGrupo.grupo;
            System.out.println("\nCURSO: " + g.getCodigoCurso());
            System.out.println("SECCION: " + g.getSeccion());
            System.out.println("------------------");
            g.getListaNombre().mostrar();
            actualGrupo = actualGrupo.siguiente;
        }
    }
    public void mostrarPorCarnet() {
        NodoGrupo actualGrupo = grupos.getInicio();
        while(actualGrupo != null){
            Grupo g = actualGrupo.grupo;
            System.out.println("\nCURSO: " + g.getCodigoCurso());
            System.out.println("SECCION: " + g.getSeccion());
            System.out.println("------------------");
            g.getListaCarnet().mostrar();
            actualGrupo = actualGrupo.siguiente;
        }
    }
    public void mostrarPorNota() {
        System.out.println("\n===== ORDEN POR NOTA =====");
        listaNota.mostrar();
    }
    public void simularListaNombre() {
        System.out.println("\n===== SIMULACION =====");
        listaNombre.simular();
    }
    public void mostrar5MasAltas() {
        System.out.println("\n===== 5 NOTAS MAS ALTAS =====");
        Nodo actual = listaNota.getInicio();
        int contador = 0;
        while (actual != null &&
                contador < 5) {
            Alumno a = actual.alumno;
            System.out.println("Nota: " + a.getNota() + " | Nombre: " + a.getNombre() + " | Carnet: " + a.getCarnet() + " | Curso: " + a.getCodigoCurso() + " | Seccion: " + a.getSeccion());
            actual = actual.siguiente;
            contador++;
        }
    }
    public void mostrar5MasBajas() {
        System.out.println("\n===== 5 NOTAS MAS BAJAS =====");
        Nodo actual = listaNota.getInicio();
        if (actual == null) {
            return;
        }
        Alumno[] bajas = new Alumno[5];
        int cantidad = 0;
        while (actual != null) {
            if (cantidad < 5) {
                bajas[cantidad] = actual.alumno;
                cantidad++;
            } else {
                bajas[0] = bajas[1];
                bajas[1] = bajas[2];
                bajas[2] = bajas[3];
                bajas[3] = bajas[4];
                bajas[4] = actual.alumno;
            }
            actual = actual.siguiente;
        }
        for (int i = cantidad - 1; i >= 0; i--) {
            System.out.println("Nota: " + bajas[i].getNota() + " | Nombre: " + bajas[i].getNombre() + " | Carnet: " + bajas[i].getCarnet() + " | Curso: " + bajas[i].getCodigoCurso() + " | Seccion: " + bajas[i].getSeccion());
        }
    }
    public void promedioGeneral() {
        Nodo actual = listaNota.getInicio();
        double suma = 0;
        int contador = 0;
        while (actual != null) {
            suma += actual.alumno.getNota();
            contador++;
            actual = actual.siguiente;
        }
        if (contador > 0) {
            System.out.println("\nPromedio General: " + (suma / contador));
        }
    }
    public void mostrarArchivoOriginal(String nombreArchivo) {
        try {
            BufferedReader br = new BufferedReader(new FileReader(nombreArchivo));
            String linea;
            System.out.println("\n===== ARCHIVO ORIGINAL =====");
            while ((linea = br.readLine()) != null) {
                System.out.println(linea);
            }
            br.close();
        } catch (IOException e) {
            System.out.println("Error al abrir archivo.");
        }
    }public String getArchivoActual() {
        return archivoActual;
    }
    public void promedioPorGrupo() {
        NodoGrupo actualGrupo = grupos.getInicio();
        while(actualGrupo != null){
            Grupo grupo = actualGrupo.grupo;
            double suma = 0;
            int cantidad = 0;
            Nodo actualAlumno = grupo.getListaNombre().getInicio();
            while(actualAlumno != null){suma += actualAlumno.alumno.getNota();
                cantidad++;
                actualAlumno = actualAlumno.siguiente;
            }
            if(cantidad > 0){
                System.out.println("\nCurso: " + grupo.getCodigoCurso());
                System.out.println("Seccion: " + grupo.getSeccion());
                System.out.println("Promedio: " + (suma / cantidad));
            }
            actualGrupo = actualGrupo.siguiente;
        }
    }
}