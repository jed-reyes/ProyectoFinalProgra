public class Grupo {
    private String codigoCurso;
    private String seccion;
    private ListaNombre listaNombre;
    private ListaCarnet listaCarnet;
    public Grupo(String codigoCurso, String seccion) {
     this.codigoCurso = codigoCurso;
     this.seccion = seccion;
      listaNombre = new ListaNombre();
      listaCarnet = new ListaCarnet();
    }
    public String getCodigoCurso() {
     return codigoCurso;
    }
    public String getSeccion() {
     return seccion;
    }
    public ListaNombre getListaNombre() {
     return listaNombre;
    }
    public ListaCarnet getListaCarnet() {
     return listaCarnet;
    }
    public void insertarAlumno(Alumno alumno) {
     listaNombre.insertar(alumno);
     listaCarnet.insertar(alumno);
    }
}