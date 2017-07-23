package gui;

import java.io.File;

import javax.swing.filechooser.FileFilter;

public class PersonFileFilter extends FileFilter {

	@Override
	public boolean accept(final File aFile) {
		String name = aFile.getName();
		if(aFile.isDirectory()) {
			return true;
		}
		String fileExtansion = Utils.getFileExtansion(name);
		if (fileExtansion == null) {
			return false;
		}
		return true;
	}

	@Override
	public String getDescription() {
		return "Person database files (*.per)";
	}

}
