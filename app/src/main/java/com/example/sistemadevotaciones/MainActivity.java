package com.example.sistemadevotaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Parcelable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.Arrays;

public class MainActivity extends AppCompatActivity {

    //Declaracion de los elemento de la interfaz
    private EditText cedula;
    private Button login;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //variables para los elementos graficos
        cedula = (EditText) findViewById(R.id.txt_loginCedula);
        login = (Button) findViewById(R.id.btn_login);

        //Vector Cedulas de los 39 estudinates
        String[] cedula_estudiante = {"8-944-327", "3-740-1394", "20-53-4282", "8-943-1867", "8-937-503", "8-952-2444", "8-0943-012", "8-986-549"
                , "8-957-1827", "8-940-1311", "8-863-1620", "8-964-691", "8-954-1126", "8-1039-1537", "8-925-1168", "8-940-1505", "8-938-925", "3-743-2493",
                "E-0008-169755", "8-971-1811", "8-940-408", "8-937-1640", "8-939-1578", "8-942-1406", "6-722-724", "8-941-1215", "8-962-1218", "8-941-924",
                "8-980-2414", "3-742-2055", "8-942-1192","8-904-1189", "8-959-857", "8-964-1554", "8-1066-1018", "8-1055-701", "8-970-242", "3-752-1461",
                "3-745-950"};

        //Vector Validacion de voto
        boolean[] voto_estudiante = new boolean[39];
        Arrays.fill(voto_estudiante, false);

        //Boton de Login
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view){
                String estudiante_identidicado = String.valueOf(cedula.getText().toString());
                //validacion de Voto
                if (Arrays.asList(cedula_estudiante).contains(estudiante_identidicado)){
                    int i = Arrays.asList(cedula_estudiante).indexOf(estudiante_identidicado);
                    if (!voto_estudiante[i]){
                        Toast.makeText(getApplicationContext(),"Ya Puede Efectuar su Voto",  Toast.LENGTH_LONG).show();
                        voto_estudiante[i] = true;

                        //Se declara el intent que enviara la cedula del usuario a la siguiente pantalla
                        Intent intent = new Intent(getApplicationContext(), votacion.class);
                        intent.putExtra("cedula", estudiante_identidicado);
                        startActivity(intent);
                    } else {
                        Toast.makeText(getApplicationContext(),"Este Usuario ya realizo su voto",  Toast.LENGTH_LONG).show();
                    }
                } else {
                    Toast.makeText(getApplicationContext(),"Este Usuario No existe",  Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
