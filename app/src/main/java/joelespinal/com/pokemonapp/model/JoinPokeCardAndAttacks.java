package joelespinal.com.pokemonapp.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinPokeCardAndAttacks {

    @Id
    @Property(nameInDb = "_id")
    private Long id;

    @Property
    private Long pokeCardId;

    @Property
    private Long attackId;

    @Generated(hash = 469977823)
    public JoinPokeCardAndAttacks(Long id, Long pokeCardId, Long attackId) {
        this.id = id;
        this.pokeCardId = pokeCardId;
        this.attackId = attackId;
    }

    @Generated(hash = 1230823177)
    public JoinPokeCardAndAttacks() {
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

    public Long getAttackId() {
        return this.attackId;
    }

    public void setAttackId(Long attackId) {
        this.attackId = attackId;
    }


}
