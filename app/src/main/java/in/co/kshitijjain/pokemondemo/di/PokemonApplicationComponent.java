package in.co.kshitijjain.pokemondemo.di;

import com.squareup.picasso.Picasso;

import dagger.Component;
import in.co.kshitijjain.pokemondemo.api.PokemonService;

@Component
public interface PokemonApplicationComponent {

    Picasso getPicasso();
    PokemonService getPokemonService();
}
