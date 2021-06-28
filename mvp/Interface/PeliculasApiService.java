package com.hersongomez.pelisinfo.mvp.Interface;

import com.hersongomez.pelisinfo.mvp.interactor.Peliculas;

import retrofit2.Call;
import retrofit2.http.GET;

public interface PeliculasApiService {
    @GET("3/movie/popular?api_key=c051e24a7c62ff2c01982445b6ff5860")
    Call<Peliculas> consultarPeliculas();
}
