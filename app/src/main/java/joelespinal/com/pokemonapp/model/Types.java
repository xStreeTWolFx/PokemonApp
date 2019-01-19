package joelespinal.com.pokemonapp.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity
public class Types {

    @Id
    @Property(nameInDb = "_id")
    private Long id;
    private String description;

    @Generated(hash = 509703173)
    public Types(Long id, String description) {
        this.id = id;
        this.description = description;
    }

    @Generated(hash = 48332467)
    public Types() {
    }

    public Types(String description) {
        this.description = description;
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescription() {
        return this.description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
