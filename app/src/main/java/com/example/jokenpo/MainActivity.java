package com.example.jokenpo;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import java.sql.SQLOutput;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void selecionadoPedra(View view) {
        this.opcaoSelecionada("Pedra");
    }

    public void selecionadoPapel(View view) {
        this.opcaoSelecionada("Papel");
    }

    public void selecionadoTesoura(View view) {
        this.opcaoSelecionada("Tesoura");
    }

    public void opcaoSelecionada(String opSelecionada) {

        ImageView imgResultado = findViewById(R.id.imgResultado);
        TextView txtResultado = findViewById(R.id.txtResultado);

        int numero = new Random().nextInt(3);
        String[] opcoes = {"Pedra", "Papel", "Tesoura"};
        String opApp = opcoes[numero];
        switch (opApp) {
            case "Pedra":
                imgResultado.setImageResource(R.drawable.pedra);
                break;
            case "Papel":
                imgResultado.setImageResource(R.drawable.papel);
                break;
            case "Tesoura":
                imgResultado.setImageResource(R.drawable.tesoura);
                break;

        }
        if ((opApp == "Papel" && opSelecionada == "Pedra") ||
                (opApp == "Tesoura" && opSelecionada == "Papel") ||
                (opApp == "Pedra" && opSelecionada == "Tesoura")
        ) {
            txtResultado.setText("Você Perdeu! :( ");

        } else if ((opSelecionada == "Papel" && opApp == "Pedra") ||
                (opSelecionada == "Tesoura" && opApp == "Papel") ||
                (opSelecionada == "Pedra" && opApp == "Tesoura")
        ) {
            txtResultado.setText("Você Ganhou! :D ");
        } else {
            txtResultado.setText("Empatou :/ ");
        }
    }
}