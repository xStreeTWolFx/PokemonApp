package joelespinal.com.pokemonapp.database;

import java.util.List;

import joelespinal.com.pokemonapp.model.KeyValueModel;

public class KeyValueModelDao {
    private static joelespinal.com.pokemonapp.model.KeyValueModelDao dao;


    static {
        dao = Database.INSTANCE().getKeyValueDao();
    }

    private KeyValueModelDao() {
    }


    public static List<KeyValueModel> loadAll() {
        return dao.loadAll();
    }

    public static void deleteAll() {
        dao.deleteAll();
    }

    public static long insert(KeyValueModel keyValueModel) {
        return dao.insert(keyValueModel);
    }

    public static void update(KeyValueModel keyValueModel) {
        dao.update(keyValueModel);
    }

    public static void save(KeyValueModel keyValueModel) {
        dao.insertOrReplace(keyValueModel);
    }

    public static void saveAll(List<KeyValueModel> keyValueModels) {
        dao.insertOrReplaceInTx(keyValueModels);
    }
}
