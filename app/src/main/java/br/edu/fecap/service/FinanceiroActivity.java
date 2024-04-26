package br.edu.fecap.service;

import android.annotation.SuppressLint;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.TextView;


public class FinanceiroActivity extends AppCompatActivity {

    private EditText editTextSalario;
    private TextView textViewSalarioBruto, textViewINSS, textViewFGTS, textViewSalarioLiquido;
    private RadioButton radioButtonGeral, radioButtonDomestico, radioButtonAprendiz;
    private Button buttonCalcular, btnLimpa, btnEncerrar;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_financeiro);

        editTextSalario = findViewById(R.id.editTextSalario);
        textViewSalarioBruto = findViewById(R.id.textViewSalarioBruto);
        textViewINSS = findViewById(R.id.textViewINSS);
        textViewFGTS = findViewById(R.id.textViewFGTS);
        textViewSalarioLiquido = findViewById(R.id.textViewSalarioLiquido);
        radioButtonGeral = findViewById(R.id.radioButtonGeral);
        radioButtonDomestico = findViewById(R.id.radioButtonDomestico);
        radioButtonAprendiz = findViewById(R.id.radioButtonAprendiz);
        buttonCalcular = findViewById(R.id.buttonCalcular);
        btnLimpa = findViewById(R.id.btnLimpa);
        btnEncerrar = findViewById(R.id.btnEncerrar);

        buttonCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                double salarioBruto = Double.parseDouble(editTextSalario.getText().toString());
                double descontoINSS = calcularINSS(salarioBruto);
                double descontoFGTS = calcularFGTS(salarioBruto);
                double salarioLiquido = salarioBruto - descontoINSS - descontoFGTS;

                textViewSalarioBruto.setText(String.valueOf(salarioBruto));
                textViewINSS.setText(String.valueOf(descontoINSS));
                textViewFGTS.setText(String.valueOf(descontoFGTS));
                textViewSalarioLiquido.setText(String.valueOf(salarioLiquido));
            }
        });

        btnLimpa.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                editTextSalario.setText("");
                textViewSalarioBruto.setText("Salário Bruto: ");
                textViewINSS.setText("Desconto INSS: ");
                textViewFGTS.setText("Desconto FGTS: ");
                textViewSalarioLiquido.setText("Salário Líquido: ");
            }
        });

        btnEncerrar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }

    private double calcularINSS(double salarioBruto) {
        double aliquotaFGTS;

        if (salarioBruto <= 1412.00) {
            aliquotaFGTS = 0.075; // 7.5% para salários até R$ 1.412,00
        } else if (salarioBruto <= 2666.68) {
            aliquotaFGTS = 0.09; // 9.0% para salários de R$ 1.412,01 a R$ 2.666,68
        } else if (salarioBruto <= 4000.03) {
            aliquotaFGTS = 0.12; // 12.0% para salários de R$ 2.666,69 até R$ 4.000,03
        } else if (salarioBruto <= 7786.02) {
            aliquotaFGTS = 0.14; // 14.0% para salários de R$ 4.000,04 até R$ 7.786,02
        } else {
            aliquotaFGTS = 0; // valor padrão caso o salário seja maior que R$ 7.786,02
        }
        return salarioBruto * aliquotaFGTS;
    }

    private double calcularFGTS(double salarioBruto) {
        double aliquotaFGTS;

        if (radioButtonGeral.isChecked()) {
            aliquotaFGTS = 0.08; // 8% para trabalhadores em geral
        } else if (radioButtonDomestico.isChecked()) {
            aliquotaFGTS = 0.08 + 0.032; // 8% para FGTS regular e 3.2% para antecipação do recolhimento rescisório
        } else if (radioButtonAprendiz.isChecked()) {
            aliquotaFGTS = 0.02; // 2% para jovem aprendiz
        } else {
            aliquotaFGTS = 0; // valor padrão caso nenhuma opção seja selecionada
        }

        return salarioBruto * aliquotaFGTS;
    }

}
