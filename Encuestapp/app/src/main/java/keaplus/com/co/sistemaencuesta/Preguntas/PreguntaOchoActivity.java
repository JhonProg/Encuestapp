package keaplus.com.co.sistemaencuesta.Preguntas;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import keaplus.com.co.sistemaencuesta.Dao.EncuestaDAO;
import keaplus.com.co.sistemaencuesta.MainActivity;
import keaplus.com.co.sistemaencuesta.R;

public class PreguntaOchoActivity extends AppCompatActivity  implements View.OnClickListener{

    private int idUser;

    private Button boton;

    private String respuestaUno;
    private String respuestaDos;
    private String respuestaTres;
    private String respuestaCuatro;
    private String respuestaCinco;
    private String respuestaSeis;
    private String respuestaSiete;

    private String respuestaOcho = "";

    private EditText etRespuestaOcho;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pregunta_ocho);
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
        respuestaSiete = getIntent().getExtras().getString("respuestaSiete");

        etRespuestaOcho  = (EditText)findViewById(R.id.editTextRespuestaOcho);

        boton = (Button) findViewById(R.id.buttonSiguienteP8);

        boton.setOnClickListener(this);

        super.onResume();
    }

    @Override
    public void onClick(View v) {
        if(v.getId()==boton.getId()){
            respuestaOcho = etRespuestaOcho.getText().toString();

            if(respuestaOcho.length()==0){
                Toast.makeText(this,"Debe enumerar las marcas.",Toast.LENGTH_LONG).show();
            }else{
                //TODO:  INSERTAGR EL CAMPO ABIERTO. (Se paso por alto este requerimiento)
                List<String>  listaRespuestas = obtenerListaRespuestas();

                if(listaRespuestas.size()>0){

                    EncuestaDAO encuestaDAO = new EncuestaDAO(getApplicationContext());
                    List<String> listaIdsInsertados = encuestaDAO.insertarRespuestas(listaRespuestas);

                    if(listaIdsInsertados.size()==listaRespuestas.size()){
                        Log.i("######", "SE INSERTARON TODAS LAS RESPUESTAS CORRECTAMENTE.");
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
