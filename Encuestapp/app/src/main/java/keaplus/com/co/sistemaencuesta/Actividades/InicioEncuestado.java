package keaplus.com.co.sistemaencuesta.Actividades;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import keaplus.com.co.sistemaencuesta.Parcelable.UsuarioParcelable;
import keaplus.com.co.sistemaencuesta.Preguntas.PreguntaUnoActivity;
import keaplus.com.co.sistemaencuesta.R;

public class InicioEncuestado extends AppCompatActivity implements View.OnClickListener{

    private TextView tvNombreUserLogueado;
    private Button btnResponderEncuesta;
    private List<String> respuestas = new ArrayList<>();
    private int idUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_inicio_encuestado);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        FloatingActionButton fab = (FloatingActionButton) findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                        .setAction("Action", null).show();
            }
        });
    }

    @Override
    protected void onResume() {
        tvNombreUserLogueado = (TextView)findViewById(R.id.textViewNombreUsuarioLogueado2);
        btnResponderEncuesta = (Button) findViewById(R.id.buttonResponderEncuesta);

        btnResponderEncuesta.setOnClickListener(this);

        UsuarioParcelable obj = (UsuarioParcelable)getIntent().getExtras().getParcelable("usuario");
        String name = obj.getNombre();
        String apellido = obj.getApellido();
        idUsuario = obj.getIdUsuario();
        printMensaje("Bienvenido "+name);
        tvNombreUserLogueado.setText("Bienvenido(a), " + name + " " + apellido);

        super.onResume();
    }

    private void printMensaje(String msn){
        Toast.makeText(getApplicationContext(), msn, Toast.LENGTH_LONG).show();
    }


    @Override
    public void onClick(View v) {
        if(v.getId()==btnResponderEncuesta.getId()){
            Intent intento = new Intent(this, PreguntaUnoActivity.class );
            intento.putExtra("idusuario",idUsuario);
            startActivity(intento);
        }
    }
}
