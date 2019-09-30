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


	@Override
	public boolean equals(Object o) {
		if (o == this)
			return true;
		if (!(o instanceof PreferencePair)) {
			return false;
		}
		PreferencePair preferencePair = (PreferencePair) o;
		return prog == preferencePair.prog && comp == preferencePair.comp;
	}



}
