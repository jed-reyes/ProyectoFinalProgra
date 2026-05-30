public class ListaCarnet {
    private Nodo inicio;
    public ListaCarnet() {
    inicio = null;
    }
    public void insertar(Alumno alumno) {
    Nodo nuevo = new Nodo(alumno);
    if (inicio == null || alumno.getCarnet() < inicio.alumno.getCarnet()) {
    nuevo.siguiente = inicio;
    inicio = nuevo;
    return;
        }
        Nodo actual = inicio;
        while (actual.siguiente != null && alumno.getCarnet() > actual.siguiente.alumno.getCarnet()) {
        actual = actual.siguiente;
        }
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
    }
    public void mostrar() {
    Nodo actual = inicio;
        while (actual != null) {
            System.out.println(actual.alumno.getCarnet() + " | " + actual.alumno.getNombre() + " | " + actual.alumno.getNota());
            actual = actual.siguiente;
        }
    }
}