package entities;

import main.View;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;
import java.util.ArrayList;
import java.util.List;

/**
 * <p>Java class for anonymous complex type.
 * <p>The following schema fragment specifies the expected content contained within this class.
 *
 * <pre>
 * </pre>
 */

@XmlAccessorType(XmlAccessType.FIELD)
@XmlType(name = "Candy", propOrder = {
        "candies"
})

public class Candy {

    @XmlElement(name = "Candies")
    private List<Candies> candies = new ArrayList<>();

    /**
     * adds new candies to global class Candy
     * @param candies candies object to add
     */
    public void addCandies(Candies candies){
        this.candies.add(candies);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        candies.forEach(candies -> stringBuilder.append(candies).append("\n"));
        return String.format(View.EXAMPLE + "%s", stringBuilder);
    }
}
