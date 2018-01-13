package in.co.kshitijjain.pokemondemo.adapter;

import android.content.res.Resources;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

import in.co.kshitijjain.pokemondemo.R;
import in.co.kshitijjain.pokemondemo.model.PokemonResponse;

public class PokemonAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private List<PokemonResponse.Pokemon> pokemonList;
    private Picasso picasso;
    private Resources resources;

    public PokemonAdapter(List<PokemonResponse.Pokemon> pokemonList, Picasso picasso, Resources resources) {
        this.pokemonList = pokemonList;
        this.picasso = picasso;
        this.resources = resources;
    }

    @Override
    public RecyclerView.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.recyclerview_single_item, parent, false);
        return new PokemonHolder(view);
    }

    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        PokemonResponse.Pokemon pokemon = pokemonList.get(position);
        ((PokemonHolder) holder).pokemonName.setText(pokemon.getName());
        picasso.load(resources.getString(R.string.image_link, pokemon.getNumber()))
                .placeholder(R.drawable.placeholder)
                .into(((PokemonHolder) holder).pokemonImage);
    }

    @Override
    public int getItemCount() {
        return pokemonList.size();
    }

    private class PokemonHolder extends RecyclerView.ViewHolder {

        ImageView pokemonImage;
        TextView pokemonName;

        private PokemonHolder(View itemView) {
            super(itemView);
            pokemonImage = itemView.findViewById(R.id.pokemon_image);
            pokemonName = itemView.findViewById(R.id.pokemon_name);

        }
    }
}
