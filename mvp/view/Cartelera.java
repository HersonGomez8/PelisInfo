package com.hersongomez.pelisinfo.mvp.view;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;

import android.graphics.drawable.GradientDrawable;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.hersongomez.pelisinfo.R;
import com.hersongomez.pelisinfo.mvp.Interface.CarteleraView;
import com.hersongomez.pelisinfo.mvp.adapter.RecyclerAdapter;
import com.hersongomez.pelisinfo.mvp.adapter.SliderAdapter;
import com.hersongomez.pelisinfo.mvp.interactor.PeliculasResults;
import com.hersongomez.pelisinfo.mvp.presenter.PeliculasPresenter;
import com.smarteist.autoimageslider.IndicatorView.animation.type.IndicatorAnimationType;
import com.smarteist.autoimageslider.SliderAnimations;
import com.smarteist.autoimageslider.SliderView;

import java.util.ArrayList;

public class Cartelera extends AppCompatActivity implements CarteleraView{

    private PeliculasPresenter peliculasPresenter;
    private TextView           titulo;
    private RecyclerView       mRecyclerPopulares;
    private RecyclerView       mRecyclerExtrenos;
    SliderView                 sliderView;
    ProgressBar                progressBarEstrenos;
    ProgressBar                progressBarPopulares;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        setContentView(R.layout.activity_cartelera);

        titulo                  = findViewById(R.id.titulo);
        mRecyclerPopulares      = findViewById(R.id.RecyclerPopulares);
        sliderView              = findViewById(R.id.SliderEstrenos);
        progressBarEstrenos     = findViewById(R.id.progressBarEstrenos);
        progressBarPopulares    = findViewById(R.id.progressBarPopulares);

        peliculasPresenter      = new PeliculasPresenter(this);
        mostrarProgressBar();
        buscarDetallePeliculas();
    }

    @Override
    public void mostrarProgressBar() {
        progressBarEstrenos.setVisibility(View.VISIBLE);
        progressBarPopulares.setVisibility(View.VISIBLE);
    }

    @Override
    public void ocultarProgressBar() {
        progressBarEstrenos.setVisibility(View.GONE);
        progressBarPopulares.setVisibility(View.GONE);
    }

    @Override
    public void buscarDetallePeliculas() {
        peliculasPresenter.buscarDetallePeliculas();
    }

    @Override
    public void consultaFallida() {
        mostrarProgressBar();
    }

    @Override
    public void consultaExitosa(ArrayList<PeliculasResults> peliculas) {

        //Ocultar ProgressBar
        ocultarProgressBar();
        sliderView.setVisibility(View.VISIBLE);
        mRecyclerPopulares.setVisibility(View.VISIBLE);
        mostrarRecyclerPeliculas(peliculas,mRecyclerPopulares);

    }

    @Override
    public void consultaPopulares(ArrayList<PeliculasResults> peliculas) {
        mostrarSliderPeliculas(peliculas);
    }

    private void mostrarSliderPeliculas(ArrayList<PeliculasResults> peliculas) {
        SliderAdapter sliderAdapter = new SliderAdapter(peliculas, this);
        sliderView.setSliderAdapter(sliderAdapter);
        sliderView.setIndicatorAnimation(IndicatorAnimationType.THIN_WORM);
        sliderView.setSliderTransformAnimation(SliderAnimations.CUBEOUTDEPTHTRANSFORMATION);
        sliderView.startAutoCycle();
    }

    public void mostrarRecyclerPeliculas(ArrayList<PeliculasResults> peliculas, RecyclerView recyclerId) {

        //Propiedades recycler
        DividerItemDecoration itemDecoration = new DividerItemDecoration(this, DividerItemDecoration.VERTICAL);
        DividerItemDecoration itemDecoration2 = new DividerItemDecoration(this, DividerItemDecoration.HORIZONTAL);
        GradientDrawable drawable = new GradientDrawable(GradientDrawable.Orientation.BOTTOM_TOP, new int[]{0xfda947, 0xfda947});
        drawable.setSize(5,5);
        itemDecoration.setDrawable(drawable);
        itemDecoration2.setDrawable(drawable);
        recyclerId.addItemDecoration(itemDecoration);
        recyclerId.addItemDecoration(itemDecoration2);
        StaggeredGridLayoutManager staggeredGridLayoutManager = new StaggeredGridLayoutManager(3, StaggeredGridLayoutManager.VERTICAL);
        recyclerId.setLayoutManager(staggeredGridLayoutManager);

        //Mostrar Recycler
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(peliculas,this);
        recyclerId.setAdapter(recyclerAdapter);
    }
}