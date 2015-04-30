package ui_package;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import footy.Controller_footmass;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ui_for_TeamManager_managerTransfers_sign {

	private JFrame frmPlaceIncomingTransfer;
	private JTextField textField;
	private JTextField textField_1;
	
	/**
	 * Initialize the contents of the frame.
	 * @wbp.parser.entryPoint
	 */
	public void initialize( String tempname, String tempclub) 
	{
		final Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		frmPlaceIncomingTransfer = new JFrame();
		frmPlaceIncomingTransfer.setTitle("Place Incoming Transfer Request");
		frmPlaceIncomingTransfer.setVisible(true);
		frmPlaceIncomingTransfer.setBounds(100, 100, 450, 300);
		frmPlaceIncomingTransfer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmPlaceIncomingTransfer.getContentPane().setLayout(null);
		
		JLabel lblPlayerName = new JLabel("Player Name :");
		lblPlayerName.setBounds(90, 63, 85, 14);
		frmPlaceIncomingTransfer.getContentPane().add(lblPlayerName);
		
		JLabel lblPlayerClub = new JLabel("Player Club :");
		lblPlayerClub.setBounds(90, 87, 67, 14);
		frmPlaceIncomingTransfer.getContentPane().add(lblPlayerClub);
		
		textField = new JTextField();
		textField.setBounds(175, 60, 86, 20);
		frmPlaceIncomingTransfer.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(175, 84, 86, 20);
		frmPlaceIncomingTransfer.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				//manager's club is sent as he can only send request of his players
				controllerobj.add_transfer_req(controllerobj.getplayer(textField.getText(), textField_1.getText()),"Sign", textField.getText());
				JOptionPane.showMessageDialog(null, "Transfer request placed ! ");
			}
		});
		btnSubmit.setBounds(175, 124, 89, 23);
		frmPlaceIncomingTransfer.getContentPane().add(btnSubmit);
	}

}
