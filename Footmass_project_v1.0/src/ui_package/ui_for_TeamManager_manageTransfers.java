package ui_package;

import javax.swing.JFrame;
import footy.Controller_footmass;
import footy.Transfer_Request;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

import javax.swing.JLabel;

import javax.swing.JTextArea;
import javax.swing.UIManager;
import java.awt.Color;
import java.awt.Font;

public class ui_for_TeamManager_manageTransfers {

	private JFrame frmManageTransfers;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize( final String tempname,final String tempclub) {
		
		Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		frmManageTransfers = new JFrame();
		frmManageTransfers.getContentPane().setBackground(Color.DARK_GRAY);
		frmManageTransfers.setTitle("Manage transfers");
		frmManageTransfers.setVisible(true);
		frmManageTransfers.setBounds(100, 100, 601, 500);
		frmManageTransfers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmManageTransfers.getContentPane().setLayout(null);
		
		JButton btnsell = new JButton("Sell a player");
		btnsell.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmManageTransfers.setVisible(false);
				ui_for_TeamManager_manageTransfers_sell window = new ui_for_TeamManager_manageTransfers_sell();
				window.initialize(tempname,tempclub);
			}
		});
		btnsell.setBounds(67, 108, 224, 23);
		frmManageTransfers.getContentPane().add(btnsell);
		
		JButton btnsign = new JButton("Sign a player");
		btnsign.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmManageTransfers.setVisible(false);
				ui_for_TeamManager_managerTransfers_sign window = new ui_for_TeamManager_managerTransfers_sign();
				window.initialize(tempname,tempclub);
			}
		});
		btnsign.setBounds(67, 142, 224, 23);
		frmManageTransfers.getContentPane().add(btnsign);
		
		JButton btnViewIncomingTransfer = new JButton("View Incoming Transfer Requests");
		btnViewIncomingTransfer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmManageTransfers.setVisible(false);
				ui_for_TeamManager_manageTransfers_inbox window = new ui_for_TeamManager_manageTransfers_inbox();
				window.initialize(tempname,tempclub);
			}
		});
		btnViewIncomingTransfer.setBounds(67, 176, 224, 23);
		frmManageTransfers.getContentPane().add(btnViewIncomingTransfer);
		
		JLabel lblTransferMarketPlace = new JLabel("Transfer Market News ");
		lblTransferMarketPlace.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTransferMarketPlace.setForeground(Color.WHITE);
		lblTransferMarketPlace.setBounds(310, 33, 148, 14);
		frmManageTransfers.getContentPane().add(lblTransferMarketPlace);
		
		JTextArea textArea = new JTextArea();
		textArea.setBackground(UIManager.getColor("TextArea.disabledBackground"));
		textArea.setEditable(false);
		textArea.setBounds(310, 58, 264, 392);
		frmManageTransfers.getContentPane().add(textArea);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmManageTransfers.setVisible(false);
				footmass GUI = new footmass();
				GUI.initialize();
		
			}
		});
		btnNewButton.setBounds(10, 427, 89, 23);
		frmManageTransfers.getContentPane().add(btnNewButton);
		
		boolean check = false;
		Iterator<Transfer_Request> it = controllerobj.get_transfer_requests_unspecified().iterator();
		
		while (it.hasNext())
		{
			Transfer_Request transferreqobj = it.next();
			//check if its working			
			textArea.append(transferreqobj.getClub_player() +" wants to " +transferreqobj.getType() +" "+ transferreqobj.getName_player() );
			check = true;
		}
		if (check == false)
			System.out.println("Empty Transfer market");

	}
}
