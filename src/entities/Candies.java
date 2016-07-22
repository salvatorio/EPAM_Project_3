package entities;

import main.View;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 *
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Candies", propOrder = {
        "name",
        "energy",
        "type",
        "ingredients",
        "value",
        "production"
})

public class Candies {

    @XmlElement(name = "Name", required = true)
    protected String name;
    @XmlElement(name = "Energy", required = true)
    protected int energy;
    @XmlElement(name = "Type", required = true)
    protected String type;
    @XmlElement(name = "Ingredients", required = true)
    protected Ingredients ingredients;
    @XmlElement(name = "Value", required = true)
    private Value value;
    @XmlElement(name = "Production", required = true)
    private String production;

    /**
     * Gets the value of the name property
     * @return name
     */
    public String getName() {
        return name;
    }

    /**
     * Sets the value of the name property
     * @param value
     */
    public void setName(String value) {
        this.name = value;
    }

    /**
     * Gets the value of the energy property
     * @return energy
     */
    public int getEnergy() {
        return energy;
    }

    /**
     * Sets the value of the energy property
     * @param value
     */
    public void setEnergy(int value) {
        this.energy = value;
    }

    /**
     * Gets the value of the type property
     * @return type
     */
    public String getType() {
        return type;
    }

    /**
     * Sets the value of the type property
     * @param value
     */
    public void setType(String value) {
        this.type = value;
    }

    /**
     * Gets the value of the ingredients property
     * @return ingredients
     */
    public Ingredients getIngredients() {
        return ingredients;
    }

    /**
     * Sets the value of the ingredients property
     * @param value
     */
    public void setIngredients(Ingredients value) {
        this.ingredients = value;
    }

    /**
     * Gets the value of the value property
     * @return value
     */
    public Value getValue() {
        return value;
    }

    /**
     * Sets the value of the value property
     * @param value
     */
    public void setValue(Value value) {
        this.value = value;
    }

    /**
     * Gets the value of the production property
     * @return production
     */
    public String getProduction() {
        return production;
    }

    /**
     * Sets the value of the production property
     * @param value
     */
    public void setProduction(String value) {
        this.production = value;
    }

    @Override
    public String toString() {
        return String.format(View.NAME + "%s. " + View.ENERGY + "%s " + View.CALORIES + ". Its a %s. "
                        + View.CONSISTENCE + "%s.\n" + View.CALORIFIC_VALUE + "%s. " + View.PRODUCER + "%s\n",
                            name, energy, type, ingredients, value, production);
    }
}
