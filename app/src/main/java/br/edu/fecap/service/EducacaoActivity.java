package br.edu.fecap.service;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class EducacaoActivity extends AppCompatActivity {

    private EditText notaNIInput;
    private EditText notaPIInput;
    private EditText notaPOInput;
    private TextView resultadoNotas;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_educacao);

        notaNIInput = findViewById(R.id.editTextNI);
        notaPIInput = findViewById(R.id.editTextPI);
        notaPOInput = findViewById(R.id.editTextPO);
        resultadoNotas = findViewById(R.id.ResultadoNotas);

        Button calcularNotaBtn = findViewById(R.id.btnCalcularNota);
        calcularNotaBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double notaNI = Double.parseDouble(notaNIInput.getText().toString());
                double notaPI = Double.parseDouble(notaPIInput.getText().toString());
                double notaPO = Double.parseDouble(notaPOInput.getText().toString());

                double notaFinal = notaNI * 0.2 + notaPI * 0.3 + notaPO * 0.5;
                String status;

                if (notaFinal >= 6) {
                    status = "Aprovado";
                } else if (notaFinal < 6) {
                    status = "Reprovado";
                } else {
                    status = "Recuperação";
                }

                resultadoNotas.setText("Nota Final: " + notaFinal + ", Status: " + status);
            }
        });

        Button sairBtn = findViewById(R.id.ButtonSair);

        sairBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

        Button limparBtn = findViewById(R.id.buttonLimpar);
        limparBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                notaNIInput.setText("");
                notaPIInput.setText("");
                notaPOInput.setText("");
                resultadoNotas.setText("");
            }
        });
    }
}

