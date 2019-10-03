package csci3501.lab5;

import java.util.Arrays;
import java.util.List;

import com.google.common.primitives.Chars;

/**
 * The ProgPreference Class is used to store the input programmer's preferences
 * The field selfInt returns the int representing this programmer
 * The array charPreferences returns the preference of the programmer on companies
 */
public class ProgPreferences {
	final int selfInt;
	final char[] charPreferences;

	/**
	 * The constructor
	 * @param selfInt the int representing this programmer
	 * @param preferences the char array representing the preference of the programmer
	 *                    the less the index of a char is, the higher preference the programmer has
	 *                    toward the company
	 */
	ProgPreferences(int selfInt, char[] preferences){
		this.selfInt = selfInt;
		charPreferences = preferences;
	}

	/**
	 * The method returns the level of preference of a company on this programmer
	 * @param company the company to get the level of preference
	 * @return the level of preference of that company
	 */
	int indexOfPreference(char company) {
		return Chars.indexOf(charPreferences, company);		
	}

	/**
	 * The to string method
	 * @return a string representing both the int of the programmer and a char array of their preference
	 */
	public String toString() {
		return selfInt + ": " + Arrays.toString(charPreferences);
	}
}
