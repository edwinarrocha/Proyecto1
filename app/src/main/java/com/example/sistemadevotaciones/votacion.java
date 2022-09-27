package com.example.sistemadevotaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

import java.util.Arrays;

public class votacion extends AppCompatActivity {

    private RadioGroup papeleta_voto;
    private TextView cedula_estudiante;
    private Button voto;


    //contadores de votacion estaticos para mantener la integridad de los valores cargados
    static int candidato1_VivianValencuela, candidato2_OmarAizpurua, candidato3_MartinCandenado, voto_Nulo, total_votos;
    static float porc_cand1, porc_cand2, porc_cand3, porc_votonulo;
    //Arreglo Booleano de validacion de votso estaticos para mantener la integridad de los valores
    static boolean[] validacion_voto = new boolean[39];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votacion);

        //variables para los elementos graficos
        cedula_estudiante = (TextView) findViewById(R.id.lbl_votante);
        papeleta_voto = (RadioGroup) findViewById(R.id.rbg_papeleta);
        voto = (Button) findViewById(R.id.cmd_confirmarVoto);


        //Traer el indice de los arreglos cedua_estudiante y voto_estudiante
        Intent intent = getIntent();
        Integer i = intent.getIntExtra("indice", 0);
        String votante = intent.getStringExtra("cedula");

        // Muestra la cedula_estudiante en Pantalla
        cedula_estudiante.setText(votante);

        // Manejo de Votaciones por RadioGroup
        papeleta_voto.clearCheck();
        papeleta_voto.setOnCheckedChangeListener(new RadioGroup.OnCheckedChangeListener() {
            @Override

            //Funcion para capturar el indice de los RadioButton
            public void onCheckedChanged(RadioGroup grupo, int id) {
                RadioButton radioButton = (RadioButton)grupo.findViewById(id);
            }
        });

        //Metodo para el button que valida el voto
        voto.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {

                //Variable entera para capturar los indices de los radio buttons
                int eleccion_voto =papeleta_voto.getCheckedRadioButtonId();

                // se asigna al espacion en el Arrays en esa posicion de true (Estos permite que se valide si el usuario puede votar o no)
                validacion_voto[i] = true;

                if (eleccion_voto == R.id.chk_candidato1){
                    // variable contadora de votos al candidato1_VivianValencuela
                    candidato1_VivianValencuela++;

                    //intent de validacion del voto
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("validacion", validacion_voto[i]);
                    intent.putExtra("inice_validacion", i);
                    intent.putExtra("cont_candidato1", candidato1_VivianValencuela);

                    startActivity(intent);

                } else if (eleccion_voto == R.id.chk_candidato2){
                    // variable contadora de votos al candidato2_OmarAizpurua
                    candidato2_OmarAizpurua++;

                    // Intent de Validacion del Voto
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("validacion", validacion_voto[i]);
                    intent.putExtra("inice_validacion", i);
                    intent.putExtra("cont_candidato2", candidato2_OmarAizpurua);

                    startActivity(intent);

                }else if (eleccion_voto == R.id.chk_candidato3){
                    // variable contadora de votos al candidato3_MartinCandenado
                    candidato3_MartinCandenado++;

                    //Intent de Validacion del Voto
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("validacion", validacion_voto[i]);
                    intent.putExtra("inice_validacion", i);
                    intent.putExtra("cont_candidato3", candidato3_MartinCandenado);

                    startActivity(intent);

                } else{
                    // Variable contadora de votos nulos
                    voto_Nulo++;

                    // Intent de Validacion del Voto
                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("validacion", validacion_voto[i]);
                    intent.putExtra("inice_validacion", i);
                    intent.putExtra("cont_nulo", voto_Nulo);

                    startActivity(intent);
                }

                //
                total_votos = candidato1_VivianValencuela + candidato2_OmarAizpurua + candidato3_MartinCandenado + voto_Nulo;
                porc_cand1 = (candidato1_VivianValencuela*100)/total_votos;
                porc_cand2 = (candidato2_OmarAizpurua*100)/total_votos;
                porc_cand3 = (candidato3_MartinCandenado*100)/total_votos;
                porc_votonulo = (voto_Nulo*100)/total_votos;
            }

        });
    }
}