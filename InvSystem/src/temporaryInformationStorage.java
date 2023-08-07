import java.util.HashMap;

public class temporaryInformationStorage {

	private HashMap<String, String> loginInformation = new HashMap<>();
	
	// Getter
	public HashMap<String, String> getKey() {
	    return loginInformation;
	}

	// Setter
	public void setName(HashMap<String, String> userInput) {
	    this.loginInformation = userInput;
	}
	
}
