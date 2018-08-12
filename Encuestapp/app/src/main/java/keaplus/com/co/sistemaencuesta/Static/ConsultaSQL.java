package keaplus.com.co.sistemaencuesta.Static;

/**
 * Created by Jhon on 29/11/2015.
 */
public class ConsultaSQL {

    static String consultaLogin="select idusuario,idusuariotipo,nombre,apellido,correo,fechanacimiento,telefono,username,clave " +
            "from usuario where  username=? and clave=?";

    static  String consultaPresentoEncuesta = "select idusuariopreguntarespuesta,idusuario,idpregunta,idopcion from usuario_pregunta_respuesta where idusuario=?";

    static String consultaRespuestas = "select idusuariopreguntarespuesta,idusuario,idpregunta,idopcion from usuario_pregunta_respuesta";

    public static String getConsultaLogin(){
        return consultaLogin;
    }

    public static  String getConsultaPresentoEncuesta(){
        return consultaPresentoEncuesta;
    }

    public static String getConsultaRespuestas() {
        return consultaRespuestas;
    }
}
