package com.example.etanolgas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private ViewHolder vh = new ViewHolder();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.vh.etEtanol = findViewById(R.id.etPrecoEtanol);
        this.vh.etGasolina = findViewById(R.id.etPrecoGaso);
        this.vh.tvResult = findViewById(R.id.tvResultado);
        this.vh.btnCalc = findViewById(R.id.btnCalcular);

        //implementa  onClickListener
        this.vh.btnCalc.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        if (v.getId() == R.id.btnCalcular){
            String valorEtanol = this.vh.etEtanol.getText().toString();
            String valorGasolina = this.vh.etGasolina.getText().toString();

            //Validar espaço em branco
            if ("".equals(valorEtanol) && "".equals(valorGasolina)){
                //Mostra mensagem
                Toast.makeText(this, this.getString(R.string.informeValor), Toast.LENGTH_LONG).show();

            }else {
                //converção para double e calculo para saber qual combustivel compensa

                Double realEtanol = Double.valueOf(valorEtanol);
                Double realGasolina = Double.valueOf(valorGasolina);

                //validação melhor escolha
                if(realEtanol/realGasolina  >= 0.7 ){
                    this.vh.tvResult.setText("Recomendado abastecer com GASOLINA!");

                }else{
                    this.vh.tvResult.setText("Recomendado abastecer com ETANOL!");
                }
            }
        }
    }

    private static class ViewHolder{
        EditText etEtanol;
        EditText etGasolina;
        TextView tvResult;
        Button  btnCalc;
    }
}
