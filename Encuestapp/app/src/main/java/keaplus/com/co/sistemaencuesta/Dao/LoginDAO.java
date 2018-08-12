package keaplus.com.co.sistemaencuesta.Dao;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.util.Log;

import keaplus.com.co.sistemaencuesta.Bean.UsuarioBean;
import keaplus.com.co.sistemaencuesta.Static.ConsultaSQL;
import keaplus.com.co.sistemaencuesta.Persistencia.BDConexion;

/**
 * Created by Jhon on 29/11/2015.
 */
public class LoginDAO extends BDConexion{

    public LoginDAO(Context contexto){
        super(contexto);
    }


    public  UsuarioBean login(String userName, String clave){
        UsuarioBean usuario = null;

        Log.i("","Se va a consultar al usuario ["+userName+"] ["+clave+"]");

        SQLiteDatabase db = null;
        try{
            db = getReadableDatabase();
            if(db!=null){
                String[] parametros = {userName,clave};

                Cursor cursor = db.rawQuery(ConsultaSQL.getConsultaLogin(),parametros);

                if(cursor.moveToFirst()){
                    usuario = new UsuarioBean();
                    usuario.setIdUsuario(cursor.getInt(cursor.getColumnIndex("idusuario")));
                    usuario.setIdUsuarioTipo(cursor.getInt(cursor.getColumnIndex("idusuariotipo")));
                    usuario.setNombre(cursor.getString(cursor.getColumnIndex("nombre")));
                    usuario.setApellido(cursor.getString(cursor.getColumnIndex("apellido")));
                    usuario.setCorreo(cursor.getString(cursor.getColumnIndex("correo")));
                    usuario.setFechaNacimiento(cursor.getString(cursor.getColumnIndex("fechanacimiento")));
                    usuario.setTelefono(cursor.getString(cursor.getColumnIndex("telefono")));
                    usuario.setUsername(userName);
                    usuario.setClave(clave);
                }
            }
        }catch(Exception e){

        }finally{
            db.close();
        }
        return usuario;
    }

}
