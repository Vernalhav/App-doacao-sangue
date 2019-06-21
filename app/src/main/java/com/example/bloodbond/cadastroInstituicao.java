package com.example.bloodbond;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

public class cadastroInstituicao extends Fragment {

    private Instituicao instituicao;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_cadastro_instituicao, container, false);

        TextView tv = view.findViewById(R.id.name);

        final EditText nome = view.findViewById(R.id.name);
        final EditText senha = view.findViewById(R.id.senha);
        final EditText email = view.findViewById(R.id.email);
        final EditText endereco = view.findViewById(R.id.endereco);

        Button btnCadastroUsuario = (Button)view.findViewById(R.id.button2);
        btnCadastroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                if (email.getText().toString().length() == 0 ||
                        senha.getText().toString().length() == 0  ||
                        nome.getText().toString().length() == 0 ||
                        endereco.getText().toString().length() == 0) {

                    Toast toast = Toast.makeText(getContext(), "Preencha todos os campos", Toast.LENGTH_SHORT);
                    toast.show();
                    return;
                } else {
                    instituicao = new Instituicao(email.getText().toString(), senha.getText().toString(),
                                                nome.getText().toString(), endereco.getText().toString(),
                                                0, 0, 0, 0, 0, 0, 0, 0);
                    cadastroEstoque();
                }
            }
        });

        return view;
    }
    void cadastroEstoque(){
        Intent intent = new Intent(this.getActivity(), EstoqueCadastroInstituicao.class);
        intent.putExtra("instituicao", instituicao);
        startActivity(intent);
    }
}
