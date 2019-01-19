package joelespinal.com.pokemonapp.database;

import java.util.List;

import joelespinal.com.pokemonapp.model.JoinPokeCardAndAttacks;

public class JoinPokeCardAndAttacksDao {
    private static joelespinal.com.pokemonapp.model.JoinPokeCardAndAttacksDao dao;


    static {
        dao = Database.INSTANCE().getJoinPokeCardAttacksDao();
    }

    private JoinPokeCardAndAttacksDao() {
    }


    public static List<JoinPokeCardAndAttacks> loadAll() {
        return dao.loadAll();
    }

    public static void deleteAll() {
        dao.deleteAll();
    }

    public static long insert(JoinPokeCardAndAttacks joinPokeCardAndAttacks) {
        return dao.insert(joinPokeCardAndAttacks);
    }

    public static void update(JoinPokeCardAndAttacks joinPokeCardAndAttacks) {
        dao.update(joinPokeCardAndAttacks);
    }

    public static void save(JoinPokeCardAndAttacks joinPokeCardAndAttacks) {
        dao.update(joinPokeCardAndAttacks);
    }
}
