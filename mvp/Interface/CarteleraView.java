package com.hersongomez.pelisinfo.mvp.Interface;

import androidx.recyclerview.widget.RecyclerView;

import com.hersongomez.pelisinfo.R;
import com.hersongomez.pelisinfo.mvp.interactor.PeliculasResults;

import java.util.ArrayList;

public interface CarteleraView {

    void mostrarProgressBar();
    void ocultarProgressBar();
    void buscarDetallePeliculas();
    void consultaFallida();
    void consultaExitosa(ArrayList<PeliculasResults> peliculas);
}
