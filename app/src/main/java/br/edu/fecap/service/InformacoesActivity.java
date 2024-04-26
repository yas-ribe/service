package br.edu.fecap.service;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;



public class InformacoesActivity extends AppCompatActivity {

    private TextView nomeInput;
    private TextView idadeInput;
    private TextView matriculaInput;
    private TextView cursoInput;


    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_informacoes);

        nomeInput = findViewById(R.id.editTextNome);
        idadeInput = findViewById(R.id.TextIdade);
        matriculaInput = findViewById(R.id.editTextMatricula);
        cursoInput = findViewById(R.id.editTextCurso);

        // Pré-definir as informações do aluno
        nomeInput.setText("Yasmin");
        idadeInput.setText("20");
        matriculaInput.setText("23024985");
        cursoInput.setText("Ciência da Computação");



        Button sairBtn = findViewById(R.id.buttonSair);
        sairBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });
    }
}
