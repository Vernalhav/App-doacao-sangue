package com.example.bloodbond;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;

public class cadastroUsuario extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        final View view = inflater.inflate(R.layout.activity_cadastro_usuario, container, false);

        final EditText nome = view.findViewById(R.id.name);
        final EditText senha = view.findViewById(R.id.senha);
        final EditText idade = view.findViewById(R.id.idade);
        final EditText peso = view.findViewById(R.id.peso);
        final EditText email = view.findViewById(R.id.email);
        final EditText altura = view.findViewById(R.id.altura);
        final Spinner spinner = view.findViewById(R.id.spinner);

        Button btnCadastroUsuario = (Button)view.findViewById(R.id.button3);
        btnCadastroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                int tipoSanguineo = determinaSangue(spinner.getSelectedItem().toString());
                 Pessoa pessoa = new Pessoa(email.getText().toString(), senha.getText().toString(), nome.getText().toString(), tipoSanguineo,
                         Double.parseDouble(peso.getText().toString()), Double.parseDouble(altura.getText().toString()), Integer.parseInt(idade.getText().toString()));

                DatabaseManager.getInstance().RegisterUser(pessoa);

            }
        });

        ArrayAdapter<CharSequence> adapter = (ArrayAdapter<CharSequence>) ArrayAdapter.createFromResource(this.getContext(), R.array.blood_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return view;
    }

    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    public void onNothingSelected(AdapterView<?> parent) {

    }

    public int determinaSangue(String s){
        String[] tipos = new String[] {"A+", "A-", "B+", "B-", "AB+", "AB-", "O+", "0-"};
        for (int i = 0; i < 8; i++){
            if (s.equals(tipos[i])) return i;
        }
        return -1;
    }
}
