package joelespinal.com.pokemonapp.database;

import java.util.List;

import joelespinal.com.pokemonapp.model.JoinPokeCardAndWeaknesses;

public class JoinPokeCardAndWeaknessesDao {
    private static joelespinal.com.pokemonapp.model.JoinPokeCardAndWeaknessesDao dao;


    static {
        dao = Database.INSTANCE().getJoinPokeCardAndWeaknessesDao();
    }

    private JoinPokeCardAndWeaknessesDao() {
    }


    public static List<JoinPokeCardAndWeaknesses> loadAll() {
        return dao.loadAll();
    }

    public static void deleteAll() {
        dao.deleteAll();
    }

    public static long insert(JoinPokeCardAndWeaknesses joinPokeCardAndWeaknesses) {
        return dao.insert(joinPokeCardAndWeaknesses);
    }

    public static void update(JoinPokeCardAndWeaknesses joinPokeCardAndWeaknesses) {
        dao.update(joinPokeCardAndWeaknesses);
    }

    public static void save(JoinPokeCardAndWeaknesses joinPokeCardAndWeaknesses) {
        dao.update(joinPokeCardAndWeaknesses);
    }
}
