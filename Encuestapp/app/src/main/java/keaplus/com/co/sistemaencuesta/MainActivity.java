package keaplus.com.co.sistemaencuesta;

import android.app.Activity;
import android.bluetooth.BluetoothHeadset;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import keaplus.com.co.sistemaencuesta.Actividades.InicioAdministrador;
import keaplus.com.co.sistemaencuesta.Actividades.InicioEncuestado;
import keaplus.com.co.sistemaencuesta.Actividades.Registro;
import keaplus.com.co.sistemaencuesta.Bean.UsuarioBean;
import keaplus.com.co.sistemaencuesta.Constante.UsuarioTipoEnum;
import keaplus.com.co.sistemaencuesta.Constante.VentanaTipoEnum;
import keaplus.com.co.sistemaencuesta.Dao.EncuestaDAO;
import keaplus.com.co.sistemaencuesta.Dao.LoginDAO;
import keaplus.com.co.sistemaencuesta.Parcelable.UsuarioParcelable;
import keaplus.com.co.sistemaencuesta.Static.ObjetoParcelable;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etNombreUsuario;
    private EditText etClave;
    private Button btnIngresar;
    private Button btnRegister;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    @Override
    protected void onResume() {
        etNombreUsuario = (EditText) findViewById(R.id.editTextUsuario);
        etClave = (EditText) findViewById(R.id.editTextClave);
        btnIngresar = (Button)findViewById(R.id.buttonIngresar);
        btnRegister= (Button)findViewById(R.id.buttonRegistrarse);

        etNombreUsuario.setText("");
        etClave.setText("");

        btnIngresar.setOnClickListener(this);
        btnRegister.setOnClickListener(this);

        super.onResume();
    }

    @Override
    public void onClick(View v) {
        int idVista = v.getId();

        if(idVista==btnIngresar.getId()){
            String userName = etNombreUsuario.getText().toString();
            String clave = etClave.getText().toString();

            boolean userNameVacio = false;
            boolean claveVacio = false;

            if(userName.length()==0){ userNameVacio = true; }
            if(clave.length()==0){ claveVacio = true; }

            if(userNameVacio && claveVacio){
                mostrarMensaje("Ingrese usuario y clave");
            }else if(userNameVacio){
                mostrarMensaje("Ingrese nombre de usuario");
            }else if(claveVacio){
                mostrarMensaje("Ingrese una clave");
            }else if(userNameVacio==false && claveVacio==false){
                LoginDAO loginDAO = new LoginDAO(getApplicationContext());
                UsuarioBean usuario = loginDAO.login(userName,clave);

                if(usuario==null){
                    mostrarMensaje("Usuario no existe.");
                    limpiarCampos();
                }else{
                    if(usuario.getIdUsuarioTipo()== UsuarioTipoEnum.ADMINISTRADOR.getIndex()){
                        abrirVentana(v, VentanaTipoEnum.INICIOADMINISTRADOR.getIndex(),usuario);
                    }else if(usuario.getIdUsuarioTipo()== UsuarioTipoEnum.ENCUESTADO.getIndex()){
                        abrirVentana(v, VentanaTipoEnum.INICIOENCUESTADO.getIndex(),usuario);
                    }
                }
            }
        }else if(idVista==btnRegister.getId()){
            abrirVentana(v,VentanaTipoEnum.REGISTRO.getIndex(),null);
        }
    }

    private void mostrarMensaje(String mensaje){
        Toast.makeText(getApplicationContext(),mensaje,Toast.LENGTH_LONG).show();
    }


    private void abrirVentana(View view,int tipoVentana,UsuarioBean usuario) {
        UsuarioParcelable usuarioParcelable = null;

        if(usuario!=null){
            usuarioParcelable = ObjetoParcelable.getUsuarioParcelable(usuario);
        }

        if(VentanaTipoEnum.INICIOADMINISTRADOR.getIndex()==tipoVentana){
            if(usuarioParcelable!=null){
                Intent intento = new Intent(this, InicioAdministrador.class );
                intento.putExtra("usuario", usuarioParcelable);
                startActivity(intento);
            }else{
                mostrarMensaje("Error al cargar datos de usuario.");
            }

        }else if(VentanaTipoEnum.INICIOENCUESTADO.getIndex()==tipoVentana){
            if(usuarioParcelable!=null){

                EncuestaDAO encuestaDAO = new EncuestaDAO(getApplicationContext());
                boolean yaPresentoEncuesta  = encuestaDAO.presentoEncuesta(usuario);

                if(yaPresentoEncuesta){
                    mostrarMensaje("Usted, ya presentó la encuesta. Gracias por participar.");
                }else{
                    Intent intento = new Intent(this, InicioEncuestado.class );
                    intento.putExtra("usuario", usuarioParcelable);
                    startActivity(intento);
                }
            }else{
                mostrarMensaje("Error al cargar datos de usuario.");
            }
        }else if(VentanaTipoEnum.REGISTRO.getIndex()==tipoVentana){
            Intent intento = new Intent(this, Registro.class );
            startActivityForResult(intento, 1);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        validarResultado(requestCode,resultCode,data);
    }


    /**
     * Valida el resultado que retorno la llamada a la segunda actividad.
     * */
    private void validarResultado(int requestCode, int resultCode, Intent data){
        switch (requestCode){
            case 1:
                if(resultCode==Activity.RESULT_OK){
                    String resultadoDevuelto = data.getStringExtra("resultadoRegistro");
                    if(resultadoDevuelto.equalsIgnoreCase("OK")){
                        Toast.makeText(getApplicationContext(),"Ahora puede iniciar sesión.",Toast.LENGTH_LONG).show();
                    }else{
                        Toast.makeText(getApplicationContext(),"Ocurrió un error al registrarse.",Toast.LENGTH_LONG).show();
                    }
                }else{
                    Toast.makeText(getApplicationContext(),"Ocurrió un error, Vuelva a intentarlo",Toast.LENGTH_LONG).show();
                    limpiarCampos();
                }
                break;
        }
    }



    /**
     * Limpia los campos Usuario y Clave.
     * */
    private void limpiarCampos(){
        etNombreUsuario.setText("");
        etClave.setText("");

    }



}
