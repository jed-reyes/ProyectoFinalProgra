public class ListaNombre {
    private Nodo inicio;
    public ListaNombre() {
        inicio = null;
    }
    public void insertar(Alumno alumno) {
    Nodo nuevo = new Nodo(alumno);
    if (inicio == null) {
        inicio = nuevo;
         return;
        }
    if (alumno.getNombre().compareToIgnoreCase(
        inicio.alumno.getNombre()) < 0) {
        nuevo.siguiente = inicio;
        inicio = nuevo;
        return;
        }
        Nodo actual = inicio;
        while (actual.siguiente != null &&
        alumno.getNombre().compareToIgnoreCase(
        actual.siguiente.alumno.getNombre()) > 0) {
        actual = actual.siguiente;
        }
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
    }
    public void mostrar() {
    Nodo actual = inicio;
    while (actual != null) {
    System.out.println(
    actual.alumno.getNombre() + " | " +
    actual.alumno.getCarnet() + " | " +
    actual.alumno.getNota());
    actual = actual.siguiente;
        }
    }
    public Nodo getInicio() {
        return inicio;
    }
    public void simular() {
        Nodo actual = inicio;
        while (actual != null) {
          System.out.print("[" + actual.alumno.getNombre() + "]");
          if (actual.siguiente != null) {
         System.out.print(" -> ");
            }
  actual = actual.siguiente;
       }
    System.out.println(" -> NULL");
    }
}