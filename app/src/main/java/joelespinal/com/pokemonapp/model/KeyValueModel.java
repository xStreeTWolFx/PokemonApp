package joelespinal.com.pokemonapp.model;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(indexes = {@Index(value = "type,value", unique = true)})
public class KeyValueModel {

    @Id(autoincrement = true)
    @Property(nameInDb = "_id")
    private Long id;
    private String type;
    private String value;
    @Generated(hash = 1206414349)
    public KeyValueModel(Long id, String type, String value) {
        this.id = id;
        this.type = type;
        this.value = value;
    }
    @Generated(hash = 247997907)
    public KeyValueModel() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getType() {
        return this.type;
    }
    public void setType(String type) {
        this.type = type;
    }
    public String getValue() {
        return this.value;
    }
    public void setValue(String value) {
        this.value = value;
    }
}
