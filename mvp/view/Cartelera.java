package com.hersongomez.pelisinfo.mvp.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.hersongomez.pelisinfo.R;
import com.hersongomez.pelisinfo.mvp.Interface.CarteleraView;
import com.hersongomez.pelisinfo.mvp.adapter.RecyclerAdapter;
import com.hersongomez.pelisinfo.mvp.interactor.PeliculasResults;
import com.hersongomez.pelisinfo.mvp.presenter.PeliculasPresenter;

import java.util.ArrayList;

public class Cartelera extends AppCompatActivity implements CarteleraView{

    private PeliculasPresenter peliculasPresenter;
    private TextView titulo;
    private RecyclerView mRecyclerPopulares;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cartelera);

        titulo = findViewById(R.id.titulo);
        mRecyclerPopulares = findViewById(R.id.RecyclerPopulares);

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
    public void mostrarRecyclerPeliculas() {

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
    public void consultaExitosa(ArrayList<PeliculasResults> peliculas) {
        //Mostrar Titulo
        //Ocultar Mensaje

        //Propiedades recycler
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        DividerItemDecoration itemDecoration2 = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0xfda947, 0xfda947});
        drawable.setSize(5,5);
        itemDecoration.setDrawable(drawable);
        itemDecoration2.setDrawable(drawable);
        mRecyclerPopulares.addItemDecoration(itemDecoration);
        mRecyclerPopulares.addItemDecoration(itemDecoration2);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        mRecyclerPopulares.setLayoutManager(staggeredGridLayoutManager);
        //Mostrar Recycler
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(peliculas,this);
        mRecyclerPopulares.setAdapter(recyclerAdapter);
    }
}