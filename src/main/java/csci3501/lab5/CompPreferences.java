package csci3501.lab5;

import java.util.Arrays;

import com.google.common.primitives.Ints;

/**
 * The CompPreference Class is used to store the input programmer's preferences
 * The field selfChar returns the char representing this company
 */
public class CompPreferences {
	final char selfChar;
	private final int[] intPreferences;
	private int i = 0;

	/**
	 * The constructor
	 * @param selfChar the int representing this company
	 * @param preferences the int array representing the preference of the company
	 *                    the less the index of a int is, the higher preference the company has
	 *                    toward the programmer
	 */
	CompPreferences(char selfChar, int[] preferences){
		this.selfChar = selfChar;
		intPreferences = preferences;
	}

	/**
	 * The method returns the next programmer on the preference array each time the method is called
	 * @return the int representing the next programmer
	 */
	int getProgrammer() {
		++i;
		return intPreferences[i - 1];
	}

	/**
	 * The method returns the level of preference of a programmer on this company
	 * @param programmer the programmer to get the level of preference
	 * @return the level of preference of that programmer
	 */
	int indexOfPreference(int programmer) {
		return Ints.indexOf(intPreferences, programmer);
	}

	/**
	 * The to string method
	 * @return a string representing both the char of the company and an int array of their its preference
	 */
	public String toString() {
		return selfChar + ": " + Arrays.toString(intPreferences);
	}
}
