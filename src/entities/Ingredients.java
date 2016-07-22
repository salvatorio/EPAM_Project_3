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
@XmlType(name = "Ingredients", propOrder = {
        "water",
        "sugar",
        "fructose",
        "vanillin"
})
public class Ingredients {

    @XmlElement(name = "Water")
    private int water;
    @XmlElement(name = "Sugar")
    private int sugar;
    @XmlElement(name = "Fructose")
    private int fructose;
    @XmlElement(name = "Vanillin")
    private int vanillin;

    /**
     * Gets the value of the water property
     */
    public int getWater() {
        return water;
    }

    /**
     * Sets the value of the water property
     * @param value
     */
    public void setWater(int value) {
        this.water = value;
    }

    /**
     * Gets the value of the sugar property
     */
    public int getSugar() {
        return sugar;
    }

    /**
     * Sets the value of the sugar property
     * @param value
     */
    public void setSugar(int value) {
        this.sugar = value;
    }

    /**
     * Gets the value of the fructose property
     */
    public int getFructose() {
        return fructose;
    }

    /**
     * Sets the value of the fructose property
     * @param value
     */
    public void setFructose(int value) {
        this.fructose = value;
    }

    /**
     * Gets the value of the vanillin property
     */
    public int getVanillin() {
        return vanillin;
    }

    /**
     * Sets the value of the vanillin property
     * @param value
     */
    public void setVanillin(int value) {
        this.vanillin = value;
    }

    @Override
    public String toString() {
        return String.format("[%s " + View.WATER + ", %s " + View.SUGAR + ", %s " + View.FRUCTOSE + ", %s " + View.VANILLIN + "]",
                water, sugar, fructose, vanillin);
    }
}
