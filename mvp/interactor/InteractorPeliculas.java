package com.hersongomez.pelisinfo.mvp.interactor;

import com.hersongomez.pelisinfo.mvp.Interface.CarteleraView;
import com.hersongomez.pelisinfo.mvp.Interface.InteractorPeliculasView;
import com.hersongomez.pelisinfo.mvp.Interface.PeliculasApiService;
import com.hersongomez.pelisinfo.mvp.Interface.PresenterPeliculasView;
import com.hersongomez.pelisinfo.mvp.view.Cartelera;

import java.util.ArrayList;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class InteractorPeliculas implements InteractorPeliculasView {

    private final PresenterPeliculasView presenterPeliculasView;

    public InteractorPeliculas(PresenterPeliculasView presenterPeliculasView) {
        this.presenterPeliculasView = presenterPeliculasView;
    }

    @Override
    public void buscarDetallePeliculas() {

        String BaseURL = "https://api.themoviedb.org/";
        //Se utiliza retrofit para consultar la data
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl(BaseURL)
                .addConverterFactory(GsonConverterFactory.create())
                .build();
        PeliculasApiService service = retrofit.create(PeliculasApiService.class);
        Call <Peliculas> call = service.consultarPeliculas();
        Call <Peliculas> call2 = service.consultarPeliculasProximas();

        call.enqueue(new Callback<Peliculas>() {
            @Override
            public void onResponse(Call<Peliculas> call, Response<Peliculas> response) {
                if(!response.isSuccessful()){
                    System.out.println("Mensaje --> Consulta incorrecta");
                    return;
                }

                Peliculas peliculasData = response.body();
                assert peliculasData != null;
                ArrayList<PeliculasResults> peliculas = peliculasData.getResults();

                if(peliculasData!=null){
                    consultaExitosa(peliculas);
                }
            }

            @Override
            public void onFailure(Call<Peliculas> call, Throwable t) {
                consultaFallida();
            }
        });

        call2.enqueue(new Callback<Peliculas>() {
            @Override
            public void onResponse(Call<Peliculas> call, Response<Peliculas> response) {
                if(!response.isSuccessful()){
                    System.out.println("Mensaje --> Consulta incorrecta");
                    return;
                }

                Peliculas peliculasData = response.body();
                assert peliculasData != null;
                ArrayList<PeliculasResults> peliculasproximas = peliculasData.getResults();

                if(peliculasData!=null){
                    consultaPopulares(peliculasproximas);
                    System.out.println("Mensaje --> Consulta Exitosa");
                }
            }

            @Override
            public void onFailure(Call<Peliculas> call, Throwable t) {
                consultaFallida();
            }
        });
    }

    @Override
    public void consultaFallida() {
        presenterPeliculasView.consultaFallida();
    }

    @Override
    public void consultaExitosa(ArrayList<PeliculasResults> peliculas) {
        presenterPeliculasView.consultaExitosa(peliculas);
    }

    @Override
    public void consultaPopulares(ArrayList<PeliculasResults> peliculas) {
        presenterPeliculasView.consultaPopulares(peliculas);
    }
}
