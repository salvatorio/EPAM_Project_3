package parsers;

import entities.Candy;
import main.View;

import javax.xml.XMLConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.transform.stream.StreamSource;
import javax.xml.validation.SchemaFactory;
import java.io.File;
import java.util.LinkedList;

/**
 * Parser class
 *
 * @author Evgeniy
 */

public abstract class Parser {

    CandyFactory candyFactory = new CandyFactory();
    LinkedList<String> tags = new LinkedList<>();

    private static void validateXML() throws XMLStreamException{

        try {
            SchemaFactory.newInstance(XMLConstants.W3C_XML_SCHEMA_NS_URI).newSchema(
                    new StreamSource(new File(View.PATH_XSD))).newValidator().validate(
                    new StreamSource(new File(View.PATH_XML)));

        } catch (Exception e) {
            throw new XMLStreamException();
        }
    }

    public final Candy ParseXML() throws XMLStreamException{
        validateXML();
        return Parse();
    }

    protected abstract Candy Parse() throws XMLStreamException;

    public static class Parserfactory{

        public static Parserfactory newInstance(){
            return new Parserfactory();
        }

        public Parser getDOMParser(){
            return new DOMParser();
        }

        public Parser getSAXParser(){
            return new SAXParser();
        }

        public Parser getStAXParser(){
            return new StAXParser();
        }
    }
}
