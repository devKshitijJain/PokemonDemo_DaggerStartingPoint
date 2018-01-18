package in.co.kshitijjain.pokemondemo.classes;

import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.support.annotation.NonNull;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.jakewharton.picasso.OkHttp3Downloader;
import com.squareup.picasso.Picasso;

import java.io.File;

import in.co.kshitijjain.pokemondemo.api.PokemonService;
import okhttp3.Cache;
import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import timber.log.Timber;

public class PokemonApplication extends Application {

    public static PokemonApplication get(Activity activity) {
        return (PokemonApplication) activity.getApplication();
    }

    private PokemonService pokemonService;
    private Picasso picasso;

    @Override
    public void onCreate() {
        super.onCreate();

        Timber.plant(new Timber.DebugTree());

        Context context = this;

        HttpLoggingInterceptor.Logger logger = new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(@NonNull String message) {
                Timber.i(message);
            }
        };

        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(logger);

        loggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BASIC);

        File cacheFile = new File(context.getCacheDir(), "cache");

        Cache cache = new Cache(cacheFile, 10 * 1024 * 1024);

        OkHttpClient okHttpClient = new OkHttpClient()
                .newBuilder()
                .addInterceptor(loggingInterceptor)
                .cache(cache)
                .build();

        OkHttp3Downloader okHttp3Downloader = new OkHttp3Downloader(okHttpClient);

        picasso = new Picasso.Builder(context)
                .downloader(okHttp3Downloader)
                .build();

        Gson gson = new GsonBuilder().create();

        Retrofit retrofit = new Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create(gson))
                .client(okHttpClient)
                .baseUrl("https://pokeapi.co/")
                .build();

        pokemonService = retrofit.create(PokemonService.class);
    }

    public PokemonService getPokemonService() {
        return pokemonService;
    }

    public Picasso getPicasso() {
        return picasso;
    }
}
