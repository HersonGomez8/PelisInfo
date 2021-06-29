package com.hersongomez.pelisinfo.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hersongomez.pelisinfo.R;
import com.hersongomez.pelisinfo.mvp.interactor.PeliculasResults;

import java.util.ArrayList;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.PeliculasViewHolder>{

    private ArrayList<PeliculasResults> results;
    Context context;

    public RecyclerAdapter(ArrayList<PeliculasResults> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @NonNull
    @Override
    public PeliculasViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.lista_peliculas,null,false);
        return new PeliculasViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull PeliculasViewHolder holder, int position) {
       // holder.bind(position);
        holder.url="https://image.tmdb.org/t/p/w500/"+results.get(position).getPoster_path();
        Glide.with(context)
                .load(holder.url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.imageViewPeliculas);
    }

    @Override
    public int getItemCount() {
        return results.size();
    }

    //Clase utilizada para definir y relacionar los elementos de la vista
    class PeliculasViewHolder extends RecyclerView.ViewHolder{

        ImageView imageViewPeliculas;
        private  String url;

        public PeliculasViewHolder(@NonNull View itemView) {
            super(itemView);

            imageViewPeliculas = itemView.findViewById(R.id.ImageViewPeliculas);
        }

        void bind (int ListaIndex){
            //imageViewPeliculas.setImageResource();
        }
    }
}
