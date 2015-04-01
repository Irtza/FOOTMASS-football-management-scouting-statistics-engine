package footy;

public class Transfer_Request extends Player
{
	String targetclub;
	String type;
	
	
	public Transfer_Request()
	{
		//CONSTRUCTOR	
		targetclub = null;
		type = null;
	}
	public Transfer_Request(String targetclub_arg, String type_arg)
	{
		// Parameterized CONSTRUCTOR	
		this.targetclub = targetclub_arg;
		this.type = type_arg;
	}
	public String getTargetclub() {
		return targetclub;
	}
	public void setTargetclub(String targetclub) {
		this.targetclub = targetclub;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	
	////
	////
	
}