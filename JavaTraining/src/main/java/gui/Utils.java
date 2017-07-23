package gui;

public class Utils {

	public static String getFileExtansion(final String aName) {
		int lastIndexOf = aName.lastIndexOf(".");
		if(lastIndexOf == -1) {
			return null;
		}
		
		if(lastIndexOf == aName.length()-1) {
			return null;
		}
		
		return aName.substring(lastIndexOf + 1, aName.length());
	}
	
}
