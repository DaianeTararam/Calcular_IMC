package com.example.calcularimc;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {
    private EditText etAltura;
    private EditText etPeso;
    private Button btnCalcular;
    private TextView tvResposta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        etAltura = findViewById(R.id.etAltura);
        etAltura.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        etPeso = findViewById(R.id.etPeso);
        etPeso.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        tvResposta = findViewById(R.id.tvResposta);
        tvResposta.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);

        btnCalcular = findViewById(R.id.btnCalcular);
        btnCalcular.setTextAlignment(View.TEXT_ALIGNMENT_CENTER);
        btnCalcular.setOnClickListener(op -> conferirIMC());
    }

    private void conferirIMC() {
        double etAltura = Double.parseDouble(this.etAltura.getText().toString());
        double etPeso = Double.parseDouble(this.etPeso.getText().toString());
        double imc = etPeso / (etAltura * etAltura);
        String resposta = "";
        if (imc < 18.5) {
            resposta = "Abaixo do peso e seu imc é: " + imc;
            tvResposta.setText(resposta);
        } else if (imc >= 18.5 && imc <= 24.9) {
            resposta = "Peso normal e seu imc é: " + imc;
            tvResposta.setText(resposta);
        } else if (imc >= 25 && imc <= 29.9) {
            resposta = "Sobrepeso e seu imc é: " + imc;
            tvResposta.setText(resposta);
        } else if (imc >= 30 && imc <= 34.9) {
            resposta = "Obesidade grau 1 e seu imc é: " + imc;
            tvResposta.setText(resposta);
        }else if (imc >= 35 && imc <= 39.9) {
            resposta = "Obesidade grau 2 e seu imc é: " + imc;
            tvResposta.setText(resposta);
        } else if (imc >= 40) {
            resposta = "Obesidade grau 3 e seu imc é: " + imc;
            tvResposta.setText(resposta);
        }
    }

}
