package model;

import java.util.ArrayList;
import java.util.List;

public class Database {
	private List<Person> people;

	public Database() {
		people = new ArrayList<>();
	}

	public void addPerson(final Person aPerson) {
		people.add(aPerson);
		System.out.println("Added new person to db: " + aPerson.toString());
	}

	public List<Person> getPeople() {
		return people;
	}
}
