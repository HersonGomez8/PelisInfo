package com.hersongomez.pelisinfo.mvp.presenter;

import androidx.annotation.NonNull;

import com.hersongomez.pelisinfo.mvp.Interface.CarteleraView;
import com.hersongomez.pelisinfo.mvp.Interface.InteractorPeliculasView;
import com.hersongomez.pelisinfo.mvp.Interface.PresenterPeliculasView;
import com.hersongomez.pelisinfo.mvp.interactor.InteractorPeliculas;
import com.hersongomez.pelisinfo.mvp.interactor.PeliculasResults;

import java.util.ArrayList;

public class PeliculasPresenter implements PresenterPeliculasView {

    private CarteleraView carteleraView;
    private InteractorPeliculasView interactorPeliculasView;

    public PeliculasPresenter( CarteleraView carteleraView) {
        this.carteleraView = carteleraView;
        this.interactorPeliculasView = new InteractorPeliculas(this);
    }

    @Override
    public void buscarDetallePeliculas() {
        interactorPeliculasView.buscarDetallePeliculas();
    }

    @Override
    public void consultaFallida() {
        carteleraView.consultaFallida();
    }

    @Override
    public void consultaExitosa(ArrayList<PeliculasResults> peliculas) {
        carteleraView.consultaExitosa(peliculas);
    }

    @Override
    public void consultaPopulares(ArrayList<PeliculasResults> peliculas) {
        carteleraView.consultaPopulares(peliculas);
    }
}
