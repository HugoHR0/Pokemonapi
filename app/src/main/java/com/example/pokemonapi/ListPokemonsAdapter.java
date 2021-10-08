package com.example.pokemonapi;

import android.content.Context;
import android.content.Intent;
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
import com.example.pokemonapi.activities.MainActivity;
import com.example.pokemonapi.activities.caracteristicasPokemon;
import com.example.pokemonapi.models.Pokemon;
import com.example.pokemonapi.utils.Constant;
//import static com.bumptech.glide.load.resource.drawable.DrawableTransitionOptions.withCrossFade;

import org.w3c.dom.Text;

import java.util.ArrayList;
import java.util.List;

public class ListPokemonsAdapter extends RecyclerView.Adapter<ListPokemonsAdapter.ViewHolder> {
    List<Pokemon> pokemonList;
    private ArrayList<Pokemon> dataset;
    private Context context;
    private Pokemon p;
    Context ctx;

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
        Glide.with(context)
                .load("https://raw.githubusercontent.com/PokeAPI/sprites/master/sprites/pokemon/shiny/"+p.getNum()+".png")
                .centerCrop()
                //.transition(withCrossFade())
                .crossFade()
                .diskCacheStrategy(DiskCacheStrategy.ALL)
                .into(holder.ftPokemon);
        String pokemonId = dataset.get(position).getName();
        holder.ftPokemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                Intent intent = new Intent(ctx, caracteristicasPokemon.class);
                intent.putExtra(Constant.EXTRA_POKEMON_ID, pokemonId);
                ctx.startActivity(intent);


            }
        });

    }

    @Override
    public int getItemCount() {
        return  dataset.size();
    }

    public void adicionaListaPokemon(ArrayList<Pokemon>listaPokemon)
    {
        dataset.addAll(listaPokemon);
        notifyDataSetChanged();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        public View llayaut;
        private ImageView ftPokemon;
        private TextView nombrePokemon;
        private CardView tarjeta;

        public ViewHolder(View itemView){
            super(itemView);

           ftPokemon = (ImageView) itemView.findViewById(R.id.imgPokemon);
            nombrePokemon = (TextView) itemView.findViewById(R.id.nombreTextView);
            tarjeta=(CardView) itemView.findViewById(R.id.tarjeta);


        }

    }
}
