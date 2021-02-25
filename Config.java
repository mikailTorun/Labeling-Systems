import java.util.ArrayList;
import java.util.Iterator;
import org.json.simple.JSONArray;
import org.json.simple.JSONObject;

public class Config {
	private ArrayList<User> randomUsers = new ArrayList<User>();
	private ArrayList<User> realUsers = new ArrayList<User>();
	private int currentDatasetID;

	@SuppressWarnings({ "unchecked" })
	public Config() {
		JSONObject config = new JsonProcess().getJSONFile("config.json");//getJSONFile("config.json");
		JSONArray dataset = (JSONArray)config.get("dataset");
		JSONArray user = (JSONArray)config.get("users");

		Iterator<JSONObject> iter1 = user.iterator(), iter2 = user.iterator(), iter3 = user.iterator(), iter4 = user.iterator(),
									iter5 = user.iterator(), iter6 = user.iterator(), iter7;

		ArrayList<Dataset> datasets;
		for(int i = 0; i < user.size(); i++) {
			iter7 = dataset.iterator();

			if(iter1.next().get("userType").toString().equals("RandomBot")) {
				datasets = new ArrayList<Dataset>();
				for(int j = 0; j < dataset.size(); j++)
					datasets.add(new Dataset(iter7.next().get("path").toString()));

				randomUsers.add(new User(Integer.parseInt(iter2.next().get("userID").toString()),
								iter3.next().get("username").toString(),
								iter4.next().get("userType").toString(),
								iter5.next().get("password").toString(),
								Double.parseDouble(iter6.next().get("consistencyCheckProbability").toString()),
								datasets));
			} else {
				datasets = new ArrayList<Dataset>();
				for(int j = 0; j < dataset.size(); j++)
					datasets.add(new Dataset(iter7.next().get("path").toString()));
				realUsers.add(new User(Integer.parseInt(iter2.next().get("userID").toString()),
						iter3.next().get("username").toString(),
						iter4.next().get("userType").toString(),
						iter5.next().get("password").toString(),
						Double.parseDouble(iter6.next().get("consistencyCheckProbability").toString()),
						datasets));
			}
		}

		currentDatasetID = Integer.parseInt(config.get("currentDatasetID").toString());
	}
	public User getRealUser(int id) {
		return realUsers.get(id - 1);
	}

	public int getRealUserSize() {
		return realUsers.size();
	}

	public User getRandomUser(int id) {
		return randomUsers.get(id - 1);
	}

	public int getRandomUserSize() {
		return randomUsers.size();
	}

	public int getCurrentDatasetID() {
		return currentDatasetID;
	}
}