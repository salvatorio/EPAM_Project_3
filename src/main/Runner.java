package main;

import parsers.Parser;

import javax.xml.stream.XMLStreamException;

/**
 * Runner class of parsing
 *
 * @author Evgeniy
 */
public class Runner {

    public static void main(String[] args) throws XMLStreamException{

        System.out.println(View.DOM_PARSER + Parser.Parserfactory.newInstance().getDOMParser().ParseXML());
        System.out.println(View.SAX_PARSER + Parser.Parserfactory.newInstance().getSAXParser().ParseXML());
        System.out.println(View.StAX_PARSER + Parser.Parserfactory.newInstance().getStAXParser().ParseXML());
    }
}
