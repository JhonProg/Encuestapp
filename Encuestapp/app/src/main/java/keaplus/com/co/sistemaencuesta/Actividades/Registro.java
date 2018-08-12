package keaplus.com.co.sistemaencuesta.Actividades;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import keaplus.com.co.sistemaencuesta.Bean.UsuarioBean;
import keaplus.com.co.sistemaencuesta.Constante.UsuarioTipoEnum;
import keaplus.com.co.sistemaencuesta.Dao.UsuarioDAO;
import keaplus.com.co.sistemaencuesta.R;

public class Registro extends AppCompatActivity implements View.OnClickListener{

    private EditText etNombre;
    private EditText etApellido;
    private EditText etCorreo;
    private EditText etFechaNacimiento;
    private EditText etTelefono;
    private EditText etuserName;
    private EditText etClave;
    private Button btnRegistrarUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registro);
    }

    @Override
    protected void onResume() {

        etNombre = (EditText)findViewById(R.id.editTextRegistroNombre);
        etApellido = (EditText)findViewById(R.id.editTextRegistroApellido);
        etCorreo = (EditText)findViewById(R.id.editTextRegistroCorreo);
        etFechaNacimiento = (EditText)findViewById(R.id.editTextRegistroFechaNacimiento);
        etTelefono = (EditText)findViewById(R.id.editTextRegistroTelefono);
        etuserName = (EditText)findViewById(R.id.editTextRegistroNombreUsuario);
        etClave = (EditText)findViewById(R.id.editTextRegistroClave);

        btnRegistrarUsuario = (Button) findViewById(R.id.buttonRegristrarUsuario);

        btnRegistrarUsuario.setOnClickListener(this);

        super.onResume();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==btnRegistrarUsuario.getId()){
            if(validarCampos()){
                UsuarioBean nuevoUsuario = getUsuarioRegistrar();
                UsuarioDAO usuarioDAO = new UsuarioDAO(getApplicationContext());
                boolean resultadoInsercion = usuarioDAO.insertarUsuario(nuevoUsuario);

                if(resultadoInsercion==true){
                    printMensaje("Usted, ha sido registrado(a) correctamente.");
                    Intent data  = new Intent();
                    data.putExtra("resultadoRegistro","OK");
                    setResult(Activity.RESULT_OK, data);
                    finish();
                }else{
                    printMensaje("Hubo un error al resgistrarse, vueleva a intentarlo.");
                    limpiarCampos();
                }
            }else{
                printMensaje("Hay campos sin completar.");
            }
        }
    }

    private UsuarioBean getUsuarioRegistrar(){
        UsuarioBean usuario = new UsuarioBean();

        usuario.setNombre(etNombre.getText().toString());
        usuario.setApellido(etApellido.getText().toString());
        usuario.setFechaNacimiento(etFechaNacimiento.getText().toString());
        usuario.setUsername(etuserName.getText().toString());
        usuario.setClave(etClave.getText().toString());
        usuario.setIdUsuarioTipo(UsuarioTipoEnum.ENCUESTADO.getIndex());

        String correo = etCorreo.getText().toString();
        String telefono = etTelefono.getText().toString();

        if(correo.length()==0){
            usuario.setCorreo(null);
        }else{
            usuario.setCorreo(correo);
        }
        if(telefono.length()==0){
            usuario.setTelefono(null);
        }else{
            usuario.setTelefono(telefono);
        }
        return usuario;
    }

    private boolean validarCampos(){
        boolean ok = false;

        String campoNombre = etNombre.getText().toString();
        String campoApellido = etApellido.getText().toString();
        String campoCorreo = etCorreo.getText().toString();
        String campoFechaNac = etFechaNacimiento.getText().toString();
        String campoTelefono = etTelefono.getText().toString();
        String campoUserName = etuserName.getText().toString();
        String campoClave = etClave.getText().toString();

        if(campoNombre.length()>0 && campoApellido.length()>0 && campoFechaNac.length()>0 && campoUserName.length()>0 && campoClave.length()>0){
            ok=true;
        }
        return ok;
    }

    private void printMensaje(String msn){
        Toast.makeText(getApplicationContext(), msn, Toast.LENGTH_LONG).show();
    }

    private void limpiarCampos(){
        etNombre.setText("");
        etApellido.setText("");
        etCorreo.setText("");
        etFechaNacimiento.setText("");
        etTelefono.setText("");
        etuserName.setText("");
        etClave.setText("");
    }
}
