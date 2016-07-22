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
@XmlType(name = "Value", propOrder = {
        "proteins",
        "fats",
        "carbohydrates"
})
public class Value {

    @XmlElement(name = "Proteins", required = true)
    private double proteins;
    @XmlElement(name = "Fats", required = true)
    private double fats;
    @XmlElement(name = "Carbohydrates", required = true)
    private double carbohydrates;

    /**
     * Gets the value of the proteins property
     */
    public double getProteins() {
        return proteins;
    }

    /**
     * Sets the value of the proteins property
     * @param value
     */
    public void setProteins(double value) {
        this.proteins = value;
    }

    /**
     * Gets the value of the fats property
     */
    public double getFats() {
        return fats;
    }

    /**
     * Sets the value of the fats property
     * @param value
     */
    public void setFats(double value) {
        this.fats = value;
    }

    /**
     * Gets the value of the carbohydrates property
     */
    public double getCarbohydrates() {
        return carbohydrates;
    }

    /**
     * Sets the value of the carbohydrates property
     * @param value
     */
    public void setCarbohydrates(double value) {
        this.carbohydrates = value;
    }

    @Override
    public String toString() {
        return String.format("[%s " + View.PROTEINS + ", %s " + View.FATS + ", %s " + View.CARBOHYDRATES + "]",
                proteins, fats, carbohydrates);
    }
}
