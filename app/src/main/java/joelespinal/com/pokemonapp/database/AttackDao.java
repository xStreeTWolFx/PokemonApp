package joelespinal.com.pokemonapp.database;

import android.widget.ListView;

import java.util.List;

import joelespinal.com.pokemonapp.model.Attack;

public class AttackDao {
    private static joelespinal.com.pokemonapp.model.AttackDao dao;


    static {
        dao = Database.INSTANCE().getAttackDao();
    }

    private AttackDao() {
    }


    public static List<Attack> loadAll() {
        return dao.loadAll();
    }

    public static void deleteAll() {
        dao.deleteAll();
    }

    public static long insert(Attack attack) {
        return dao.insert(attack);
    }

    public static void saveAll(List<Attack> attacks) {
        dao.insertOrReplaceInTx(attacks);
    }

    public static void update(Attack attack) {
        dao.update(attack);
    }
}
