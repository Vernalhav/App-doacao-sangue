package com.example.bloodbond;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

import static com.example.bloodbond.Instituicao.ABn;
import static com.example.bloodbond.Instituicao.ABp;
import static com.example.bloodbond.Instituicao.An;
import static com.example.bloodbond.Instituicao.Ap;
import static com.example.bloodbond.Instituicao.Bn;
import static com.example.bloodbond.Instituicao.Bp;
import static com.example.bloodbond.Instituicao.On;
import static com.example.bloodbond.Instituicao.Op;

public class estoqueInstituicao  extends Fragment {
    private Instituicao inst;

    ProgressBar amais,amenos,bmais,bmenos,abmais,abmenos,omais,omenos;
    TextView ap, an, bp, bn, abp, abn, op, on;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        mainInstituicao activity = (mainInstituicao)getActivity();
        inst = activity.getInstituicao();

        View view = inflater.inflate(R.layout.acitivity_estoque_instituicao, container, false);

        ap = (TextView) view.findViewById(R.id.apos);
        an = (TextView) view.findViewById(R.id.aneg);
        bp = (TextView) view.findViewById(R.id.bpos);
        bn = (TextView) view.findViewById(R.id.bneg);
        op = (TextView) view.findViewById(R.id.omais);
        on = (TextView) view.findViewById(R.id.omenos);
        abp = (TextView) view.findViewById(R.id.abmais);
        abn = (TextView) view.findViewById(R.id.abmenos);

        amais = (ProgressBar) view.findViewById(R.id.progressBarApos);
        amenos = (ProgressBar) view.findViewById(R.id.progressBarAneg);
        bmais = (ProgressBar) view.findViewById(R.id.progressBarBpos);
        bmenos = (ProgressBar) view.findViewById(R.id.progressBarBneg);
        omais = (ProgressBar) view.findViewById(R.id.progressBarOpos);
        omenos = (ProgressBar) view.findViewById(R.id.progressBarOneg);
        abmais = (ProgressBar) view.findViewById(R.id.progressBarABpos);
        abmenos = (ProgressBar) view.findViewById(R.id.progressBarABneg);

        amais.setProgress((int)inst.getQtSangue(Ap));
        amenos.setProgress((int)inst.getQtSangue(An));
        bmais.setProgress((int)inst.getQtSangue(Bp));
        bmenos.setProgress((int)inst.getQtSangue(Bn));
        abmais.setProgress((int)inst.getQtSangue(ABp));
        abmenos.setProgress((int)inst.getQtSangue(ABn));
        omais.setProgress((int)inst.getQtSangue(Op));
        omenos.setProgress((int)inst.getQtSangue(On));

        ap.setText(amais.getProgress()+"");
        an.setText(amenos.getProgress()+"");
        bp.setText(bmais.getProgress()+"");
        bn.setText(bmenos.getProgress()+"");
        op.setText(omais.getProgress()+"");
        on.setText(omenos.getProgress()+"");
        abp.setText(abmais.getProgress()+"");
        abn.setText(abmenos.getProgress()+"");

        return view;
    }
}
