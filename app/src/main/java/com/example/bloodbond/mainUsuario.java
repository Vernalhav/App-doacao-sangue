package com.example.bloodbond;

import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;

public class mainUsuario   extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_usuario);

        abasCadastro adapter = new abasCadastro(getSupportFragmentManager());
        adapter.adicionar( new perfilUsuario() , "Perfil");
        adapter.adicionar( new historicoUsuario()  , "Histórico");
        adapter.adicionar( new doacoesUsuario()  , "Notificações");

        ViewPager viewPager = (ViewPager) findViewById(R.id.viewer);
        viewPager.setAdapter(adapter);

        TabLayout tabLayout = (TabLayout) findViewById(R.id.tabLayout3);
        tabLayout.setupWithViewPager(viewPager);
    }
}
