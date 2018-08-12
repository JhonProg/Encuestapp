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
import android.widget.RadioGroup;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import keaplus.com.co.sistemaencuesta.R;

public class PreguntaUnoActivity extends AppCompatActivity implements View.OnClickListener{

    private String seleccion;
    private final int idPRegunta = 1;
    private int idUser;

    private RadioGroup grupo;
    private RadioButton si;
    private RadioButton no;

    private Button boton;

    public PreguntaUnoActivity() {
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_uno);
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

        grupo = (RadioGroup) findViewById(R.id.rgPreguntaUno);
        si = (RadioButton) findViewById(R.id.radioButtonp1o1);
        no = (RadioButton) findViewById(R.id.radioButtonp1o2);
        boton = (Button) findViewById(R.id.buttonSiguienteP1);

        boton.setOnClickListener(this);

        super.onResume();
    }


    @Override
    public void onClick(View v) {

        if(v.getId()==boton.getId()) {
            String respuestaUno = "";
            if (si.isChecked()) {
                respuestaUno = idUser + "," + idPRegunta + "," + "1";
            } else if (no.isChecked()) {
                respuestaUno = idUser + "," + idPRegunta + "," + "2";
            } else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }

            if (respuestaUno.length() > 0) {
                Intent intento = new Intent(this, PreguntaDosActivity.class );
                intento.putExtra("idusuario",idUser);
                intento.putExtra("respuestaUno",respuestaUno);
                startActivity(intento);
            } else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }
        }
    }
}
