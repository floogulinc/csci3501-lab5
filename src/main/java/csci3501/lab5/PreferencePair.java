package csci3501.lab5;

/**
 * The PreferencePair is used to store the pairs of generated preference pairs
 * The field prog returns the int representing the programmer
 * The field comp returns the char representing the company
 */
public class PreferencePair {
	final int prog;
	final char comp;

	/** The constructor
	 * @param programmer The programmer to and to the pair
	 * @param company The company to add to the pair
	 */
	PreferencePair(int programmer, char company) {
		prog = programmer;
		comp = company;
	}

	/**
	 * The to string method
	 * @return the to srting of the preference pair
	 */
	public String toString() {
		return "" + comp + prog;
	}

	/**
	 * The equals mathod
	 * @param p another preference pair
	 * @return true if another preference pair is the same one to this preference pair
	 * or they have the same programmer and company*/
	boolean equals(PreferencePair p) {
		return p == this || prog == p.prog && comp == p.comp;
	}
}
