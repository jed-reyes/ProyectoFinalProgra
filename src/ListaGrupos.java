public class ListaGrupos {
    private NodoGrupo inicio;
    public ListaGrupos() {
        inicio = null;
    }
    public Grupo buscarGrupo(String curso,
    String seccion) {
       NodoGrupo actual = inicio;
        while (actual != null) {
          if (actual.grupo.getCodigoCurso().equals(curso) && actual.grupo.getSeccion().equals(seccion)) {
            return actual.grupo;
          }
       actual = actual.siguiente;
        }
        return null;
    }
    public void agregarGrupo(Grupo grupo) {
    NodoGrupo nuevo = new NodoGrupo(grupo);
    nuevo.siguiente = inicio;
    inicio = nuevo;
    }
    public NodoGrupo getInicio() {
        return inicio;
    }
}