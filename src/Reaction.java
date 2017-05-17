
public class Reaction {
	String type;
	String reactionData;
	public Reaction(String name, String data){
		type = name;
		reactionData = data;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public String getReactionData() {
		return reactionData;
	}
	public void setReactionData(String reactionData) {
		this.reactionData = reactionData;
	}
	
}
