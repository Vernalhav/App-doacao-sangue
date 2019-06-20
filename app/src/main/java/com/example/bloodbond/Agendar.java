package com.example.bloodbond;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.CalendarView;
import android.widget.EditText;
import android.widget.Toast;

import java.util.Calendar;
import java.util.Date;

import static com.example.bloodbond.Instituicao.On;

public class Agendar extends AppCompatActivity {

    Pessoa doador;

    CalendarView calendario;
    Button agendar;
    EditText horario;
    EditText quantidade;

    Doacao doacao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_agendar);

        Bundle extra = getIntent().getExtras();
        doador = (Pessoa) extra.getSerializable("usuario");

        calendario = findViewById(R.id.calendario);
        agendar = findViewById(R.id.buttonAgendar);
        horario = findViewById(R.id.horario);
        quantidade = findViewById(R.id.qtd);

        final Calendar c = Calendar.getInstance();

        calendario.setOnDateChangeListener(new CalendarView.OnDateChangeListener() {
            @Override
            public void onSelectedDayChange(CalendarView view, int year, int month, int dayOfMonth) {
                c.set(year, month, dayOfMonth);
            }
        });

        agendar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String emailDoador = "testDonate@gmail.com";
                String emailInst = "testInst@gmail.com";

                doacao = new Doacao(
                        Double.parseDouble(quantidade.getText().toString()),
                        On, emailDoador, emailInst, new Date(c.getTimeInMillis())
                );
                doador.BookDonation(doacao);

                Log.d("DOACAO CRIADA: ", "onClick: " + doacao.getData().toString());
                System.out.println("DOACAO " + doacao.getData().toString());

                //historicoUsuario frag = new historicoUsuario();
                //frag.getAdapter().notifyDataSetChanged();

                finish();
            }
        });
    }
}
