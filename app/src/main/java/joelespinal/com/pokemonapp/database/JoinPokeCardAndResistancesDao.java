package joelespinal.com.pokemonapp.database;

import java.util.List;

import joelespinal.com.pokemonapp.model.JoinPokeCardAndResistances;

public class JoinPokeCardAndResistancesDao {
    private static joelespinal.com.pokemonapp.model.JoinPokeCardAndResistancesDao dao;


    static {
        dao = Database.INSTANCE().getJoinPokeCardAndResistancesDao();
    }

    private JoinPokeCardAndResistancesDao() {
    }


    public static List<JoinPokeCardAndResistances> loadAll() {
        return dao.loadAll();
    }

    public static void deleteAll() {
        dao.deleteAll();
    }

    public static long insert(JoinPokeCardAndResistances joinPokeCardAndResistances) {
        return dao.insert(joinPokeCardAndResistances);
    }

    public static void update(JoinPokeCardAndResistances joinPokeCardAndResistances) {
        dao.update(joinPokeCardAndResistances);
    }

    public static void save(JoinPokeCardAndResistances joinPokeCardAndResistances) {
        dao.update(joinPokeCardAndResistances);
    }
}
