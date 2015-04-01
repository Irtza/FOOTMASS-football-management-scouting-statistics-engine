package footy;
import java.util.ArrayList;
import java.util.Iterator;

public class Transfer_Request_Register {

	ArrayList<Transfer_Request> transfer_reg = new ArrayList<Transfer_Request>(); 

	public void add_transfer_req(Player ptbtobj , String type, String targetclub) //ENCAPSULATES PLAYER into a Transfer_REQUEST
	{
		Transfer_Request request =  new Transfer_Request();
		request.name_player=ptbtobj.name_player;
		request.club_player=ptbtobj.club_player;
		request.age_player=ptbtobj.age_player;
		request.position_player=ptbtobj.position_player;

		request.type=type;
		request.targetclub=targetclub;

		transfer_reg.add(request);

		System.out.println("Transfer request has been added to the transfer request register");
		System.out.println("Player :" + request.name_player + " Club :" + request.club_player + " Age :" + request.age_player+ " pos :" + request.position_player + "targetclub:" + request.targetclub + "type:" + request.type +" has been added successfully");		
	}

	public ArrayList<Transfer_Request> get_transfer_requests_unspecified()   //will throw null exception
	{
		ArrayList<Transfer_Request> marketplacelist = new ArrayList<Transfer_Request>();
		Iterator<Transfer_Request> it = transfer_reg.iterator();

		while(it.hasNext())
		{
			Transfer_Request searchobj = it.next();

			if(searchobj.getTargetclub() == "Unspecified")
			{
				marketplacelist.add(searchobj);
				System.out.println("Unspecified club request added");
				System.out.println("Transfering player name :" + searchobj.getName_player());
			}
		}
		if (transfer_reg.isEmpty())
		{
			System.out.println("Transfer Request register is empty");	//will throw NULL exception
		}
		return marketplacelist;
	}

	public Transfer_Request get_transfer_req_for_a_player(String name_player)		//will throw null exceptions
	{
		boolean check = false;
		Iterator<Transfer_Request> it = transfer_reg.iterator();

		
		while(it.hasNext())
		{
			Transfer_Request searchobj = it.next();
			if (searchobj.getName_player().equals(name_player))
			{
				check = true;
				System.out.println("Match found");
				return searchobj;
			}		
			else
				check = false;
		}

		if (check == false)
		{
			System.out.println("Transfer Request not found");
			return null;
		}

		return null;
	}

	public ArrayList<Transfer_Request> get_transfer_req(String club_manager)//this gives you the inbox		//will throw null exceptions
	{
		ArrayList<Transfer_Request> inbox = new ArrayList<Transfer_Request>();
		Iterator<Transfer_Request> it = transfer_reg.iterator();

		while(it.hasNext())
		{
			Transfer_Request searchobj = it.next();
			if (searchobj.getTargetclub().equals(club_manager))
			{
				inbox.add(searchobj);
				System.out.println("Inbox of Manager: " + club_manager +" has an incoming transfer! player name:" + searchobj.getName_player() + " from club : " + searchobj.getClub_player());
			}
		}
		if (transfer_reg.isEmpty())
		{
			System.out.println("This in not a transfer period");
		}
		if (inbox.isEmpty())
		{
			System.out.println("Inbox is empty");	
		}
		return inbox;
	}

	public boolean delete_transfer_req(String name_player , String club_player)
	{
		boolean check = true;
		Iterator<Transfer_Request> it = transfer_reg.iterator();

		while (it.hasNext())
		{
			Transfer_Request delobj = it.next();

			if (delobj.getName_player().equals(name_player) && delobj.getClub_player().equals(club_player))
			{
				it.remove();
				System.out.println("Player : " + name_player + " Transfer request is Deleted!");
				check = true;
				return true;
			}
			else
				check = false; 
		}

		if (check == false)
			System.out.println("Player : " + name_player + " is not in the transfer list");

		return false;
	}
}
