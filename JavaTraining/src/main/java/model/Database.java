package model;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

public class Database {
	private List<Person> people;

	public Database() {
		people = new LinkedList<Person>();
	}

	public void addPerson(final Person aPerson) {
		people.add(aPerson);
		System.out.println("Added new person to db: " + aPerson.toString());
	}

	public List<Person> getPeople() {
		return Collections.unmodifiableList(people);
	}

	public void saveToFile(final File aFile) throws IOException {
		ObjectOutputStream oos = null;

		FileOutputStream fos = new FileOutputStream(aFile);
		oos = new ObjectOutputStream(fos);
		Person[] persons = people.toArray(new Person[people.size()]);
		oos.writeObject(persons);

		oos.close();

	}

	public void loadFromFile(final File aFile) throws IOException {
		FileInputStream fis = new FileInputStream(aFile);
		ObjectInputStream ois = new ObjectInputStream(fis);

		try {
			Person[] persons = (Person[]) ois.readObject();
			people.clear();
			people.addAll(Arrays.asList(persons));

		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ois.close();

	}

	public void removePerson(final int aIndex) {
		people.remove(aIndex);
	}
}
