import java.util.ArrayList;

public class User {
	private int userID;
	private String userName;
	private String userType;
	private String password;
	private ArrayList<Dataset> datasets = new ArrayList<Dataset>();
	private double ccp;
	
	public User(int userID, String userName, String userType, String password, double ccp, ArrayList<Dataset> datasets){
		this.userID = userID;
		this.userName = userName;
		this.userType = userType;
		this.password = password;
		this.ccp = ccp;
		this.datasets = datasets;
	}
	
	public Dataset getDataset(int id) {
		return datasets.get(id - 1);
	}
	
	public int getDatasetSize() {
		return datasets.size();
	}
	
	public int getUserID() {
		return userID;
	}
	
	public String getUserName() {
		return userName;
	}
	
	public String getUserType() {
		return userType;
	}
	
	public String getPassword() {
		return password;
	}
	
	public double getCCP() {
		return ccp;
	}
}