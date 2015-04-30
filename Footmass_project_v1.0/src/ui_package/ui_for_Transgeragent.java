package ui_package;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;
import javax.swing.JTextField;

import footy.Controller_footmass;
import footy.Transfer_Request;

import javax.swing.JTextArea;
import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.util.Iterator;
import java.awt.Color;
import java.awt.Font;
import javax.swing.ImageIcon;

public class ui_for_Transgeragent 
{
	private JFrame frame;
	private JTextField textField;
	private JTextField textField_1;
	String tempname;
	String tempclub;
	private JTextField textField_chosenplayer;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(String username , String password) {
		
		final Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		frame = new JFrame();
		frame.getContentPane().setBackground(Color.WHITE);
		frame.setBounds(100, 100, 738, 482);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		frame.setVisible(true);
		
		tempname=controllerobj.gettransferagent(username, password).getName_transferAgent();
		tempclub=controllerobj.gettransferagent(username, password).getClub_affiliation();
		
		
		JLabel lblTransferAgent = new JLabel("Transfer Agent :");
		lblTransferAgent.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblTransferAgent.setForeground(Color.BLACK);
		lblTransferAgent.setBounds(10, 11, 143, 14);
		frame.getContentPane().add(lblTransferAgent);
		
		JLabel lblClub = new JLabel("Club :");
		lblClub.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblClub.setForeground(Color.BLACK);
		lblClub.setBounds(10, 36, 143, 14);
		frame.getContentPane().add(lblClub);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(145, 8, 143, 20);
		frame.getContentPane().add(textField);
		textField.setColumns(10);
	
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(145, 36, 143, 20);
		frame.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		textField.setText(tempname);
		textField_1.setText(tempclub);
		
		JTextArea textArea = new JTextArea();
		textArea.setEditable(false);
		textArea.setBounds(107, 134, 519, 94);
		frame.getContentPane().add(textArea);
		
		JLabel lblChooseThePlayer = new JLabel("Choose the Player name from the above list :");
		lblChooseThePlayer.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblChooseThePlayer.setForeground(Color.WHITE);
		lblChooseThePlayer.setBounds(35, 290, 320, 14);
		frame.getContentPane().add(lblChooseThePlayer);
		
		textField_chosenplayer = new JTextField();
		textField_chosenplayer.setBounds(365, 287, 109, 20);
		frame.getContentPane().add(textField_chosenplayer);
		textField_chosenplayer.setColumns(10);
		
		JButton btnNewButton = new JButton("Process Transfer Request");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
			
				if (textField_chosenplayer.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please Enter the name of the Player","Re-Enter Name",JOptionPane.ERROR_MESSAGE);
				}
				else
				{
				System.out.println(textField_chosenplayer.getText());
				controllerobj.transferplayer(textField_chosenplayer.getText(),controllerobj.get_transfer_req_for_a_player(textField_chosenplayer.getText()).getClub_player() ,controllerobj.get_transfer_req_for_a_player(textField_chosenplayer.getText()).getTargetclub());
				JOptionPane.showMessageDialog(null, "Transfer Process Completed ! ","Transfer complete",JOptionPane.INFORMATION_MESSAGE);
				controllerobj.delete_transfer_req(textField_chosenplayer.getText(),  controllerobj.get_transfer_req_for_a_player(textField_chosenplayer.getText()).getClub_player() );
				System.out.println("Delete transfer request");
				}
			}
		});
		btnNewButton.setBounds(247, 369, 284, 23);
		frame.getContentPane().add(btnNewButton);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(".\\data\\images\\agent.jpg"));
		label.setBounds(0, 0, 722, 458);
		frame.getContentPane().add(label);
		
		//list iterate Transfer_request_register match Player.targetclub == manager.clubaffiliation\
		
		boolean check = true;
		Iterator<Transfer_Request> it = controllerobj.get_transfer_req(tempclub).iterator();
		
		while (it.hasNext())
		{
			Transfer_Request transferreqobj = it.next();

			if (transferreqobj.getTargetclub().equals(tempclub))		//shows if trnasfers are directed or now
			{
				//check if its working
				textArea.append(transferreqobj.getClub_player() +" wants to " +transferreqobj.getType() +" "+ transferreqobj.getName_player() );
				check = true;
			}
			else
			{
				
				check = false;
			}
		}
		if (check == false)
			JOptionPane.showMessageDialog(frame, "No Incoming Transfer Requests for you", "Inbox empty",JOptionPane.INFORMATION_MESSAGE);

	}
}
