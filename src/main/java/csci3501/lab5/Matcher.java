package csci3501.lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * The matcher takes the preferences of the companies and programmers match them with a satisfactory order
 * It holds the arrays of companies' preferences and programmers' preferences,
 * an arrayList to store generated pairs and and int of the number of companies and programmers
 * 
 * Based on the pseudo code from: https://en.wikipedia.org/wiki/Stable_marriage_problem#Algorithm
 */
public class Matcher {
	private int N;
	private CompPreferences[] companiesPrefs;
	private ProgPreferences[] programmersPrefs;
	private ArrayList<PreferencePair> matchedPairs = new ArrayList<>();

    /**
     * Create a mew Matcher object
     * Note that our inputs always meet the following requirements:
     *     N programmers are looking for a job;
     *     N companies are looking to hire a programmer.
     *     Each programmer has a ranking of the companies based on his/her preferences
     *     for a workplace.
     *     Likewise,  each  company  has  a  ranking  of  the  N  programmers based on
     *     whom they would like to hire.
     * @param compsPreferences an array of each companies' preferences
     * @param progsPreferences an array of each programmers' preferences
     * @param N the number of companies and programmers
     * */
    public Matcher(CompPreferences[] compsPreferences, ProgPreferences[] progsPreferences, int N) {
        this.companiesPrefs = compsPreferences;
        this.programmersPrefs = progsPreferences;
	    this.N = N;
    }

    /**
     * Create a mew Matcher object
     * Sets N based on the number of companies provided
     * @param compsPreferences an array of each companies' preferences
     * @param progsPreferences an array of each programmers' preferences
     * */
    public Matcher(CompPreferences[] compsPreferences, ProgPreferences[] progsPreferences) {
        this(compsPreferences, progsPreferences, compsPreferences.length);
    }

    /**
     * This constructors allows us to test the isSatisfactory tests
     */
    public Matcher(CompPreferences[] compsPreferences, ProgPreferences[] progsPreferences, ArrayList<PreferencePair> matchedPairs) {  
        this(compsPreferences, progsPreferences);
        this.matchedPairs = matchedPairs;
    }

    /**
     * The method matches the companies and programmers into satisfactory pairs
     * @return an arrayList of the satisfactory programmer-company pairs
     * */
	public ArrayList<PreferencePair> match() {
		// Continue to get the next unmatched company's preference until all companys and programmers are matched
    	while (matchedPairs.size() < N) {
    		// Get the preference of the next unmatched company
    		CompPreferences compPref = Arrays.stream(companiesPrefs).filter(comp -> isMatchedWith(comp.selfChar) == null)
				    .findFirst().get();

    		// Get the next programmer from the company's preferences that have not tried
		    int p = compPref.getProgrammer();
		    char c = compPref.selfChar;

		    // Get the original preference pair of that programmer if they have already been matched
		    PreferencePair originalPair = isMatchedWith(p);

		    if (originalPair != null) {
		    	// If the programmer has already been matched, get that company and the programmer's preferences
			    char anotherComp = originalPair.comp;
			    char[] anotherCompPref = Arrays.stream(programmersPrefs).filter(prog -> prog.selfInt == p)
					    .findAny().get().charPreferences;

			    // Compare which of this company and the programmer's original paired company are more preferred
			    // to the programmer
			    for (char comp : anotherCompPref) {
				    if (c == comp)  {
					    // If is company has a higher preference level on the programmer, match this company with
					    // the programmer and replace the original pair
                        matchedPairs.set(matchedPairs.indexOf(originalPair), new PreferencePair(p, c));
                        break;
				    } else if (anotherComp == comp) {
			    		// If the other company have a higher preference, move to the next programmer on the
					    // company's preference list
			    		break;
				    }
			    }
		    } else {
		    	// If the programmer has not been matched yet, match the programmer with the company
		    	matchedPairs.add(new PreferencePair(p, c));
		    }
	    }
    	// Return the matched pairs after all companies and programmers are matched
    	return matchedPairs;
	}

	/**
	 * Identify whether the input company is already matched onto the matchPairs
	 * @return the pair the company is matched to if it is already matched, null otherwise
	 */
	private PreferencePair isMatchedWith(char comp) {
		for (PreferencePair pair : matchedPairs) {
			if (pair.comp == comp) return pair;
		}
    	return null;
	}

	/**
	 * Identify whether the input programmer is already matched onto the matchPairs
	 * @return the pair the programmer is matched to if it is already matched, null otherwise
	 */
	private PreferencePair isMatchedWith(int prog) {
		for (PreferencePair pair : matchedPairs) {
			if (pair.prog == prog) return pair;
		}
		return null;
	}

	/**
	 * Identify whether the generated pairs are satisfactory
	 * @return true if there is no pair of assignments (P1,  C1),  (P2,  C2) such that P1 ranks C2 higher than
	 * C1 and C2 ranks P1 higher than P2 (in other words, P1 can switch to C1 to increase both their own and C1’s
	 * level of satisfaction). False otherwise.
	 */
    public boolean isSatisfactory() {
        Map<Character, CompPreferences> companies = Arrays.stream(companiesPrefs).collect(Collectors.toMap(i -> i.selfChar, i -> i));
        Map<Integer, ProgPreferences> programmers = Arrays.stream(programmersPrefs).collect(Collectors.toMap(i -> i.selfInt, i -> i));

        // Selected two matched pairs each time
		for(PreferencePair pair1 : matchedPairs) {
			for(PreferencePair pair2 : matchedPairs) {
				if(!(pair1.equals(pair2))){
					// If they are different pairs, get two companies and two programmers on the two pairs
                    ProgPreferences p1 = programmers.get(pair1.prog);
                    ProgPreferences p2 = programmers.get(pair2.prog);
                    CompPreferences c1 = companies.get(pair1.comp);
                    CompPreferences c2 = companies.get(pair2.comp);
                    // Return false if programmer 1 ranks company 2 higher than company 1
					// and company 2 ranks programmer 1 higher than programmer 2
                    if((p1.indexOfPreference(c2.selfChar) < p1.indexOfPreference(c1.selfChar))
                    && (c2.indexOfPreference(p1.selfInt) < c2.indexOfPreference(p2.selfInt))) {

	                    System.out.println(pair1.toString() + pair2.toString());
                        return false;
                    }
				}
			}
        }
		// return true if there does not exist a chance that programmer 1 can switch to company 1 to increase
	    // both their own and company 1’s level of satisfaction and the resulting pairs are satisfactory
        return true;
	}
}
