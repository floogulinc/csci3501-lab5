package csci3501.lab5;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

public class Matcher {
    private ArrayList<CompPreferences> compsPreferences;
    private ArrayList<ProgPreferences> progsPreferences;
    
    private List<CompPreferences> companiesOriginal;
	private List<ProgPreferences> programmersOriginal;

    private ArrayList<PreferencePair> matchedPairs = new ArrayList<>();
    private int N = 0;

    public Matcher(List<CompPreferences> compsPreferences, List<ProgPreferences> progsPreferences) {
        this.compsPreferences = new ArrayList<>(compsPreferences);
        this.progsPreferences = new ArrayList<>(progsPreferences);
        this.companiesOriginal = compsPreferences;
        this.programmersOriginal = progsPreferences;

        N = Math.max(compsPreferences.size(), progsPreferences.size());
    }

	public ArrayList<PreferencePair> match() {
        int maxLevel = N;
		for (int lower = 0; lower < maxLevel; ++lower) {
			for (int i = 0; i < lower; ++i) {
				findPairs(i, lower);
				findPairs(lower, i);
			}
			findPairs(lower, lower);
        }
        return matchedPairs;
	}

	private void findPairs(int compLevel, int progLevel) {
		for (Iterator<CompPreferences> compIterator = compsPreferences.iterator(); compIterator.hasNext();) {
			CompPreferences compPs = compIterator.next();

			for (Iterator<ProgPreferences> progIterator = progsPreferences.iterator(); progIterator.hasNext();) {
				ProgPreferences progPs = progIterator.next();

				if (compPs.maxLevel > compLevel && progPs.maxLevel > progLevel
						&& areMatched(compPs, compLevel, progPs, progLevel)) {

					matchedPairs.add(new PreferencePair(
							compPs.preference(compLevel), progPs.preference(progLevel)));

					compIterator.remove();
					progIterator.remove();
				}
			}
		}
	}

	private boolean areMatched(CompPreferences company, int compLevel,
	                                  ProgPreferences programmer, int progLevel) {

		return company.preference(compLevel) == programmer.selfInt &&
				programmer.preference(progLevel) == company.selfChar;
    }
    
    public  boolean isSatisfactory() {
        Map<Character, CompPreferences> companies = companiesOriginal.stream().collect(Collectors.toMap(i -> i.selfChar, i -> i));
        Map<Integer, ProgPreferences> programmers = programmersOriginal.stream().collect(Collectors.toMap(i -> i.selfInt, i -> i));
		

		for(PreferencePair pair1 : matchedPairs) {
			for(PreferencePair pair2 : matchedPairs) {
				if(!(pair1.equals(pair2))){
                    ProgPreferences p1 = programmers.get(pair1.prog);
                    ProgPreferences p2 = programmers.get(pair2.prog);
                    CompPreferences c1 = companies.get(pair1.comp);
                    CompPreferences c2 = companies.get(pair2.comp);
                    if((p1.indexOfPreference(c2.selfChar) < p1.indexOfPreference(c1.selfChar)) 
                    && (c2.indexOfPreference(p1.selfInt) < c2.indexOfPreference(p2.selfInt))) {
                        return false;
                    }
				}
			}
        }
        return true;
	}
}