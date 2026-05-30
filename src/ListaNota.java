public class ListaNota {
    private Nodo inicio;
    public ListaNota() {
        inicio = null;
    }
    public void insertar(Alumno alumno) {
        Nodo nuevo = new Nodo(alumno);
        if (inicio == null ||
                alumno.getNota() > inicio.alumno.getNota()) {
            nuevo.siguiente = inicio;
            inicio = nuevo;
            return;
        }
        Nodo actual = inicio;
        while (actual.siguiente != null && alumno.getNota() < actual.siguiente.alumno.getNota()) {
            actual = actual.siguiente;
        }
        nuevo.siguiente = actual.siguiente;
        actual.siguiente = nuevo;
    }
    public void mostrar() {
        Nodo actual = inicio;
        while (actual != null) {
            System.out.println(actual.alumno.getNota() + " | " +actual.alumno.getCarnet() + " | " +actual.alumno.getNombre());
        actual = actual.siguiente;
        }
    }
    public void simular() {
        Nodo actual = inicio;
        while(actual != null){
        System.out.print("[" + actual.alumno.getNota() + "]");
        if(actual.siguiente != null){
           System.out.print(" -> ");
            }
        actual = actual.siguiente;
        }
    System.out.println(" -> NULL");
    }
   public Nodo getInicio() {
        return inicio;
    }
}
