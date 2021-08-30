package com.hersongomez.pelisinfo.mvp.Interface;

import com.hersongomez.pelisinfo.mvp.interactor.Peliculas;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeliculasApiService {
    @GET("3/movie/popular?api_key=c051e24a7c62ff2c01982445b6ff5860&language=es-ES")
    Call<Peliculas> consultarPeliculas();

    @GET("3/movie/top_rated?api_key=c051e24a7c62ff2c01982445b6ff5860&language=es-ES")
    Call<Peliculas> consultarPeliculasProximas();
}
