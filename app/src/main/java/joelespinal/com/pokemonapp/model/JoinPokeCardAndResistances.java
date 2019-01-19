package joelespinal.com.pokemonapp.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(indexes = {@Index(value = "pokeCardId,keyValueId", unique = true)})
public class JoinPokeCardAndResistances {
    @Id
    @Property(nameInDb = "_id")
    private Long id;

    @Property
    private Long pokeCardId;

    @Property
    private Long keyValueId;

    @Generated(hash = 1850373377)
    public JoinPokeCardAndResistances(Long id, Long pokeCardId, Long keyValueId) {
        this.id = id;
        this.pokeCardId = pokeCardId;
        this.keyValueId = keyValueId;
    }

    @Generated(hash = 624219372)
    public JoinPokeCardAndResistances() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Long getPokeCardId() {
        return this.pokeCardId;
    }

    public void setPokeCardId(Long pokeCardId) {
        this.pokeCardId = pokeCardId;
    }

    public Long getKeyValueId() {
        return this.keyValueId;
    }

    public void setKeyValueId(Long keyValueId) {
        this.keyValueId = keyValueId;
    }

}
