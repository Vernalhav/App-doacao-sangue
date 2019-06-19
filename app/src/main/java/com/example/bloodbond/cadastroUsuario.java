package com.example.bloodbond;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class cadastroUsuario extends Fragment {

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.activity_cadastro_usuario, container, false);

        TextView tv = view.findViewById(R.id.editText);
        //tv.setText("CADASTRO USUARIO");

        Button btnCadastroUsuario = (Button)view.findViewById(R.id.button3);
        btnCadastroUsuario.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // TODO: Criar uma instancia da classe pessoa com os dados do novo usuario.
                 Pessoa pessoa = new Pessoa("test2@hotmal.com", "2444666666", "test2", 2, 65, 232, 22);

                // TODO: Descomentar função.
                DatabaseManager.getInstance().RegisterUser(pessoa);

            }
        });

        
        Spinner spinner = view.findViewById(R.id.spinner);

        ArrayAdapter<CharSequence> adapter = (ArrayAdapter<CharSequence>) ArrayAdapter.createFromResource(this.getContext(), R.array.blood_array, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);

        return view;
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String text = parent.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }
}
