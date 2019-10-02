package csci3501.lab5;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Map;
import java.util.stream.Collectors;

public class Matcher {
    private CompPreferences[] companiesPrefsOriginal;
	private ProgPreferences[] programmersPredsOriginal;
    private ArrayList<PreferencePair> matchedPairs = new ArrayList<>();
    private int N;

    public Matcher(CompPreferences[] compsPreferences, ProgPreferences[] progsPreferences, int N) {
        this.companiesPrefsOriginal = compsPreferences;
        this.programmersPredsOriginal = progsPreferences;
	    this.N = N;
    }

	public ArrayList<PreferencePair> match() {
    	while (matchedPairs.size() < N) {
    		CompPreferences compP = Arrays.stream(companiesPrefsOriginal).filter(comp -> isMatchedWith(comp.selfChar) == null)
				    .findFirst().get();

		    int p = compP.getProgramer();
		    char c = compP.selfChar;
		    PreferencePair originalPair = isMatchedWith(p);

		    if (originalPair != null) {
			    char anotherC = originalPair.comp;
			    char[] otherCompP = Arrays.stream(programmersPredsOriginal).filter(prog -> prog.selfInt == p)
					    .findAny().get().charPreferences;

			    for (char comp : otherCompP) {
			    	if (c == comp)  {
			    	    matchedPairs.set(matchedPairs.indexOf(originalPair), new PreferencePair(p, c));
				    } else if (anotherC == comp) {
			    		break;
				    }
			    }
		    } else {
		    	matchedPairs.add(new PreferencePair(p, c));
		    }
//		    System.out.println(matchedPairs);
	    }
    	return matchedPairs;
	}

	private PreferencePair isMatchedWith(char c) {
		for (PreferencePair p : matchedPairs) {
			if (p.comp == c) return p;
		}
    	return null;
	}

	private PreferencePair isMatchedWith(int i) {
		for (PreferencePair p : matchedPairs) {
			if (p.prog == i) return p;
		}
		return null;
	}

    public  boolean isSatisfactory(ArrayList<PreferencePair> pairs) {
        Map<Character, CompPreferences> companies = Arrays.stream(companiesPrefsOriginal).collect(Collectors.toMap(i -> i.selfChar, i -> i));
        Map<Integer, ProgPreferences> programmers = Arrays.stream(programmersPredsOriginal).collect(Collectors.toMap(i -> i.selfInt, i -> i));

		for(PreferencePair pair1 : pairs) {
			for(PreferencePair pair2 : pairs) {
				if(!(pair1.equals(pair2))){
                    ProgPreferences p1 = programmers.get(pair1.prog);
                    ProgPreferences p2 = programmers.get(pair2.prog);
                    CompPreferences c1 = companies.get(pair1.comp);
                    CompPreferences c2 = companies.get(pair2.comp);
                    if((p1.indexOfPreference(c2.selfChar) < p1.indexOfPreference(c1.selfChar))
                    && (c2.indexOfPreference(p1.selfInt) < c2.indexOfPreference(p2.selfInt))) {

	                    System.out.println(pair1.toString() + pair2.toString());
                        return false;
                    }
				}
			}
        }
        return true;
	}
}
