package br.com.michel.android.calculadoradegorjeta;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.SeekBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText valor, gorjetat, total;
    private SeekBar progresso;
    private TextView porcentagem;
    private double porcentagemm = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        valor = findViewById(R.id.editText2);
        gorjetat = findViewById(R.id.editTextGorjeta);
        total = findViewById(R.id.editTexttotal);
        progresso = findViewById(R.id.seekBar);
        porcentagem = findViewById(R.id.textView3);


        progresso.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {

            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {

                porcentagemm = progress;
                porcentagem.setText(Math.round(porcentagemm )+ "%");
                calcularGorjeta();

            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });

    }

    public void calcularGorjeta(){

        String conta = valor.getText().toString();
        if (conta == null || conta.equals("")){

            Toast.makeText(getApplicationContext(), "Digite um valor", Toast.LENGTH_SHORT).show();
        }
        else {

            double valordigitado = Double.parseDouble(conta);

            double gorjeta = valordigitado * (porcentagemm / 100);
            gorjetat.setText("R$ " + Math.round(gorjeta));
            double cc = gorjeta + valordigitado;
            total.setText("R$ " + cc);


        }


    }
}
