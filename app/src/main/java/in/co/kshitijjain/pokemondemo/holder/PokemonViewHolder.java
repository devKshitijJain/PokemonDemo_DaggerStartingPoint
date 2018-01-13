package in.co.kshitijjain.pokemondemo.holder;

import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import in.co.kshitijjain.pokemondemo.R;

public class PokemonViewHolder extends RecyclerView.ViewHolder {

    public ImageView pokemonImage;
    public TextView pokemonName;

    public PokemonViewHolder(View itemView) {
        super(itemView);
        pokemonImage = itemView.findViewById(R.id.pokemon_image);
        pokemonName = itemView.findViewById(R.id.pokemon_name);
    }
}
