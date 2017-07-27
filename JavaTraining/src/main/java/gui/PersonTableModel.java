package gui;

import java.util.List;

import javax.swing.table.AbstractTableModel;

import model.Person;

public class PersonTableModel extends AbstractTableModel {

	private List<Person> db;
	private String[] colNames = { "ID", "Name", "Occupation", "Age Cat.", "Empl Cat.", "US citizen", "Genre" };

	public PersonTableModel() {
		super();
	}

	public void setData(final List<Person> aDb) {
		this.db = aDb;
	}

	@Override
	public int getRowCount() {
		return db.size();
	}

	@Override
	public int getColumnCount() {
		return 7;
	}

	@Override
	public Object getValueAt(int row, int column) {

		Person person = db.get(row);

		switch (column) {
		case 0:
			return person.getId();
		case 1:
			return person.getName();
		case 2:
			return person.getOccupation();
		case 3:
			return person.getAgeCategory();
		case 4:
			return person.getEmpCat();
		case 5:
			return person.isUsCitizen();
		case 6:
			person.getTaxId();
		}
		return null;
	}

	@Override
	public String getColumnName(int column) {
		return colNames[column];
	}

}
