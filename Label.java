
public class Label {
	private int labelID;
	private String labelText;
	
	public Label(int labelID, String labelText){
		this.labelID = labelID;
		this.labelText = labelText;
	}

	public int getLabelID() {
		return labelID;
	}

	public void setLabelID(int labelID) {
		this.labelID = labelID;
	}

	public String getLabelText() {
		return labelText;
	}

	public void setLabelText(String labelText) {
		this.labelText = labelText;
	}
}