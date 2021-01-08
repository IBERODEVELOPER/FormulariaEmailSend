package informatico.to.formulariaemailsend;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {
    /*creamos variables de las clases*/
    Button btnenaviarformulario ,btnsendmailsimple;
    EditText edtdatospersonareceptor,edtasunto,edtcuerpomail;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //para el icono en el action bar
        getSupportActionBar().setDisplayShowHomeEnabled(true);
        //llamamo a la imagen por su nombre que tiene que estar en drawable
        getSupportActionBar().setIcon(R.drawable.ic_action_name);
       //instanciar la variable local con id  de los componentes del xml
        //botones
        btnsendmailsimple=(Button)findViewById(R.id.btnemailsimple);
        btnenaviarformulario=(Button)findViewById(R.id.btnenviarformulario);
        //editText
        edtdatospersonareceptor=(EditText)findViewById(R.id.edtemailreceptor);
        edtasunto=(EditText)findViewById(R.id.edtasunto);
        edtcuerpomail=(EditText)findViewById(R.id.edtcuerpomail);
        /*limpiamos las cajas de texto
        edtdatospersona.setError(null);
        edtemailadrres.setError(null);
        edtconsulta.setError(null);*/

        }

        public void MailSimple(View view){
            Intent emailIntent = new Intent(Intent.ACTION_SEND);
            emailIntent.setData(Uri.parse("mailto:"));
            emailIntent.setType("text/plain");
            startActivity(emailIntent);
        }

        public void FormularioMail(View view){
        /*Convertimos a cadena string*/
        String receptor=edtdatospersonareceptor.getText().toString();
        String asunto=edtasunto.getText().toString();
        String cuerpomail=edtcuerpomail.getText().toString();
        /*consultamos si los datos en cadena que convertimos
        de los edittext si se encuentan vacios*/
        if(receptor.equals("")&&asunto.equals("")&&cuerpomail.equals("")){
            edtdatospersonareceptor.setError("Ingrese email del destinatario");
            edtasunto.setError("Ingrese asunto del correo");
            edtcuerpomail.setError("Ingrese consultay /o mensaje");
            }
        else {
            // Defino mi Intent Y Llamo a la funcion o metodo Action_send
            Intent intent = new Intent(Intent.ACTION_SEND);
            /*paso los datos string receptor, asunto y cuerpomail a la función
            putExtra que enviara los datos del formulario a la actividad del correo.*/
            intent.putExtra(Intent.EXTRA_EMAIL,new String[] { receptor });
            intent.putExtra(Intent.EXTRA_SUBJECT, asunto);
            intent.putExtra(Intent.EXTRA_TEXT, cuerpomail);
            // Establezco el tipo de Intent
            intent.setType("message/rfc822");
            // Lanzo el selector de cliente de Correo y lo otorgamos titulo
            startActivity(Intent.createChooser(intent,"Elije un cliente de Correo:Gmail"));
            
        }


        }
}