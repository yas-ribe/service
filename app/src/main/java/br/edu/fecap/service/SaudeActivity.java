package br.edu.fecap.service;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class SaudeActivity extends AppCompatActivity {

    private EditText editTextPeso, editTextAltura;
    private TextView textViewResultado;
    private Button btnResultado, btnLimpar, btnSair;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saude);

        editTextPeso = findViewById(R.id.editTextPeso);
        editTextAltura = findViewById(R.id.editTextAltura);
        textViewResultado = findViewById(R.id.textViewResultado);
        btnResultado = findViewById(R.id.btnResultado);
        btnLimpar = findViewById(R.id.btnLimpar);
        btnSair = findViewById(R.id.btnSair);

        btnResultado.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularResultado();
            }
        });

        btnLimpar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                limparResultado();
            }
        });

        btnSair.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();;
            }
        });
    }

    private void calcularResultado() {
        double peso = Double.parseDouble(editTextPeso.getText().toString());
        double altura = Double.parseDouble(editTextAltura.getText().toString());
        double imc = calcularIMC(peso, altura);

        textViewResultado.setText(String.format("Peso: %.2f kg\nAltura: %.2f m\nIMC: %.2f (%s)", peso, altura, imc, classificarIMC(imc)));
    }

    private void limparResultado() {
        editTextPeso.setText("");
        editTextAltura.setText("");
        textViewResultado.setText("");
    }

    private double calcularIMC(double peso, double altura) {
        return peso / (altura * altura);
    }

    private String classificarIMC(double imc) {
        if (imc < 18.5) {
            return "Abaixo do peso";
        } else if (imc < 25) {
            return "Peso normal";
        } else if (imc < 30) {
            return "Sobrepeso";
        } else {
            return "Obesidade";
        }
    }
}
