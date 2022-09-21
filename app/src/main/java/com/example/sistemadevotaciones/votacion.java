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


    //contadores de votacion
    int candidato1_VivianValencuela = 0, candidato2_OmarAizpurua = 0, candidato3_MartinCandenado = 0, voto_Nulo =0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_votacion);


        //Vector Validacion de voto
        boolean[] validacion_voto = new boolean[39];
        Arrays.fill(validacion_voto, false);

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

                int eleccion_voto =papeleta_voto.getCheckedRadioButtonId();

                validacion_voto[i] = true;

                if (eleccion_voto == R.id.chk_candidato1){
                    candidato1_VivianValencuela++;

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("validacion", validacion_voto[i]);
                    intent.putExtra("inice_validacion", i);
                    startActivity(intent);

                } else if (eleccion_voto == R.id.chk_candidato2){
                    candidato2_OmarAizpurua++;

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("validacion", validacion_voto[i]);
                    intent.putExtra("inice_validacion", i);
                    startActivity(intent);
                }else if (eleccion_voto == R.id.chk_candidato3){
                    candidato3_MartinCandenado++;

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("validacion", validacion_voto[i]);
                    intent.putExtra("inice_validacion", i);
                    startActivity(intent);
                } else{
                    voto_Nulo++;

                    Intent intent = new Intent(getApplicationContext(), MainActivity.class);
                    intent.putExtra("validacion", validacion_voto[i]);
                    intent.putExtra("inice_validacion", i);
                    startActivity(intent);
                }
            }
        });
    }
}