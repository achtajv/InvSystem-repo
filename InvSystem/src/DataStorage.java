import java.util.HashMap;

public class DataStorage {
	
	//static to be updated by other class like putting and removing
	private static HashMap<String, String> logInfo = new HashMap<>();
	
	//return the logInfo | Getter
	public HashMap<String, String> getPeopleInfo() {
        return logInfo;
	}
	
	//Setter
	public void setPeopleInfo(HashMap<String, String> newInfo) {
		DataStorage.logInfo = newInfo; //substitute for this.logInfo
	}
	
}
