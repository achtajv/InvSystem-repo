import java.awt.Image;
import java.util.HashMap;

public class DataStorage {
	
	//static to be updated by other class like putting and removing
	private static HashMap<String, String> logInfo = new HashMap<>();
	private static HashMap<String, Image> inventoryDetails = new HashMap<>();
	
	//return the logInfo | Getter
	public HashMap<String, String> getPeopleInfo() {
        return logInfo;
	}
	
	//Setter logInfo
	public void setPeopleInfo(HashMap<String, String> newInfo) {
		DataStorage.logInfo = newInfo; //substitute for this.logInfo
	}
	
	//<===============================================================>
	
	//Getter inventoryDetails
	public HashMap<String, Image> getInvDetailsInfo() {
        return inventoryDetails;
	}
	
	//Setter inventoryDetails
	public void setInvDetailsInfo(HashMap<String, Image> newInfo) {
		DataStorage.inventoryDetails = newInfo; //substitute for this.logInfo
	}
	
	
	
	
	
}
