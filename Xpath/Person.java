

import java.io.DataOutputStream;
import java.io.OutputStream;
import java.io.PrintWriter;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;



public class Person {

	private String name;
	private String surname;
	private int age;
	private LinkedList<Person> children =  new LinkedList<Person>();

	public Person(String name, String surname, int age) {
		this.name = name;
		this.surname = surname;
		this.age=age;

	}

	/**
	 * Method that adds child type of Person into LinkedList od children.
	 * 
	 * @param child
	 *            new Person that we add.
	 */
	public void addChild(Person person) {
		this.children.add(person);
	}

	/**
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * @return the surname
	 */
	public String getSurname() {
		return surname;
	}

	/**
	 * @param children
	 *            the children to set
	 */
	public void setChildren(LinkedList<Person> children) {
		this.children = children;
	}

	/**
	 * Convert all elements to string.
	 * 
	 * @return
	 */
	@Override
	public String toString() {
		String str1 = "";
		str1 += "name = " + name + " surname = " + surname + " age = " + age +"\n";
		String str2 = "";
		Iterator iter =  children.iterator();
		
		while( iter.hasNext()){
			str2 +="children =  " + iter.next().toString();
			
		}

		return str1 + str2;
	}

	public static void personToXML(List people, OutputStream os) {

		PrintWriter pw = new PrintWriter(os);
		pw.println("<?xml version=\"1.0\"?>");
		pw.println("<people>");
		Iterator<Person> iter = people.iterator();
		while (iter.hasNext()) {
			Person temp = iter.next();
			pw.println(" <person name = '" + temp.name + "' surname = '"
					+ temp.surname + "'>");
			pw.println("   <age>"+ temp.age +"'</age>");
			Iterator<Person> iterChild = temp.children.iterator();
			while ( iterChild.hasNext()){
				Person tempChild = iterChild.next();
				pw.println("  <child name = '" + tempChild.name + "' surname = '"
						+ tempChild.surname + "' age = '"+ tempChild.age +"'/>");
			}
			pw.println(" </person>");

		}
		pw.println("</people>");
		pw.flush();
	}

}
