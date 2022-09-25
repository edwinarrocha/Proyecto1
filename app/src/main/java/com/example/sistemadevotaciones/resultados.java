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

    //Se declaran las variables para los textview de la tabla de conteo
    TextView candidato1, candidato2, candidato3, votonulo,totalVoto;

    //Se declara la variable que Manejara el grafico
    PieChart graficoPastel;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_resultados);

        //variables para los elementos graficos
        candidato1 = (TextView) findViewById(R.id.tv_candidato1);
        candidato2 = (TextView) findViewById(R.id.tv_candidato2);
        candidato3 = (TextView) findViewById(R.id.tv_candidato3);
        votonulo = (TextView) findViewById(R.id.tv_nulos);
        totalVoto = (TextView) findViewById(R.id.tv_total);

        graficoPastel = (PieChart) findViewById(R.id.graficoPie);

        // Se declara un Intent para recibir el boton resutados de la clase MainActivity.java
        Intent intent = getIntent();

        //Se invoca la funcion encargada de mostar los dato en la grafica
        setData();
    }

    // Funcion para la asignacion de los datos de la tabla
    private void setData() {
        // Se trae por referencia de la clase votacion.java los contadores
        Integer cont_1 = votacion.candidato1_VivianValencuela;
        Integer cont_2 = votacion.candidato2_OmarAizpurua;
        Integer cont_3 =  votacion.candidato3_MartinCandenado;
        Integer cont_nulo = votacion.voto_Nulo;
        Integer acum_total = votacion.total_votos;

        // Se asignan a los TextView los votos acumulados por los contadores
        candidato1.setText(Integer.toString(cont_1));
        candidato2.setText(Integer.toString(cont_2));
        candidato3.setText(Integer.toString(cont_3));
        votonulo.setText(Integer.toString(cont_nulo));
        totalVoto.setText(Integer.toString(acum_total));

        // Se asigna los Datos de los contadores y los colores del grafico
        graficoPastel.addPieSlice(new PieModel("Vivian Valenzuela", Integer.parseInt(candidato1.getText().toString()), Color.parseColor("#FFA726")));
        graficoPastel.addPieSlice(new PieModel("Omar Aizpurua", Integer.parseInt(candidato2.getText().toString()), Color.parseColor("#66BB6A")));
        graficoPastel.addPieSlice(new PieModel("Martin Candenado", Integer.parseInt(candidato3.getText().toString()), Color.parseColor("#EF5350")));
        graficoPastel.addPieSlice(new PieModel("Votos Nulos", Integer.parseInt(votonulo.getText().toString()), Color.parseColor("#29B6F6")));

        //Da inicio a la animacion del graficoPastel
        graficoPastel.startAnimation();
    }
}