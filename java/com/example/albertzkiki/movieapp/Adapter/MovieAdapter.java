package com.example.albertzkiki.movieapp.Adapter;

import android.content.Context;
import android.content.Intent;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.albertzkiki.movieapp.DetailActivity;
import com.example.albertzkiki.movieapp.R;
import com.example.albertzkiki.movieapp.model.movie;

import java.util.List;

/**
 * Created by albertzkiki on 3/23/2018.
 */

public class MovieAdapter  extends RecyclerView.Adapter<MovieAdapter.MyViewHolder>{

    private Context mContext;
    private List<movie> movieList;


    public MovieAdapter(Context mContext, List<movie> movieList){

        this.mContext = mContext;
        this.movieList = movieList;

    }

    @Override
    public MovieAdapter.MyViewHolder onCreateViewHolder(ViewGroup viewGroup, int i){

        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.movie_card, viewGroup, false);
        return new MyViewHolder(view);

    }

    @Override
    public void onBindViewHolder(final MovieAdapter.MyViewHolder viewHolder, int i){

        viewHolder.title.setText(movieList.get(i).getOriginalTitle());
        String vote = Double.toString(movieList.get(i).getVoteAverage());
        viewHolder.userrating.setText(vote);

        Glide.with(mContext)
                .load(movieList.get(i).getPosterPath())
                .placeholder(R.drawable.load)
                .into(viewHolder.thumbnail);
    }

    @Override
    public int getItemCount(){

        return movieList.size();
    }




    public class MyViewHolder extends RecyclerView.ViewHolder{

        public TextView title,userrating;
        public ImageView thumbnail;

        public MyViewHolder(View view){
            super(view);
            title = (TextView)view.findViewById(R.id.title);
            userrating =(TextView)view.findViewById(R.id.userrating);
            thumbnail = (ImageView)view.findViewById(R.id.thumbnail);


            view.setOnClickListener(new View.OnClickListener(){

                @Override
                public void onClick(View v){

                    int pos = getAdapterPosition();
                    if(pos != RecyclerView.NO_POSITION){


                        movie clickedDataItem = movieList.get(pos);
                        Intent intent = new Intent(mContext, DetailActivity.class);
                        intent.putExtra("original_title", movieList.get(pos).getOriginalTitle());
                        intent.putExtra("poster_path", movieList.get(pos).getPosterPath());
                        intent.putExtra("overview", movieList.get(pos).getOverview());
                        intent.putExtra("vote_average", movieList.get(pos).getVoteAverage());
                        intent.putExtra("release_date", movieList.get(pos).getReleaseDate());
                        intent.putExtra("id", movieList.get(pos).getId());
                        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

                        mContext.startActivity(intent);

                        Toast.makeText(v.getContext(), "You Clicked" + clickedDataItem.getOriginalTitle(), Toast.LENGTH_SHORT).show();

                    }

                }



            });

        }



    }



}



