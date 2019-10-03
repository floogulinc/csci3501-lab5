package csci3501.lab5;

public class PreferencePair {
	final int prog;
	final char comp;

	PreferencePair(int programmer, char company) {
		prog = programmer;
		comp = company;
	}

	public String toString() {
		return "" + comp + prog;
	}

	boolean equals(PreferencePair p) {
		return p == this || prog == p.prog && comp == p.comp;
	}
}
