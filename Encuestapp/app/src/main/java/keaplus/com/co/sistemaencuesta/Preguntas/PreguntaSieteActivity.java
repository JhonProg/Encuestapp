package keaplus.com.co.sistemaencuesta.Preguntas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import keaplus.com.co.sistemaencuesta.Dao.EncuestaDAO;
import keaplus.com.co.sistemaencuesta.MainActivity;
import keaplus.com.co.sistemaencuesta.R;

public class PreguntaSieteActivity extends AppCompatActivity implements View.OnClickListener{

    private int idUser;

    private RadioButton uno;
    private RadioButton dos;

    private String respuestaSiete = "";

    private Button boton;
    private String respuestaUno;
    private String respuestaDos;
    private String respuestaTres;
    private String respuestaCuatro;
    private String respuestaCinco;
    private String respuestaSeis;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_siete);
    }

    @Override
    protected void onResume() {

        idUser = getIntent().getExtras().getInt("idusuario");

        respuestaUno = getIntent().getExtras().getString("respuestaUno");
        respuestaDos = getIntent().getExtras().getString("respuestaDos");
        respuestaTres = getIntent().getExtras().getString("respuestaTres");
        respuestaCuatro = getIntent().getExtras().getString("respuestaCuatro");
        respuestaCinco = getIntent().getExtras().getString("respuestaCinco");
        respuestaSeis = getIntent().getExtras().getString("respuestaSeis");

        uno = (RadioButton) findViewById(R.id.radioButtonp7o1);
        dos = (RadioButton) findViewById(R.id.radioButtonp7o2);

        boton = (Button) findViewById(R.id.buttonSiguienteP7);

        boton.setOnClickListener(this);

        super.onResume();
    }



    @Override
    public void onClick(View v) {
        if(v.getId()==boton.getId()) {

            if (uno.isChecked()) {
                respuestaSiete = idUser + "," + "7" + "," + "1";
            } else if (dos.isChecked()) {
                respuestaSiete = idUser + "," + "7" + "," + "2";
            }  else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }

            if (respuestaSiete.length() > 0) {

                if(uno.isChecked()){
                    Intent intento = new Intent(this, PreguntaOchoActivity.class );
                    intento.putExtra("idusuario",idUser);
                    intento.putExtra("respuestaUno",respuestaUno);
                    intento.putExtra("respuestaDos",respuestaDos);
                    intento.putExtra("respuestaTres",respuestaTres);
                    intento.putExtra("respuestaCuatro",respuestaCuatro);
                    intento.putExtra("respuestaCinco",respuestaCinco);
                    intento.putExtra("respuestaSeis",respuestaSeis);
                    intento.putExtra("respuestaSiete",respuestaSiete);
                    startActivity(intento);
                }else{

                    List<String> listaRespuestas = obtenerListaRespuestas();

                    if(listaRespuestas.size()>0){

                        EncuestaDAO encuestaDAO = new EncuestaDAO(getApplicationContext());
                        List<String> listaIdsInsertados = encuestaDAO.insertarRespuestas(listaRespuestas);

                        if(listaIdsInsertados.size()==listaRespuestas.size()){
                            Log.i("######","SE INSERTARON TODAS LAS RESPUESTAS CORRECTAMENTE.");
                            Toast.makeText(getApplicationContext(), "Gracias por participar.", Toast.LENGTH_LONG).show();
                            Intent intento = new Intent(this, MainActivity.class );
                            startActivity(intento);
                        } else{
                            Toast.makeText(getApplicationContext(), "Ocurrio un error al insertar la encuesta, vuelva a intentarlo.", Toast.LENGTH_LONG).show();
                            Intent intento = new Intent(this, MainActivity.class );
                            startActivity(intento);
                        }
                    }else{
                        Toast.makeText(getApplicationContext(), "Ocurrio un error al guardar los datos en la lista.", Toast.LENGTH_LONG).show();
                        Intent intento = new Intent(this, MainActivity.class );
                        startActivity(intento);
                    }
                }


            } else {
                Toast.makeText(getApplicationContext(), "Debe seleccionar una opcion", Toast.LENGTH_LONG).show();
            }
        }
    }

    private List<String> obtenerListaRespuestas(){
        List<String> lista = new ArrayList<>();

        lista.add(respuestaUno);
        lista.add(respuestaDos);
        lista.add(respuestaTres);
        lista.add(respuestaCuatro);
        lista.add(respuestaCinco);
        lista.add(respuestaSeis);
        lista.add(respuestaSiete);

        return lista;
    }

}
