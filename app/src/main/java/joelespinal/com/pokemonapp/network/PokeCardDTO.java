package joelespinal.com.pokemonapp.network;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

import joelespinal.com.pokemonapp.model.Attack;
import joelespinal.com.pokemonapp.model.KeyValueModel;
import joelespinal.com.pokemonapp.model.PokeCard;
import joelespinal.com.pokemonapp.model.Types;

public class PokeCardDTO {

    private String id;
    private String name;
    private Integer nationalPokedexNumber;
    private String imageUrl;
    private List<String> types;
    @SerializedName("supertype")
    private String superType;
    @SerializedName("subtype")
    private String subType;
    @SerializedName("hp")
    private String healthPoints;
    private Integer convertedRetreatCost;
    private String number;
    private String rarity;
    private String series;
    private String set;
    private String setCode;
    private List<Attack> attacks;
    private List<KeyValueModel> resistances;
    private List<KeyValueModel> weaknesses;

    public String getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getNationalPokedexNumber() {
        return nationalPokedexNumber;
    }

    public String getImageUrl() {
        return imageUrl;
    }

    public String getSuperType() {
        return superType;
    }

    public String getSubType() {
        return subType;
    }

    public String getHealthPoints() {
        return healthPoints;
    }

    public Integer getConvertedRetreatCost() {
        return convertedRetreatCost;
    }

    public String getNumber() {
        return number;
    }

    public String getRarity() {
        return rarity;
    }

    public String getSeries() {
        return series;
    }

    public String getSet() {
        return set;
    }

    public String getSetCode() {
        return setCode;
    }

    public List<Attack> getAttacks() {
        return attacks;
    }

    public List<KeyValueModel> getResistances() {
        return resistances;
    }

    public List<KeyValueModel> getWeaknesses() {
        return weaknesses;
    }

    public List<Types> getTypes() {
        List<Types> types = new ArrayList<>();
        if (this.types != null && !this.types.isEmpty())
            for (String type : this.types) {
                types.add(new Types(type));
            }
        return types;
    }

    public PokeCard getPockeCard() {
        PokeCard pokeCard = new PokeCard();
        pokeCard.setId(this.id);
        pokeCard.setName(this.name);
        pokeCard.setPokeDexNumber(this.nationalPokedexNumber);
        pokeCard.setImageUrl(this.imageUrl);
        pokeCard.setSuperType(this.superType);
        pokeCard.setSubType(this.subType);
        pokeCard.setHealthPoints(this.healthPoints);
        pokeCard.setConvertedRetreatCost(this.convertedRetreatCost);
        pokeCard.setNumber(this.number);
        pokeCard.setRarity(this.rarity);
        pokeCard.setSeries(this.series);
        pokeCard.setSet(this.set);
        pokeCard.setSetCode(this.setCode);
        pokeCard.setTypes(getTypes());
        pokeCard.setAttacks(this.attacks);
        pokeCard.setWeaknesses(this.weaknesses);
        pokeCard.setResistances(this.resistances);
        return pokeCard;
    }
}
