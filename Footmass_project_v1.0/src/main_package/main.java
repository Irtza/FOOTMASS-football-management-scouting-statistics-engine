package main_package;
import ui_package.footmass;
import footy.*;

public class main {

	public static void main(String[] args)
	{
		Controller_footmass controllerobj = Controller_footmass.getInstance();
		controllerobj.startup();
		
		footmass GUI = new footmass(); 
		GUI.initialize();
		
		//controllerobj.save_all();
		System.out.println("===============Debugging GUI================");
		
	}
}	