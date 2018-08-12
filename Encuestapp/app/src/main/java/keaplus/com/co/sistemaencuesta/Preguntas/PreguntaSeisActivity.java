package keaplus.com.co.sistemaencuesta.Preguntas;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import keaplus.com.co.sistemaencuesta.R;

public class PreguntaSeisActivity extends AppCompatActivity implements View.OnClickListener{

    private int idUser;

    private RadioButton uno;
    private RadioButton dos;
    private RadioButton tres;
    private RadioButton cuatro;

    private Button boton;
    private String respuestaUno;
    private String respuestaDos;
    private String respuestaTres;
    private String respuestaCuatro;
    private String respuestaCinco;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_seis);
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

        idUser = getIntent().getExtras().getInt("idusuario");

        respuestaUno = getIntent().getExtras().getString("respuestaUno");
        respuestaDos = getIntent().getExtras().getString("respuestaDos");
        respuestaTres = getIntent().getExtras().getString("respuestaTres");
        respuestaCuatro = getIntent().getExtras().getString("respuestaCuatro");
        respuestaCinco = getIntent().getExtras().getString("respuestaCinco");

        uno = (RadioButton) findViewById(R.id.radioButtonp6o1);
        dos = (RadioButton) findViewById(R.id.radioButtonp6o2);
        tres = (RadioButton) findViewById(R.id.radioButtonp6o3);
        cuatro = (RadioButton) findViewById(R.id.radioButtonp6o4);

        boton = (Button) findViewById(R.id.buttonSiguienteP6);

        boton.setOnClickListener(this);

        super.onResume();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==boton.getId()) {
            String respuestaSeis = "";
            if (uno.isChecked()) {
                respuestaSeis = idUser + "," + "6" + "," + "1";
            } else if (dos.isChecked()) {
                respuestaSeis = idUser + "," + "6" + "," + "2";
            } else if (tres.isChecked()) {
                respuestaSeis = idUser + "," + "6" + "," + "3";
            } else if (cuatro.isChecked()) {
                respuestaSeis = idUser + "," + "6" + "," + "4";
            } else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }

            if (respuestaSeis.length() > 0) {
                Intent intento = new Intent(this, PreguntaSieteActivity.class );
                intento.putExtra("idusuario",idUser);
                intento.putExtra("respuestaUno",respuestaUno);
                intento.putExtra("respuestaDos",respuestaDos);
                intento.putExtra("respuestaTres",respuestaTres);
                intento.putExtra("respuestaCuatro",respuestaCuatro);
                intento.putExtra("respuestaCinco",respuestaCinco);
                intento.putExtra("respuestaSeis",respuestaSeis);
                startActivity(intento);
            } else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }
        }
    }
}
