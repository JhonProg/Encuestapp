package keaplus.com.co.sistemaencuesta.Dao;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import java.util.ArrayList;
import java.util.List;

import keaplus.com.co.sistemaencuesta.Bean.UsuarioBean;
import keaplus.com.co.sistemaencuesta.Bean.UsuarioPreguntaRespuestaBean;
import keaplus.com.co.sistemaencuesta.Persistencia.BDConexion;
import keaplus.com.co.sistemaencuesta.Static.ConsultaSQL;

/**
 * Created by Jhon on 03/12/2015.
 */
public class EncuestaDAO extends BDConexion {

    public EncuestaDAO(Context context) {
        super(context);
    }

    public boolean presentoEncuesta(UsuarioBean usuario){
        boolean yaPresento = false;

        SQLiteDatabase db = null;
        Cursor cursor = null;
        try {
            db = getReadableDatabase();
            String[] parametros = {String.valueOf(usuario.getIdUsuario())};
            cursor = db.rawQuery(ConsultaSQL.getConsultaPresentoEncuesta(),parametros);

            if(cursor!=null && cursor.moveToFirst()){
                yaPresento = true;
            }

        }catch (Exception e){
            Log.e("Error","Ocurrio un error al consultar si un usuario ya presento la encuesta.");
        }
        return yaPresento;
    }

    public List<String> insertarRespuestas(List<String> respuestas){
        long idGenerado = 0;
        SQLiteDatabase db = null;
        List<String> ids = new ArrayList<>();

        try {
            db = getWritableDatabase();
            ContentValues valores = null;

            idGenerado = db.insert("usuario", null, valores);

            for(String respuesta : respuestas) {
                valores = new ContentValues();
                String[] arreglo = respuesta.split(",");
                int idUser = Integer.valueOf(arreglo[0]);
                int idPregunta = Integer.valueOf(arreglo[1]);
                int idOpcion = Integer.valueOf(arreglo[2]);

                valores.put("idusuario", idUser);
                valores.put("idpregunta", idPregunta);
                valores.put("idopcion", idOpcion);

                idGenerado = db.insert("usuario_pregunta_respuesta", null, valores);

                if (idGenerado > 0) {
                    ids.add(String.valueOf(idGenerado));
                }
            }
        }catch(Exception e){
            Log.i("ERROR AL INSERTAR", "Error." + e.toString());
            e.printStackTrace();
        }finally {
            db.close();
        }

        return ids;
    }


    public  List<UsuarioPreguntaRespuestaBean> getRespuestas(){
        UsuarioPreguntaRespuestaBean usuarioPreguntaRespuestaBean = null;
        List<UsuarioPreguntaRespuestaBean> lista = new ArrayList<>();

        SQLiteDatabase db = null;
        try{
            db = getReadableDatabase();
            if(db!=null){

                Cursor cursor = db.rawQuery(ConsultaSQL.getConsultaRespuestas(),null);

                if(cursor.moveToFirst()){
                    do {
                        usuarioPreguntaRespuestaBean = new UsuarioPreguntaRespuestaBean();

                        int idUsuarioPreguntaRespuesta=cursor.getInt(0);
                        int idUsuario=cursor.getInt(1);
                        int idPregunta=cursor.getInt(2);
                        int idOpcion=cursor.getInt(3);

                        usuarioPreguntaRespuestaBean.setIdusuariopreguntarespuesta(idUsuarioPreguntaRespuesta);
                        usuarioPreguntaRespuestaBean.setIdUsuario(idUsuario);
                        usuarioPreguntaRespuestaBean.setIdPregunta(idPregunta);
                        usuarioPreguntaRespuestaBean.setIdOpcion(idOpcion);

                        lista.add(usuarioPreguntaRespuestaBean);

                    } while(cursor.moveToNext());
                }
            }
        }catch(Exception e){

        }finally{
            db.close();
        }
        return lista;
    }

}
