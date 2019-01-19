package joelespinal.com.pokemonapp.database;

import java.util.List;

import joelespinal.com.pokemonapp.model.Types;

public class TypesDao {
    private static joelespinal.com.pokemonapp.model.TypesDao dao;


    static {
        dao = Database.INSTANCE().getTypeDao();
    }

    private TypesDao() {
    }


    public static List<Types> loadAll() {
        return dao.loadAll();
    }

    public static void deleteAll() {
        dao.deleteAll();
    }

    public static long insert(Types types) {
        return dao.insert(types);
    }

    public static void update(Types types) {
        dao.update(types);
    }

    public static void save(Types types) {
        dao.insertOrReplace(types);
    }

    public static void saveAll(List<Types> types) {
        dao.insertOrReplaceInTx(types);
    }
}
