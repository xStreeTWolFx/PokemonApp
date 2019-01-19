package joelespinal.com.pokemonapp;

import android.app.Application;

import joelespinal.com.pokemonapp.database.Database;

public class PokemonApplication extends Application {

    @Override
    public void onCreate() {
        super.onCreate();
        Database.init(this);
    }
}
