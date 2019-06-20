package com.example.bloodbond;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;


public class perfilUsuario extends Fragment {

    private Pessoa pes;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mainUsuario activity = (mainUsuario) getActivity();
        pes = activity.getUsuario();

        View view = inflater.inflate(R.layout.activity_perfil_usuario, container, false);

        TextView nome = (TextView) view.findViewById(R.id.nome);
        TextView peso = (TextView) view.findViewById(R.id.peso);
        TextView altura = (TextView) view.findViewById(R.id.altura);
        TextView  tipo = (TextView) view.findViewById(R.id.tipo);
        TextView qtd = (TextView) view.findViewById(R.id. qtd);
        Button doar = (Button) view.findViewById(R.id.doar);

        doar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                    agendar();
            }
        });

        nome.setText(pes.getName());
        peso.setText( Double.toString(pes.getPeso()));
        altura.setText( Double.toString(pes.getAltura()));
        tipo.setText(pes.getTipoSanguineoString());
        return view;
    }

    public void agendar(){
        Intent intent = new Intent(this.getActivity(), Agendar.class);
        startActivity(intent);
    }
    //TODO setar os textview com os dados dos usuarios
}
