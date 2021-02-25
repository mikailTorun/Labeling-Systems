import java.util.*;
import org.json.simple.*;
public class Dataset {
	private int datasetID;
	private String datasetName;
	private int maxNumLabsPerIns;
	private ArrayList<Label> labels = new ArrayList<Label>();
	private ArrayList<Instance> instances = new ArrayList<Instance>();

	public Dataset(String path) {
		JSONObject jsonVal = new JsonProcess().getJSONFile(path);
		datasetID = Integer.parseInt(jsonVal.get("dataset id").toString());
		datasetName = jsonVal.get("dataset name").toString();
		maxNumLabsPerIns = Integer.parseInt(jsonVal.get("maximum number of labels per instance").toString());
		getLabels(jsonVal, labels);
		getInstances(jsonVal, instances);
	}

	@SuppressWarnings("unchecked")
	private void getLabels(JSONObject jsonObject, ArrayList<Label> arListLab) {
		JSONArray indexInJSON = (JSONArray) jsonObject.get("class labels");

		Iterator<JSONObject> iteratorForLabelID = indexInJSON.iterator();
		Iterator<JSONObject> iteratorForLabelText = indexInJSON.iterator();

		for (int i = 0; i < indexInJSON.size(); i++) {
			arListLab.add(new Label(Integer.parseInt(iteratorForLabelID.next().get("label id").toString()),
					iteratorForLabelText.next().get("label text").toString()));
		}
	}

	@SuppressWarnings("unchecked")
	private void getInstances(JSONObject jsonObject, ArrayList<Instance> instances) {
		JSONArray indexInJSON = (JSONArray) jsonObject.get("instances");

		Iterator<JSONObject> iteratorForinstanceText = indexInJSON.iterator();
		Iterator<JSONObject> iteratorForinstanceID = indexInJSON.iterator();

		for (int i = 0; i < indexInJSON.size(); i++) {
			instances.add(new Instance(Integer.parseInt(iteratorForinstanceID.next().get("id").toString()),
					iteratorForinstanceText.next().get("instance").toString(), false));
		}
	}

	public int getDatasetID() {
		return datasetID;
	}

	public String getDatasetName() {
		return datasetName;
	}

	public int getMaxNumLabsPerIns() {
		return maxNumLabsPerIns;
	}

	public Label getLabel(int id) {
		return labels.get(id - 1);
	}

	public int getLabelSize() {
		return labels.size();
	}

	public Instance getInstance(int id) {
		return instances.get(id - 1);
	}

	public int getInstanceSize() {
		return instances.size();
	}
}