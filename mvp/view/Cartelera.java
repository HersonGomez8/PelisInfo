package com.hersongomez.pelisinfo.mvp.view;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import com.hersongomez.pelisinfo.R;
import com.hersongomez.pelisinfo.mvp.Interface.CarteleraView;
import com.hersongomez.pelisinfo.mvp.interactor.PeliculasResults;
import com.hersongomez.pelisinfo.mvp.presenter.PeliculasPresenter;

import java.util.ArrayList;

public class Cartelera extends AppCompatActivity implements CarteleraView{

    private PeliculasPresenter peliculasPresenter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cartelera);

        peliculasPresenter = new PeliculasPresenter(this);
        buscarDetallePeliculas();
    }

    @Override
    public void mostrarProgressBar() {

    }

    @Override
    public void ocultarProgressBar() {

    }

    @Override
    public void buscarDetallePeliculas() {
        peliculasPresenter.buscarDetallePeliculas();
    }

    @Override
    public void consultaFallida() {
        //Ocultar recycler
        //Mostrar Mensaje
    }

    @Override
    public void consultaExitosa(ArrayList<PeliculasResults> Peliculas) {
        //Ocultar Mensaje
        //Mostrar Recycler
    }
}