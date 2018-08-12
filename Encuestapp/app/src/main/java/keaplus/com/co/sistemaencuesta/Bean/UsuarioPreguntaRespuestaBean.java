package keaplus.com.co.sistemaencuesta.Bean;

/**
 * Created by Jhon on 29/11/2015.
 */

public class UsuarioPreguntaRespuestaBean {
    private int idusuariopreguntarespuesta;
    private int idUsuario;
    private int idPregunta;
    private int idOpcion;

    public int getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(int idUsuario) {
        this.idUsuario = idUsuario;
    }

    public int getIdPregunta() {
        return idPregunta;
    }

    public void setIdPregunta(int idPregunta) {
        this.idPregunta = idPregunta;
    }

    public int getIdOpcion() {
        return idOpcion;
    }

    public void setIdOpcion(int idOpcion) {
        this.idOpcion = idOpcion;
    }

    public int getIdusuariopreguntarespuesta() {
        return idusuariopreguntarespuesta;
    }

    public void setIdusuariopreguntarespuesta(int idusuariopreguntarespuesta) {
        this.idusuariopreguntarespuesta = idusuariopreguntarespuesta;
    }
}
