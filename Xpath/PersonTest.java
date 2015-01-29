

import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.util.LinkedList;



public class PersonTest {

	public static void main(String[] args) {
		
		Person p1= new Person("Emina", "M.", 21);
		Person p2= new Person("Naida", "D.",29);
		Person p3= new Person("Nedim", "O.",32);
		Person p4= new Person("Adnan", "S.",38);
		Person p5= new Person("Hikmet", "D.",31);
		Person p6= new Person("Jesenko", "G.",27);		
		
		// add kids:
		
		// Emina
		p1.addChild(new Person ("Rambo", "M.",5));
		p1.addChild(new Person ("Sumaher", "M.",5));
		// Naida
		p2.addChild(new Person ("Necko", "D.",6));
		p2.addChild(new Person ("Zlocko", "D.",2));
		// Nedim
		p3.addChild(new Person ("Necko", "D.",5));
		p3.addChild(new Person ("Zlocko", "D.",1));
		// Adnan
		p4.addChild(new Person ("Aida", "S.",3));
		// Hikmet
		p5.addChild(new Person ("Nada", "O.",4));
		
		// Jesenko
		p6.addChild(new Person ("Zina", "G.",7));
		p6.addChild(new Person ("Lara", "G.",5));
		p6.addChild(new Person ("Necko", "D.",6));
		p6.addChild(new Person ("Maja", "D.",7));
		
		LinkedList<Person> people =  new LinkedList<Person>();
		people.add(p1);
		people.add(p2);
		people.add(p3);
		people.add(p4);
		people.add(p5);
		people.add(p6);
		
//		System.out.println(people.toString());
		
		try {
			Person.personToXML(people, new FileOutputStream("./XML/peopleChild.xml"));
			
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
