package controller;

import java.util.List;

import gui.FormEvent;
import model.AgeCategory;
import model.Database;
import model.EmploymentCategory;
import model.Gender;
import model.Person;

public class Controller {

	Database db = new Database();

	public List<Person> getPeople() {
		return db.getPeople();
	}

	public void addPerson(final FormEvent aEvent) {
		String name = aEvent.getName();
		String occupation = aEvent.getOccupation();
		int ageCategoryId = aEvent.getAgeCategory();
		String empCat = aEvent.getEmploymentCategory();
		boolean usCitizen = aEvent.isUsCitizen();
		String taxId = aEvent.getTaxId();
		String genderId = aEvent.getGender();

		AgeCategory ageCategory = null;
		switch (ageCategoryId) {
		case 0:
			ageCategory = AgeCategory.CHILD;
			break;
		case 1:
			ageCategory = AgeCategory.ADULT;
			break;
		case 2:
			ageCategory = AgeCategory.SENIOR;
			break;
		}

		EmploymentCategory employmentCategory = null;
		if (empCat.equals("employed")) {
			employmentCategory = EmploymentCategory.EMPLOYED;
		} else if (empCat.equals("self-employed")) {
			employmentCategory = EmploymentCategory.SELF_EMPLOYED;
		} else if (empCat.equals("unemployed")) {
			employmentCategory = EmploymentCategory.UNEMPLOYED;
		} else {
			employmentCategory = EmploymentCategory.OTHER;
			System.err.println(empCat);
		}

		Gender gender = Gender.valueOf(genderId.toUpperCase());

		Person person = new Person(name, occupation, ageCategory, employmentCategory, taxId, usCitizen, gender);

		db.addPerson(person);
	}
}
