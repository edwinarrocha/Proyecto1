package com.example.sistemadevotaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class resultados extends AppCompatActivity {

    TextView candidato1, candidato2, candidato3, votonulo, votos_totales;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        candidato1 = (TextView) findViewById(R.id.candidato1);
        candidato2 = (TextView) findViewById(R.id.candidato2);
        candidato3 = (TextView) findViewById(R.id.candidato3);
        votonulo = (TextView) findViewById(R.id.votonulo);
        votos_totales = (TextView) findViewById(R.id.txt_votosTotales);


        Intent intent = getIntent();

        // Intent no funcional para traer los contadores
        /*Integer cont_1 = getIntent().getIntExtra("cont_candidato1", 0);
        Integer cont_2 = getIntent().getIntExtra("cont_candidato2", 0);
        Integer cont_3 = getIntent().getIntExtra("cont_candidato3", 0);
        Integer cont_nulo = getIntent().getIntExtra("cont_nulo", 0);*/

        Integer cont_1 = votacion.candidato1_VivianValencuela;
        Integer cont_2 = votacion.candidato2_OmarAizpurua;
        Integer cont_3 =  votacion.candidato3_MartinCandenado;
        Integer cont_nulo = votacion.voto_Nulo;

        Integer acum_votos = cont_1 + cont_2 + cont_3 + cont_nulo;

        String cand_1 = String.valueOf(cont_1);
        String cand_2 = String.valueOf(cont_2);
        String cand_3 = String.valueOf(cont_3);
        String nulo = String.valueOf(cont_nulo);
        String votos_t = String.valueOf(acum_votos);

        candidato1.setText(cand_1);
        candidato2.setText(cand_2);
        candidato3.setText(cand_3);
        votonulo.setText(nulo);
        votos_totales.setText(votos_t);
    }
}