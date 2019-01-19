package joelespinal.com.pokemonapp.model;

import com.google.gson.annotations.SerializedName;

import org.greenrobot.greendao.annotation.Entity;


import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Index;
import org.greenrobot.greendao.annotation.Property;
import org.greenrobot.greendao.annotation.Generated;

@Entity(indexes = {@Index(value = "name,damage,convertedEnergyCost", unique = true)})
public class Attack {

    @Id
    @Property(nameInDb = "_id")
    private Long id;
    private String name;
    @SerializedName("text")
    private String overView;
    private String damage;
    private Integer convertedEnergyCost;

    @Generated(hash = 1027862204)
    public Attack(Long id, String name, String overView, String damage,
                  Integer convertedEnergyCost) {
        this.id = id;
        this.name = name;
        this.overView = overView;
        this.damage = damage;
        this.convertedEnergyCost = convertedEnergyCost;
    }

    @Generated(hash = 699029211)
    public Attack() {
    }

    public Long getId() {
        return this.id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return this.name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getOverView() {
        return this.overView;
    }

    public void setOverView(String overView) {
        this.overView = overView;
    }

    public String getDamage() {
        return this.damage;
    }

    public void setDamage(String damage) {
        this.damage = damage;
    }

    public Integer getConvertedEnergyCost() {
        return this.convertedEnergyCost;
    }

    public void setConvertedEnergyCost(Integer convertedEnergyCost) {
        this.convertedEnergyCost = convertedEnergyCost;
    }

}
