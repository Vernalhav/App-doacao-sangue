package com.example.bloodbond;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

public class mainInstituicao  extends AppCompatActivity {

    private Instituicao instituicao;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_instituicao);

        Bundle extra = getIntent().getExtras();
        instituicao = (Instituicao) extra.getSerializable("login");

        Log.d("DEBUG: ", "onCreate: instituicao " + instituicao.getName());

        abasCadastro adapter = new abasCadastro(getSupportFragmentManager());
        adapter.adicionar( new perfilInstituicao() , "Perfil");
        adapter.adicionar( new estoqueInstituicao() , "Estoque");

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewer);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout2);
        tabLayout.setupWithViewPager(viewPager);


    }

    public Instituicao getInstituicao(){
        return instituicao;
    }

}
