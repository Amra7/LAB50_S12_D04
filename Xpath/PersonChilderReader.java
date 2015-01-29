
import java.io.File;
import java.io.IOException;
import java.util.Iterator;
import java.util.LinkedList;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.ParserConfigurationException;
import javax.xml.xpath.XPath;
import javax.xml.xpath.XPathConstants;
import javax.xml.xpath.XPathExpressionException;
import javax.xml.xpath.XPathFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;
import org.xml.sax.SAXException;

public class PersonChilderReader {

	public static void main(String[] args) throws ParserConfigurationException,
			SAXException, IOException, XPathExpressionException {

		DocumentBuilder docReader = DocumentBuilderFactory.newInstance()
				.newDocumentBuilder();
		Document xmldoc = docReader.parse(new File("./XML/peopleChild.xml"));
		// ne saljes new File nego url tipa "http://www.klix.ba/rss/svevijesti"

		XPath xPath = XPathFactory.newInstance().newXPath();
//		String expression = "/people/person/child";
//		String expression = "//child [age>4]";
		String expression = "//child/age";

		NodeList xmlPeople = (NodeList)xPath.compile(expression).evaluate(xmldoc, XPathConstants.NODESET);
		
		

		LinkedList<Person> people = new LinkedList();
		LinkedList<Person> children = new LinkedList();
		;

		for (int i = 0; i < xmlPeople.getLength(); i++) {
			Node current = xmlPeople.item(i);
			if (current instanceof Element) {
				Element currentElement = (Element) current;
				
				String name = currentElement.getAttribute("name");
				String surname = currentElement.getAttribute("surname");
				int age = Integer.parseInt(currentElement.getLastChild().getTextContent());
//				int age = Integer.parseInt(currentElement.getAttribute("age"));
				// people.add(new Person(name, surname));

				Person personTemp = new Person(name, surname, age);
				NodeList xmlChildren = current.getChildNodes();

				for (int j = 0; j < xmlChildren.getLength(); j++) {
					Node currentChild = xmlChildren.item(j);
					if (currentChild instanceof Element) {
						Element currentChildElement = (Element) currentChild;
						String nameChild = currentChildElement
								.getAttribute("name");
						String surnameChild = currentChildElement
								.getAttribute("surname");
						int ageChild = Integer.parseInt(currentChildElement
								.getAttribute("age"));
						// children.add(new Person(nameChild , surnameChild));
						personTemp.addChild(new Person(nameChild, surnameChild,
								ageChild));
					}
				}
				people.add(personTemp);
			}

		}
		Iterator iter = people.iterator();
		while (iter.hasNext()) {
			System.out.println(iter.next().toString());
		}
	}
}
