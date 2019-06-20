package com.example.bloodbond;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class estoqueInstituicao  extends Fragment {
    private Instituicao inst;

    ProgressBar amais,amenos,bmais,bmenos,abmais,abmenos,omais,omenos;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {

        mainInstituicao activity = (mainInstituicao)getActivity();
        inst = activity.getInstituicao();

        View view = inflater.inflate(R.layout.acitivity_estoque_instituicao, container, false);


        return view;
    }
}
