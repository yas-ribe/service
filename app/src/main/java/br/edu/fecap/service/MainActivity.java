package br.edu.fecap.service;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }
    // Método chamado quando o botão "Financeiro" é clicado
    public void abrirFinanceiro(View view) {
        Intent intent = new Intent(this, FinanceiroActivity.class);
        startActivity(intent);
    }
    public void abrirEducacao(View view) {
        Intent intent = new Intent(this, EducacaoActivity.class);
        startActivity(intent);
    }
    public void abrirSaude(View view) {
        Intent intent = new Intent(this, SaudeActivity.class);
        startActivity(intent);
    }
    public void abrirInformacoes(View view) {
        Intent intent = new Intent(this, InformacoesActivity.class);
        startActivity(intent);
    }
}