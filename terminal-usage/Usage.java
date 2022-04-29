package pa0;
// One user's record on one line: how many times
// this user has been seen on this line
public class Usage {
	private final String username;		// username
	private int count;					// number of appearances

	// constructor
	public Usage(String username, int count) {
		this.username = username;
		this.count = count;
	}
	// setter for count not needed
	
	// get username
	public String getUser() {
		return this.username;
	}
    // get count
	public int getCount() {
		return this.count;
	}
}
