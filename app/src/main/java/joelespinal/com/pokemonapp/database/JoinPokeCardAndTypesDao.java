package joelespinal.com.pokemonapp.database;

import java.util.List;

import joelespinal.com.pokemonapp.model.JoinPokeCardAndTypes;

public class JoinPokeCardAndTypesDao {
    private static joelespinal.com.pokemonapp.model.JoinPokeCardAndTypesDao dao;


    static {
        dao = Database.INSTANCE().getJoinPokeCardAndTypesDao();
    }

    private JoinPokeCardAndTypesDao() {
    }


    public static List<JoinPokeCardAndTypes> loadAll() {
        return dao.loadAll();
    }

    public static void deleteAll() {
        dao.deleteAll();
    }

    public static long insert(JoinPokeCardAndTypes joinPokeCardAndTypes) {
        return dao.insert(joinPokeCardAndTypes);
    }

    public static void update(JoinPokeCardAndTypes joinPokeCardAndTypes) {
        dao.update(joinPokeCardAndTypes);
    }

    public static void save(JoinPokeCardAndTypes joinPokeCardAndTypes) {
        dao.update(joinPokeCardAndTypes);
    }
}
