package parsers;

import entities.Candy;
import main.View;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;

import javax.xml.parsers.ParserConfigurationException;
import javax.xml.parsers.SAXParserFactory;
import java.io.File;
import java.io.IOException;

/**
 * SAXParser class
 *
 * @author Evgeniy
 */

public class SAXParser extends Parser{

    @Override
    protected Candy Parse() {
        HandlerSAX handlerSAX = new HandlerSAX();

        try {
            SAXParserFactory.newInstance().newSAXParser().parse(new File(View.PATH_XML), handlerSAX);
        } catch (SAXException | IOException | ParserConfigurationException e) {
            return null;
        }
        return candyFactory.getFilledCandy();
    }

    /**
     * Handler class iterates tags
     */
    private class HandlerSAX extends DefaultHandler{

        @Override
        public void startElement(String uri, String localName, String qName, Attributes attributes) throws SAXException {
            tags.add(qName);
            candyFactory.getElementCommand(qName).executeStart();
        }

        @Override
        public void endElement(String uri, String localName, String qName) throws SAXException {
            tags.removeLast();
            candyFactory.getElementCommand(qName).executeEnd();
        }

        @Override
        public void characters(char[] ch, int start, int length) throws SAXException {
            candyFactory.getElementCommand(tags.getLast()).executeCharacters(String.copyValueOf(ch, start, length));
        }
    }
}
