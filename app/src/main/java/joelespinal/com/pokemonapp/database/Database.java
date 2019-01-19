package joelespinal.com.pokemonapp.database;

import android.app.Application;

import joelespinal.com.pokemonapp.model.AttackDao;
import joelespinal.com.pokemonapp.model.DaoMaster;
import joelespinal.com.pokemonapp.model.DaoSession;
import joelespinal.com.pokemonapp.model.JoinPokeCardAndAttacksDao;
import joelespinal.com.pokemonapp.model.JoinPokeCardAndResistancesDao;
import joelespinal.com.pokemonapp.model.JoinPokeCardAndTypesDao;
import joelespinal.com.pokemonapp.model.JoinPokeCardAndWeaknessesDao;
import joelespinal.com.pokemonapp.model.KeyValueModelDao;
import joelespinal.com.pokemonapp.model.PokeCardDao;
import joelespinal.com.pokemonapp.model.TypesDao;

public class Database {

    private static Database database;
    private DaoSession daoSession;

    private Database() {

    }

    public static Database INSTANCE() {
        if (database == null)
            throw new RuntimeException("Database#init must run first");
        return database;
    }

    public static void init(Application application) {
        DaoMaster.DevOpenHelper devOpenHelper = new DaoMaster.DevOpenHelper(application, getDatabaseName());
        org.greenrobot.greendao.database.Database db = devOpenHelper.getWritableDb();
        if (database == null) {
            database = new Database();
        }
        database.daoSession = new DaoMaster(db).newSession();
    }

    private static String getDatabaseName() {
        return "pokemon.db";
    }

    public PokeCardDao getPokeCardDao() {
        return daoSession.getPokeCardDao();
    }

    public AttackDao getAttackDao() {
        return daoSession.getAttackDao();
    }

    public TypesDao getTypeDao() {
        return daoSession.getTypesDao();
    }

    public KeyValueModelDao getKeyValueDao() {
        return daoSession.getKeyValueModelDao();
    }

    public JoinPokeCardAndAttacksDao getJoinPokeCardAttacksDao() {
        return daoSession.getJoinPokeCardAndAttacksDao();
    }

    public JoinPokeCardAndTypesDao getJoinPokeCardAndTypesDao() {
        return daoSession.getJoinPokeCardAndTypesDao();
    }

    public JoinPokeCardAndWeaknessesDao getJoinPokeCardAndWeaknessesDao() {
        return daoSession.getJoinPokeCardAndWeaknessesDao();
    }

    public JoinPokeCardAndResistancesDao getJoinPokeCardAndResistancesDao() {
        return daoSession.getJoinPokeCardAndResistancesDao();
    }
}
