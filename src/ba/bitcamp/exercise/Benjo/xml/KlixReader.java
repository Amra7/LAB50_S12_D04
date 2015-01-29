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
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class KlixReader {
	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException {

		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document xmldoc = docReader.parse(new URL(
				"http://www.klix.ba/rss/svevijesti").openStream());

		// ne saljes new File nego url tipa "http://www.klix.ba/rss/svevijesti"
		NodeList xmlTitle = xmldoc.getElementsByTagName("title");
		
		HashMap<String,String> hm  =new HashMap<String, String>();
		
		NodeList xmlClanak = xmldoc.getElementsByTagName("clanak");

		// i - clanak
		// j - title
		for (int i = 0, j=2; i < xmlTitle.getLength() && j < xmlClanak.getLength(); j++) {
//			System.out.println(xmlTitle.item(i).getNodeName());
//			System.out.println(xmlTitle.item(i).getNodeValue());
//			System.out.println(xmlTitle.item(i).getTextContent());
			
			String title = xmlTitle.item(j).getTextContent();
			String clanak = xmlClanak.item(i).getTextContent();
			hm.put(title, clanak);
			
		}
		Set<String> setKeys = hm.keySet();
		Iterator<String> iter = setKeys.iterator();
		String first = iter.next();
		System.out.println("Prvi:  \n" + first);
		System.out.println(hm.get(first));

	}
}
