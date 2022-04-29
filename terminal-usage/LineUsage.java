package pa0;

import java.util.HashMap;

// LineUsageData.java: Handle one line's data, using a Map
public class LineUsage {
	private HashMap<String, Integer> usageData;		// HashMap to store terminal usage data

	// Constructor
	public LineUsage() {		
		usageData = new HashMap<String, Integer>();
	}

	// add one sighting of a user on this line
	public void addObservation(String username) {
		int count = 0;
		// if this user already exists in the map, increase the count
		if (usageData.containsKey(username)) {
			usageData.put(username, usageData.get(username) + 1);
			count = usageData.get(username) + 1;
		// if this user does not yet exist in the map, add their username and set count to 1
		} else {
			count = 1;
			usageData.put(username, count);
		}
	}

	// find the user with the most sightings on this line
	public Usage findMaxUsage() {
		// start at zero and keep track of the highest log in count from a single user
	    int maxCount = 0;
        String maxUser = "<NONE>";
        // creates a set of user log in data from the usageData HashMap
        // and iterates through each entry in the map in order to find maxUser
        for (String entry : usageData.keySet()) {
            if (usageData.get(entry) > maxCount) {
                maxCount = usageData.get(entry);
                maxUser = entry;
            }
        }
        return new Usage(maxUser, maxCount);
	}
}
