package ba.bitcamp.exercise.Benjo.xml;

import java.io.IOException;
import java.net.URL;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Set;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;

import org.w3c.dom.Document;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class KlixReaderOtherWay {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {

		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document xmldoc = docReader.parse(new URL(
				"http://www.klix.ba/rss/svevijesti").openStream());

		// ne saljes new File nego url tipa "http://www.klix.ba/rss/svevijesti"
		NodeList xmlItem = xmldoc.getElementsByTagName("item");
		
		HashMap<String,String> hm  =new HashMap<String, String>();
		String title = "";
		String clanak = "";
		for ( int i=0; i<xmlItem.getLength(); i++){
			Node current = xmlItem.item(i);
			
			NodeList childItem = current.getChildNodes();
			 for ( int j =0; j<childItem.getLength(); j++ ){
				 Node childCurrent = childItem.item(j);
				 
				 if( childCurrent.getNodeName().equals("title")){
					 title = childCurrent.getTextContent();
					 System.out.println("__________________________________________________");
					 System.out.println("Title: \n" + title);
					 System.out.println("__________________________________________________");
					 
				 }
				 if( childCurrent.getNodeName().equals("clanak")){
					 clanak = childCurrent.getTextContent();
					 System.out.println("Clanak: \n" + clanak);
				 }
			 }
			 hm.put(title, clanak);
			
		}

		Set<String> setKeys = hm.keySet();
		Iterator<String> iter = setKeys.iterator();
		String first = iter.next();
		System.out.println("Prvi:  \n" + first);
		System.out.println("__________________________________________________");
		System.out.println(hm.get(first));

	}
}
