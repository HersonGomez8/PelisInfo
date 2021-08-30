package com.hersongomez.pelisinfo.mvp.Interface;

import com.hersongomez.pelisinfo.mvp.interactor.PeliculasResults;

import java.util.ArrayList;

public interface PresenterPeliculasView {
    void buscarDetallePeliculas();
    void consultaFallida();
    void consultaExitosa(ArrayList<PeliculasResults> peliculas);
    void consultaPopulares(ArrayList<PeliculasResults> peliculas);
}
