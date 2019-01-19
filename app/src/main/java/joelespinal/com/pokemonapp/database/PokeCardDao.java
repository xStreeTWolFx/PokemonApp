package joelespinal.com.pokemonapp.database;

import java.util.List;

import joelespinal.com.pokemonapp.model.PokeCard;

public class PokeCardDao {
    private static joelespinal.com.pokemonapp.model.PokeCardDao dao;


    static {
        dao = Database.INSTANCE().getPokeCardDao();
    }

    private PokeCardDao() {
    }


    public static List<PokeCard> loadAll() {
        return dao.loadAll();
    }

    public static void deleteAll() {
        dao.deleteAll();
    }

    public static long insert(PokeCard pokeCard) {
        return dao.insert(pokeCard);
    }

    public static void update(PokeCard pokeCard) {
        dao.update(pokeCard);
    }

    public static void save(PokeCard pokeCard) {
        dao.insertOrReplace(pokeCard);
    }
}
