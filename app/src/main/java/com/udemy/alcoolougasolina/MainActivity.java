package com.udemy.alcoolougasolina;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.google.android.material.textfield.TextInputEditText;

public class MainActivity extends AppCompatActivity {

    private TextInputEditText editPrecoAlcool, editPrecoGasolina;
    private TextView textResultado;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        editPrecoAlcool = findViewById(R.id.editPrecoAlcool);
        editPrecoGasolina = findViewById(R.id.editPrecoGasolina);
        textResultado = findViewById(R.id.textResultado);
    }

    public void calcularPreco(View view) {

        //recuperar valores digitados
        String precoAlcool = editPrecoAlcool.getText().toString();
        String precoGasolina = editPrecoGasolina.getText().toString();

        //validar os campos digitados
        Boolean camposValidos = validarCampos(precoAlcool, precoGasolina);
        if (camposValidos) {

            //converter string para números
            Double valorAlcool = Double.parseDouble(precoAlcool);
            Double valorGasolina = Double.parseDouble(precoGasolina);
            Double resultado = valorAlcool / valorGasolina;
            if (resultado >= 0.7) {
                textResultado.setText("Melhor utilizar Gasolina");
            } else {
                textResultado.setText("Melhor utilizar Álcool");
            }
        } else {
            textResultado.setText("Preencha os preços priemeiro!!");
        }
    }

    public Boolean validarCampos(String pAlcool, String pGasolina) {

        Boolean camposValidos = true;
        if (pAlcool == null || pAlcool.equals("")) {
            camposValidos = false;
        } else if (pGasolina == null || pGasolina.equals("")) {
            camposValidos = false;
        }
        return camposValidos;
    }
}



