package com.example.sistemadevotaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class resultados extends AppCompatActivity {

    TextView candidato1, candidato2, candidato3, votonulo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        candidato1 = (TextView) findViewById(R.id.candidato1);
        candidato2 = (TextView) findViewById(R.id.candidato2);
        candidato3 = (TextView) findViewById(R.id.candidato3);
        votonulo = (TextView) findViewById(R.id.votonulo);

        Intent intent = getIntent();

        Integer cont_1 = getIntent().getIntExtra("cont_candidato1", 0);
        Integer cont_2 = getIntent().getIntExtra("cont_candidato2", 0);
        Integer cont_3 = getIntent().getIntExtra("cont_candidato3", 0);
        Integer cont_nulo = getIntent().getIntExtra("cont_nulo", 0);

        String cand_1 = String.valueOf(cont_1);
        String cand_2 = String.valueOf(cont_2);
        String cand_3 = String.valueOf(cont_3);
        String nulo = String.valueOf(cont_nulo);

        candidato1.setText(cand_1);
        candidato2.setText(cand_2);
        candidato3.setText(cand_3);
        votonulo.setText(nulo);
    }
}