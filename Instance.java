import java.util.ArrayList;

public class Instance {
	private int instanceID;
	private String instanceText;
	private boolean isLabeled;
	private ArrayList<Label> assignedLabels = new ArrayList<Label>();
	
	public Instance(int instanceID, String instanceText, boolean isLabeled){
		this.instanceID = instanceID;
		this.instanceText = instanceText;
		this.isLabeled = isLabeled;
	}

	public int getInstanceID() {
		return instanceID;
	}

	public String getInstanceText() {
		return instanceText;
	}
	
	public Label getAssignedLabel(int id) {
		return assignedLabels.get(id - 1);
	}
	
	public int getAssignedLabelSize() {
		return assignedLabels.size();
	}
	
	public void clearAssignedLabel() {
		assignedLabels.clear();
	}
	
	public void addAssignedLabel(Label label) {
		assignedLabels.add(label);
	}
	
	public boolean getIsLabeled() {
		return isLabeled;
	}
	
	public void setIsLabeled(boolean isLabeled) {
		this.isLabeled = isLabeled;
	}
}
