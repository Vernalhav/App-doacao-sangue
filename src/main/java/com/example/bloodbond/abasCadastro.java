package com.example.bloodbond;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;

import java.util.ArrayList;
import java.util.List;
import java.util.Set;

public class abasCadastro extends FragmentPagerAdapter {

    private List<Fragment> fragments = new ArrayList<>();
    private List<String> titulos = new ArrayList<>();

    public abasCadastro(FragmentManager fm) {
        super(fm);
    }

    public void adicionar(Fragment fragment, String tituloAba){
        this.fragments.add(fragment);
        this.titulos.add(tituloAba);
    }

    @Override
    public Fragment getItem(int position) {
        return this.fragments.get(position);
    }

    @Override
    public int getCount() {
        return this.fragments.size();
    }

    @Override
    public CharSequence getPageTitle(int position){
        return this.titulos.get(position);
    }
}