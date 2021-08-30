package com.hersongomez.pelisinfo.mvp.Interface;

import com.hersongomez.pelisinfo.mvp.interactor.PeliculasResults;

import java.util.ArrayList;

public interface InteractorPeliculasView {
    void buscarDetallePeliculas();
    void consultaFallida();
    void consultaExitosa(ArrayList<PeliculasResults> Peliculas);
    void consultaPopulares(ArrayList<PeliculasResults> Peliculas);
}
