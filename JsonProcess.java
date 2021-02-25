import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class JsonProcess {

	int i = 1;
	@SuppressWarnings("unchecked")
	public void addListToJSON(ArrayList<JSONObject> e ,JSONObject mainJson){
		for(JSONObject o :e){
			mainJson.put(i, o);
			i++;
		}
		writeToJsonFile(mainJson);
	}

	public void writeToJsonFile(JSONObject obj){
    	FileWriter file = null;
    	try {
        	file = new FileWriter("OutputJSON.json");
            file.write(obj.toJSONString());
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                file.flush();
                file.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
	public JSONObject getJSONFile(String path) {
		JSONParser parser = new JSONParser();
		JSONObject jsonObject = null;

		try {
			Object obj = parser.parse(new FileReader(path));
			jsonObject = (JSONObject) obj;
		} catch (Exception e) {
			System.out.println(e);
		}
		return jsonObject;
	}
}
