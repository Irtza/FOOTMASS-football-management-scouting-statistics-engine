package ui_package;

import javax.swing.JFrame;

import footy.Controller_footmass;
import footy.Transfer_Request;

import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.Font;
import java.util.Iterator;

import javax.swing.UIManager;

import actors.Team_Manager;
import javax.swing.JLabel;
import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ui_for_TeamManager_manageTransfers_inbox {

	private JFrame frmIncomingTransferRequests;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(final String tempname, final String tempclub) 
	{
		Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		frmIncomingTransferRequests = new JFrame();
		frmIncomingTransferRequests.getContentPane().setBackground(Color.DARK_GRAY);
		frmIncomingTransferRequests.setResizable(false);
		frmIncomingTransferRequests.setVisible(true);
		frmIncomingTransferRequests.setTitle("View Incoming Transfer Requests");
		frmIncomingTransferRequests.setBounds(100, 100, 500, 500);
		frmIncomingTransferRequests.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmIncomingTransferRequests.getContentPane().setLayout(null);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("TextArea.disabledBackground"));
		textArea.setFont(new Font("Arial", Font.PLAIN, 15));
		textArea.setRows(20);
		textArea.setEditable(false);
		textArea.setBounds(150, 39, 269, 383);
		frmIncomingTransferRequests.getContentPane().add(textArea);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmIncomingTransferRequests.setVisible(false);
				ui_for_TeamManager_manageTransfers window2= new ui_for_TeamManager_manageTransfers();
				window2.initialize(tempname, tempclub);
			}
		});
		btnBack.setBounds(10, 427, 89, 23);
		frmIncomingTransferRequests.getContentPane().add(btnBack);
		
		//list iterate Transfer_request_register match Player.targetclub == manager.clubaffiliation\
		
		boolean check = true;
		Iterator<Transfer_Request> it = controllerobj.get_transfer_req(tempclub).iterator();
		
		while (it.hasNext())
		{
			Transfer_Request transferreqobj = it.next();

			if (transferreqobj.getTargetclub().equals(tempclub))
			{
				//check if its working
				textArea.append(transferreqobj.getClub_player() +" wants to " +transferreqobj.getType() +" "+ transferreqobj.getName_player() );
				check = true;
			}
			else
			{
				System.out.println("elsesssss");
				check = false;
			}
		}
		if (check == false)
			JOptionPane.showMessageDialog(null, "No Incoming Transfer Requests for you", "Inbox empty",JOptionPane.INFORMATION_MESSAGE);
	}
}