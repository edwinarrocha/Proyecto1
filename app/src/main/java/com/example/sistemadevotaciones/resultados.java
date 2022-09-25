package com.example.sistemadevotaciones;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import org.eazegraph.lib.charts.PieChart;
import org.eazegraph.lib.models.PieModel;

public class resultados extends AppCompatActivity {

    TextView candidato1, candidato2, candidato3, votonulo;
    PieChart graficoPastel;
    Button volver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        candidato1 = (TextView) findViewById(R.id.tv_candidato1);
        candidato2 = (TextView) findViewById(R.id.tv_candidato2);
        candidato3 = (TextView) findViewById(R.id.tv_candidato3);
        votonulo = (TextView) findViewById(R.id.tv_nulos);

        graficoPastel = (PieChart) findViewById(R.id.graficoPie);

        //volver = (Button) findViewById(R.id.cmd_volver);

        Intent intent = getIntent();
        
        /*Integer cont_1 = votacion.candidato1_VivianValencuela;
        Integer cont_2 = votacion.candidato2_OmarAizpurua;
        Integer cont_3 =  votacion.candidato3_MartinCandenado;
        Integer cont_nulo = votacion.voto_Nulo;*/

        /*Integer acum_votos = cont_1 + cont_2 + cont_3 + cont_nulo;

        String cand_1 = String.valueOf(cont_1);
        String cand_2 = String.valueOf(cont_2);
        String cand_3 = String.valueOf(cont_3);
        String nulo = String.valueOf(cont_nulo);
        String votos_t = String.valueOf(acum_votos);*/

        /*candidato1.setText(cand_1);
        candidato2.setText(cand_2);
        candidato3.setText(cand_3);
        votonulo.setText(nulo);*/
        
        setData();

        /*volver.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent volver = new Intent(getApplicationContext(), MainActivity.class);
                startActivity(volver);
            }
        });*/

    }

    private void setData() {
        Integer cont_1 = votacion.candidato1_VivianValencuela;
        Integer cont_2 = votacion.candidato2_OmarAizpurua;
        Integer cont_3 =  votacion.candidato3_MartinCandenado;
        Integer cont_nulo = votacion.voto_Nulo;

        // Set the percentage of language used
        candidato1.setText(Integer.toString(cont_1));
        candidato2.setText(Integer.toString(cont_2));
        candidato3.setText(Integer.toString(cont_3));
        votonulo.setText(Integer.toString(cont_nulo));

        // Set the data and color to the pie chart
        graficoPastel.addPieSlice(new PieModel("Vivian Valenzuela", Integer.parseInt(candidato1.getText().toString()), Color.parseColor("#FFA726")));
        graficoPastel.addPieSlice(new PieModel("Omar Aizpurua", Integer.parseInt(candidato2.getText().toString()), Color.parseColor("#66BB6A")));
        graficoPastel.addPieSlice(new PieModel("Martin Candenado", Integer.parseInt(candidato3.getText().toString()), Color.parseColor("#EF5350")));
        graficoPastel.addPieSlice(new PieModel("Votos Nulos", Integer.parseInt(votonulo.getText().toString()), Color.parseColor("#29B6F6")));
        // To animate the pie chart
        graficoPastel.startAnimation();
    }
}