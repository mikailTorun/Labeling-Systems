import java.util.ArrayList;

public class Consistency {
	private String percentage;

	public Consistency(ArrayList<Label> listA, ArrayList<Label> listB) {
		double max = Math.max(listA.size(), listB.size());
		int counter = 0;
		
		for(Label labelA : listA) {
			for(Label labelB : listB) {
				if(labelA.getLabelID() == labelB.getLabelID() && labelA.getLabelText().equals(labelB.getLabelText()))
					counter++;
				
			}
		}

		percentage = String.valueOf((int)((counter / max) * 100));
	}
	
	public String getPercentage() {
		return percentage + "%";
	}
}
