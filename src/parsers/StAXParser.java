package parsers;

import entities.Candy;
import main.View;

import javax.xml.stream.XMLInputFactory;
import javax.xml.stream.XMLStreamConstants;
import javax.xml.stream.XMLStreamException;
import javax.xml.stream.XMLStreamReader;
import javax.xml.transform.stream.StreamSource;
import java.io.File;

/**
 * StAXParser class
 *
 * @author Evgeniy
 */

public class StAXParser extends Parser{

    @Override
    protected Candy Parse(){
        try {
            XMLStreamReader xmlStreamReader =
                    XMLInputFactory.newInstance().createXMLStreamReader(new StreamSource(new File(View.PATH_XML)));
            while (xmlStreamReader.hasNext()){
                switch (xmlStreamReader.next()){
                    case XMLStreamConstants.START_ELEMENT :
                        tags.add(xmlStreamReader.getLocalName());
                        candyFactory.getElementCommand(xmlStreamReader.getLocalName()).executeStart();
                        break;
                    case XMLStreamReader.CHARACTERS :
                        candyFactory.getElementCommand(tags.getLast()).executeCharacters(xmlStreamReader.getText());
                        break;
                    case XMLStreamConstants.END_ELEMENT :
                        tags.removeLast();
                        candyFactory.getElementCommand(xmlStreamReader.getLocalName()).executeEnd();
                        break;
                }
            }

        } catch (XMLStreamException e) {
            return null;
        }

        return candyFactory.getFilledCandy();
    }
}
