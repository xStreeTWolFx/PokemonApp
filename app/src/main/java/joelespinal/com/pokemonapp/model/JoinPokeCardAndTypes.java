package joelespinal.com.pokemonapp.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class JoinPokeCardAndTypes {

    @Id
    @Property(nameInDb = "_id")
    private Long id;

    @Property
    private Long pokeCardId;

    @Property
    private String description;

    @Generated(hash = 1039714351)
    public JoinPokeCardAndTypes(Long id, Long pokeCardId, String description) {
        this.id = id;
        this.pokeCardId = pokeCardId;
        this.description = description;
    }

    @Generated(hash = 1683539400)
    public JoinPokeCardAndTypes() {
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

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

}
