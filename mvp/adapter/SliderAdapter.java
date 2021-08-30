package com.hersongomez.pelisinfo.mvp.adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.hersongomez.pelisinfo.R;
import com.hersongomez.pelisinfo.mvp.interactor.PeliculasResults;
import com.smarteist.autoimageslider.SliderViewAdapter;

import java.util.ArrayList;

public class SliderAdapter extends SliderViewAdapter<SliderAdapter.Holder> {

    private ArrayList<PeliculasResults> results;
    Context context;

    public SliderAdapter(ArrayList<PeliculasResults> results, Context context) {
        this.results = results;
        this.context = context;
    }

    @Override
    public Holder onCreateViewHolder(ViewGroup parent) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.slider_item, null, false);
        return new Holder(view);
    }

    @Override
    public void onBindViewHolder(Holder viewHolder, int position) {
        viewHolder.url = "https://image.tmdb.org/t/p/w500/" + results.get(position).getBackdrop_path();
        Glide.with(context)
                .load(viewHolder.url)
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(viewHolder.imageView);

    }

    @Override
    public int getCount() {
        return results.size();
    }

    public class Holder extends SliderViewAdapter.ViewHolder {

        public String url;
        ImageView imageView;

        public Holder(View itemView) {
            super(itemView);
            imageView = itemView.findViewById(R.id.imageViewSlider);
        }
    }
}
