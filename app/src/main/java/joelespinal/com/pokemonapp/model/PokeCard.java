package joelespinal.com.pokemonapp.model;


import com.google.gson.annotations.SerializedName;


import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.JoinEntity;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.ToMany;

import java.util.List;

import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.DaoException;

@Entity(indexes = {@Index(value = "id", unique = true)})
public class PokeCard {

    @Id
    @Property(nameInDb = "_id")
    private Long code;
    private String id;
    private String name;
    private Integer pokeDexNumber;
    private String imageUrl;
    private String superType;
    private String subType;
    private String healthPoints;
    private Integer convertedRetreatCost;
    private String number;
    private String rarity;
    private String series;
    private String set;
    private String setCode;
    @ToMany
    @JoinEntity(entity = JoinPokeCardAndTypes.class, sourceProperty = "pokeCardId", targetProperty = "description")
    private List<Types> types;
    @ToMany
    @JoinEntity(entity = JoinPokeCardAndAttacks.class, sourceProperty = "pokeCardId", targetProperty = "attackId")
    private List<Attack> attacks;
    @ToMany
    @JoinEntity(entity = JoinPokeCardAndResistances.class, sourceProperty = "pokeCardId", targetProperty = "keyValueId")
    private List<KeyValueModel> resistances;
    @ToMany
    @JoinEntity(entity = JoinPokeCardAndWeaknesses.class, sourceProperty = "pokeCardId", targetProperty = "keyValueId")
    private List<KeyValueModel> weaknesses;
    /** Used to resolve relations */
    @Generated(hash = 2040040024)
    private transient DaoSession daoSession;
    /** Used for active entity operations. */
    @Generated(hash = 1406049131)
    private transient PokeCardDao myDao;

    @Generated(hash = 1152031527)
    public PokeCard(Long code, String id, String name, Integer pokeDexNumber, String imageUrl, String superType,
            String subType, String healthPoints, Integer convertedRetreatCost, String number, String rarity, String series,
            String set, String setCode) {
        this.code = code;
        this.id = id;
        this.name = name;
        this.pokeDexNumber = pokeDexNumber;
        this.imageUrl = imageUrl;
        this.superType = superType;
        this.subType = subType;
        this.healthPoints = healthPoints;
        this.convertedRetreatCost = convertedRetreatCost;
        this.number = number;
        this.rarity = rarity;
        this.series = series;
        this.set = set;
        this.setCode = setCode;
    }

    @Generated(hash = 886405657)
    public PokeCard() {
    }

    public Long getCode() {
        return this.code;
    }

    public void setCode(Long code) {
        this.code = code;
    }

    public String getId() {
        return this.id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getPokeDexNumber() {
        return this.pokeDexNumber;
    }

    public void setPokeDexNumber(Integer pokeDexNumber) {
        this.pokeDexNumber = pokeDexNumber;
    }

    public String getImageUrl() {
        return this.imageUrl;
    }

    public void setImageUrl(String imageUrl) {
        this.imageUrl = imageUrl;
    }

    public String getSuperType() {
        return this.superType;
    }

    public void setSuperType(String superType) {
        this.superType = superType;
    }

    public String getSubType() {
        return this.subType;
    }

    public void setSubType(String subType) {
        this.subType = subType;
    }

    public String getHealthPoints() {
        return this.healthPoints;
    }

    public void setHealthPoints(String healthPoints) {
        this.healthPoints = healthPoints;
    }

    public Integer getConvertedRetreatCost() {
        return this.convertedRetreatCost;
    }

    public void setConvertedRetreatCost(Integer convertedRetreatCost) {
        this.convertedRetreatCost = convertedRetreatCost;
    }

    public String getNumber() {
        return this.number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getRarity() {
        return this.rarity;
    }

    public void setRarity(String rarity) {
        this.rarity = rarity;
    }

    public String getSeries() {
        return this.series;
    }

    public void setSeries(String series) {
        this.series = series;
    }

    public String getSet() {
        return this.set;
    }

    public void setSet(String set) {
        this.set = set;
    }

    public String getSetCode() {
        return this.setCode;
    }

    public void setSetCode(String setCode) {
        this.setCode = setCode;
    }

    public void setTypes(List<Types> types) {
        this.types = types;
    }

    public void setAttacks(List<Attack> attacks) {
        this.attacks = attacks;
    }

    public void setResistances(List<KeyValueModel> resistances) {
        this.resistances = resistances;
    }

    public void setWeaknesses(List<KeyValueModel> weaknesses) {
        this.weaknesses = weaknesses;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1438792988)
    public List<Types> getTypes() {
        if (types == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            TypesDao targetDao = daoSession.getTypesDao();
            List<Types> typesNew = targetDao._queryPokeCard_Types(code);
            synchronized (this) {
                if (types == null) {
                    types = typesNew;
                }
            }
        }
        return types;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1060082255)
    public synchronized void resetTypes() {
        types = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1706152995)
    public List<Attack> getAttacks() {
        if (attacks == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            AttackDao targetDao = daoSession.getAttackDao();
            List<Attack> attacksNew = targetDao._queryPokeCard_Attacks(code);
            synchronized (this) {
                if (attacks == null) {
                    attacks = attacksNew;
                }
            }
        }
        return attacks;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 484048345)
    public synchronized void resetAttacks() {
        attacks = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 1354114395)
    public List<KeyValueModel> getResistances() {
        if (resistances == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            KeyValueModelDao targetDao = daoSession.getKeyValueModelDao();
            List<KeyValueModel> resistancesNew = targetDao._queryPokeCard_Resistances(code);
            synchronized (this) {
                if (resistances == null) {
                    resistances = resistancesNew;
                }
            }
        }
        return resistances;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1201077818)
    public synchronized void resetResistances() {
        resistances = null;
    }

    /**
     * To-many relationship, resolved on first access (and after reset).
     * Changes to to-many relations are not persisted, make changes to the target entity.
     */
    @Generated(hash = 834188905)
    public List<KeyValueModel> getWeaknesses() {
        if (weaknesses == null) {
            final DaoSession daoSession = this.daoSession;
            if (daoSession == null) {
                throw new DaoException("Entity is detached from DAO context");
            }
            KeyValueModelDao targetDao = daoSession.getKeyValueModelDao();
            List<KeyValueModel> weaknessesNew = targetDao._queryPokeCard_Weaknesses(code);
            synchronized (this) {
                if (weaknesses == null) {
                    weaknesses = weaknessesNew;
                }
            }
        }
        return weaknesses;
    }

    /** Resets a to-many relationship, making the next get call to query for a fresh result. */
    @Generated(hash = 1808063505)
    public synchronized void resetWeaknesses() {
        weaknesses = null;
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#delete(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 128553479)
    public void delete() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.delete(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#refresh(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 1942392019)
    public void refresh() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.refresh(this);
    }

    /**
     * Convenient call for {@link org.greenrobot.greendao.AbstractDao#update(Object)}.
     * Entity must attached to an entity context.
     */
    @Generated(hash = 713229351)
    public void update() {
        if (myDao == null) {
            throw new DaoException("Entity is detached from DAO context");
        }
        myDao.update(this);
    }

    /** called by internal mechanisms, do not call yourself. */
    @Generated(hash = 1510118106)
    public void __setDaoSession(DaoSession daoSession) {
        this.daoSession = daoSession;
        myDao = daoSession != null ? daoSession.getPokeCardDao() : null;
    }


}
