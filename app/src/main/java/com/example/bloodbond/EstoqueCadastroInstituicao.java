package com.example.bloodbond;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class EstoqueCadastroInstituicao extends AppCompatActivity {

    private Instituicao instituicao;
    private EditText qtAp;
    private EditText qtAn;
    private EditText qtBp;
    private EditText qtBn;
    private EditText qtABp;
    private EditText qtABn;
    private EditText qtOp;
    private EditText qtOn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_cadastro_estoque);

        Bundle extra = getIntent().getExtras();
        instituicao = (Instituicao) extra.getSerializable("instituicao");

        qtAp = findViewById(R.id.Ap);
        qtAn = findViewById(R.id.An);
        qtBp = findViewById(R.id.Bp);
        qtBn = findViewById(R.id.Bn);
        qtABp = findViewById(R.id.ABp);
        qtABn = findViewById(R.id.ABn);
        qtOp = findViewById(R.id.Op);
        qtOn = findViewById(R.id.On);

        Button btn = findViewById(R.id.botaoCadastro);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                atualizaEstoque();
                cadastraInstituicao();
            }
        });
    }

    /**
     * Atualiza a instituicao
     * com os dados inseridos
     * nos EditTexts, finalizando
     * a construção da classe
     */
    public void atualizaEstoque(){
        // TODO: Verificar valores invalidos nos editTexts (não vai dar tempo)
        instituicao.insereQtSangue(
                Double.parseDouble(qtAp.getText().toString()), Double.parseDouble(qtAn.getText().toString()),
                Double.parseDouble(qtBp.getText().toString()), Double.parseDouble(qtBn.getText().toString()),
                Double.parseDouble(qtABp.getText().toString()),Double.parseDouble(qtABn.getText().toString()),
                Double.parseDouble(qtOp.getText().toString()), Double.parseDouble(qtOn.getText().toString()));
    }

    public void cadastraInstituicao(){

        DatabaseManager.getInstance().RegisterInstitution(instituicao);

    }
}
