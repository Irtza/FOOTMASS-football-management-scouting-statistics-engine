package ui_package;


import javax.swing.JFrame;

import footy.Controller_footmass;
import footy.Transfer_Request;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;

public class ui_for_TeamManager_manageTransfers_sell {

	private JFrame frmPlaceOutgoingTransfer;
	private JTextField textFieldname;
	private JTextField textField;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(String tempname, String tempclub) 
	{
		
		Controller_footmass controllerobj = Controller_footmass.getInstance();


		
		frmPlaceOutgoingTransfer = new JFrame();
		frmPlaceOutgoingTransfer.setTitle("Place Outgoing Transfer Request");
		frmPlaceOutgoingTransfer.setVisible(true);
		frmPlaceOutgoingTransfer.setBounds(100, 100, 450, 200);
		frmPlaceOutgoingTransfer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlaceOutgoingTransfer.getContentPane().setLayout(null);
		
		JLabel lblName = new JLabel("Player Name :");
		lblName.setBounds(117, 62, 74, 14);
		frmPlaceOutgoingTransfer.getContentPane().add(lblName);
		
		JLabel lblPlayerClub = new JLabel("Player Club :");
		lblPlayerClub.setBounds(117, 87, 74, 14);
		frmPlaceOutgoingTransfer.getContentPane().add(lblPlayerClub);
		
		textFieldname = new JTextField();
		textFieldname.setBounds(201, 59, 86, 20);
		frmPlaceOutgoingTransfer.getContentPane().add(textFieldname);
		textFieldname.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(201, 84, 86, 20);
		frmPlaceOutgoingTransfer.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField.setText("Unspecified");
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//manager's club is sent as he can only send request of his players
				controllerobj.add_transfer_req(controllerobj.getplayer(textFieldname.getText(), tempclub),"Sell", textField.getText());
				JOptionPane.showMessageDialog(null, "Transfer request placed ! ");
			}
		});
		btnSubmit.setBounds(201, 115, 89, 23);
		frmPlaceOutgoingTransfer.getContentPane().add(btnSubmit);
		
		
	}
}
