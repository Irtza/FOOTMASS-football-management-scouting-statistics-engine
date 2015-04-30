package ui_package;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

import footy.Controller_footmass;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ui_for_footmassadmin_deletePlayer {

	private JFrame frmDeletePlayer;
	private JTextField textField;

	String name_ui;
	String club_ui;
	
	private JButton btnBack;
	private JTextField textField_1;
	
	//ui_for_footmassadmin_deletePlayer window = new ui_for_footmassadmin_deletePlayer();
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize()
	{
		final Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		frmDeletePlayer = new JFrame();
		frmDeletePlayer.setVisible(true);
		frmDeletePlayer.setTitle("Delete Player ");
		frmDeletePlayer.setResizable(false);
		frmDeletePlayer.setBounds(100, 100, 450, 300);
		frmDeletePlayer.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeletePlayer.getContentPane().setLayout(null);
		
		JLabel lblEnter = new JLabel("Enter the Player name :");
		lblEnter.setBounds(88, 84, 120, 14);
		frmDeletePlayer.getContentPane().add(lblEnter);
		
		textField = new JTextField();
		textField.setBounds(209, 81, 86, 20);
		frmDeletePlayer.getContentPane().add(textField);
		textField.setColumns(10);
		
		JButton btnDelete = new JButton("Delete");
		btnDelete.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				club_ui = textField_1.getText();
				name_ui = textField.getText();			//take input in variable
				controllerobj.delete_player(name_ui,club_ui);	//place controller call
			}
		});
		btnDelete.setBounds(222, 143, 73, 23);
		frmDeletePlayer.getContentPane().add(btnDelete);
		
		btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmDeletePlayer.setVisible(false);
				ui_for_footmassAdmin window = new ui_for_footmassAdmin();
				window.initialize();
			}
		});
		btnBack.setBounds(139, 143, 73, 23);
		frmDeletePlayer.getContentPane().add(btnBack);
		
		textField_1 = new JTextField();
		textField_1.setBounds(209, 112, 86, 20);
		frmDeletePlayer.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblEnterTheClub = new JLabel("Enter Player Club :");
		lblEnterTheClub.setBounds(88, 115, 120, 14);
		frmDeletePlayer.getContentPane().add(lblEnterTheClub);
	}
}