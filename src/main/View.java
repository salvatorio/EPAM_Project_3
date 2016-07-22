package main;

/**
 * View constants
 *
 * @author Evgeniy
 */

public class View {

    public static final String PATH_XSD = "src/xml/Candy.xsd";
    public static final String PATH_XML = "src/xml/Candy.xml";

    public static final String EXAMPLE = "Example Candies: \n";
    public static final String DOM_PARSER = "Running with DOM Parser \n";
    public static final String SAX_PARSER = "Running with SAX Parser \n";
    public static final String StAX_PARSER = "Running with StAX Parser \n";
    public static final String NAME = "The name of candy - ";
    public static final String ENERGY = "Energy of 1 unit - ";
    public static final String CALORIES = "calories";
    public static final String CONSISTENCE = "This candy consists of ";
    public static final String WATER = "grams of water";
    public static final String SUGAR = "milligrams of sugar";
    public static final String FRUCTOSE = "milligrams of fructose";
    public static final String VANILLIN = "milligrams of vanillin";
    public static final String CALORIFIC_VALUE = "Calorific value is ";
    public static final String PROTEINS = "grams of proteins";
    public static final String FATS = "grams of fats";
    public static final String CARBOHYDRATES = "grams of carbohydrates";
    public static final String PRODUCER = "Produced by ";

    /**
     * print simple message
     * @param message
     */
    public void printMessage(String message) {
        System.out.println(message);
    }
}
