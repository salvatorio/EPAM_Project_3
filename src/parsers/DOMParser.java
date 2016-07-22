package parsers;

import entities.Candy;
import main.View;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import java.io.File;
import java.io.IOException;

/**
 * DOMParser class
 *
 * @author Evgeniy
 */

public class DOMParser extends Parser{

    @Override
    public Candy Parse() {
        try {
            parseNodes(DocumentBuilderFactory.newInstance().newDocumentBuilder().parse(
                    new File(View.PATH_XML)).getChildNodes());
            return candyFactory.getFilledCandy();
        }
        catch (SAXException | IOException | ParserConfigurationException e) {
            return null;
        }
    }

    /**
     * recursive proceeds tags
     * @param nodeList tags to proceed
     */
    private void parseNodes(NodeList nodeList){
        for (int i = 0; i < nodeList.getLength(); i++) {

            Node node = nodeList.item(i);

            if (node.hasChildNodes()){
                candyFactory.getElementCommand(node.getNodeName()).executeStart();
                parseNodes(node.getChildNodes());
                candyFactory.getElementCommand(node.getNodeName()).executeCharacters(node.getFirstChild().getNodeValue());
                candyFactory.getElementCommand(node.getNodeName()).executeEnd();
            }
        }
    }
}
