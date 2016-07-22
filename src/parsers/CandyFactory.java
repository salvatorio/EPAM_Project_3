package parsers;

import entities.Candies;
import entities.Candy;
import entities.Ingredients;
import entities.Value;

import java.util.Map;
import java.util.TreeMap;

/**
 *
 */

public class CandyFactory {

    /**
     * complete Candy object
     */
    private Candy filledCandy;

    /**
     * temporary object
     */
    private Candy candy;
    private Candies candies;
    private Ingredients ingredients;
    private Value value;

    /**
     * command pattern storing map
     */
    private final Map<String, Command> ELEMENT_COMMANDS = new TreeMap<>();
    {
        ELEMENT_COMMANDS.put("Candy", new Command() {
            @Override
            public void executeStart() {
                candy = new Candy();
            }

            @Override
            public void executeEnd() {
                filledCandy = candy;
                candy = null;
            }
        });
        ELEMENT_COMMANDS.put("Candies", new Command() {
            @Override
            public void executeStart() {
                candies = new Candies();
            }

            @Override
            public void executeEnd() {
                candy.addCandies(candies);
                candies = null;
            }
        });
        ELEMENT_COMMANDS.put("Name", new Command() {
            @Override
            public void executeCharacters(String characters) {
                candies.setName(characters);
            }
        });
        ELEMENT_COMMANDS.put("Energy", new Command() {
            @Override
            public void executeCharacters(String characters) {
                candies.setEnergy(Integer.valueOf(characters));
            }
        });
        ELEMENT_COMMANDS.put("Type", new Command() {
            @Override
            public void executeCharacters(String characters) {
                candies.setType(characters);
            }
        });
        ELEMENT_COMMANDS.put("Ingredients", new Command() {
            @Override
            public void executeStart() {
                ingredients = new Ingredients();
            }

            @Override
            public void executeEnd() {
                candies.setIngredients(ingredients);
                ingredients = null;
            }
        });
        ELEMENT_COMMANDS.put("Water", new Command() {
            @Override
            public void executeCharacters(String characters) {
                ingredients.setWater(Integer.valueOf(characters));
            }
        });
        ELEMENT_COMMANDS.put("Sugar", new Command() {
            @Override
            public void executeCharacters(String characters) {
                ingredients.setSugar(Integer.valueOf(characters));
            }
        });
        ELEMENT_COMMANDS.put("Fructose", new Command() {
            @Override
            public void executeCharacters(String characters) {
                ingredients.setFructose(Integer.valueOf(characters));
            }
        });
        ELEMENT_COMMANDS.put("Water", new Command() {
            @Override
            public void executeCharacters(String characters) {
                ingredients.setWater(Integer.valueOf(characters));
            }
        });
        ELEMENT_COMMANDS.put("Vanillin", new Command() {
            @Override
            public void executeCharacters(String characters) {
                ingredients.setVanillin(Integer.valueOf(characters));
            }
        });
        ELEMENT_COMMANDS.put("Value", new Command() {
            @Override
            public void executeStart() {
                value = new Value();
            }

            @Override
            public void executeEnd() {
                candies.setValue(value);
                value = null;
            }
        });
        ELEMENT_COMMANDS.put("Proteins", new Command() {
            @Override
            public void executeCharacters(String characters) {
                value.setProteins(Double.valueOf(characters));
            }
        });
        ELEMENT_COMMANDS.put("Fats", new Command() {
            @Override
            public void executeCharacters(String characters) {
                value.setFats(Double.valueOf(characters));
            }
        });
        ELEMENT_COMMANDS.put("Carbohydrates", new Command() {
            @Override
            public void executeCharacters(String characters) {
                value.setCarbohydrates(Double.valueOf(characters));
            }
        });
        ELEMENT_COMMANDS.put("Production", new Command() {
            @Override
            public void executeCharacters(String characters) {
                candies.setProduction(characters);
            }
        });
    }

    /**
     * gets complete Candy object
     * @return complete Candy object
     */
    Candy getFilledCandy() {
        return filledCandy;
    }

    /**
     * gets Command object for some tag
     * @param element tag name to get command
     * @return command for tag
     */
    Command getElementCommand (String element){
        return ELEMENT_COMMANDS.get(element);
    }

    /**
     * Command class for command pattern
     */
    public abstract class Command{
        /**
         * Action on tag open
         */
        public void executeStart(){}

        /**
         * Action on tag close
         */
        public void executeEnd(){}

        /**
         * Action on element value reading
         * @param characters element value
         */
        public void executeCharacters(String characters){}
    }
}
