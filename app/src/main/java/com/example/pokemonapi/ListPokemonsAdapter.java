package com.example.pokemonapi;

import android.content.Context;
import android.media.Image;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import com.example.pokemonapi.models.Pokemon;
import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import org.w3c.dom.Text;

import java.util.ArrayList;

public class ListPokemonsAdapter extends RecyclerView.Adapter<ListPokemonsAdapter.ViewHolder> {
    private ArrayList<Pokemon> dataset;
    private Context context;
    private Pokemon p;

    public ListPokemonsAdapter(Context context){
        this.context=context;
        dataset = new ArrayList<>();
    }

    @NonNull
    @Override
    public ListPokemonsAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_pokemon, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        p = dataset.get(position);
        holder.nombrePokemon.setText(p.getName());
        Glide.with(context).load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/"+p.getNum()+".png")
                .centerCrop()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ftPokemon);

    }

    @Override
    public int getItemCount() {
        return 0;
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ftPokemon;
        private TextView nombrePokemon;
        private CardView tarjeta;

        public ViewHolder(View itemView){
            super(itemView);

            ftPokemon = (ImageView) itemView.findViewById(R.id.fotoPokemon);
            nombrePokemon = (TextView) itemView.findViewById(R.id.nombreTextView);
            tarjeta=(CardView) itemView.findViewById(R.id.tarjeta);


        }

    }
}
