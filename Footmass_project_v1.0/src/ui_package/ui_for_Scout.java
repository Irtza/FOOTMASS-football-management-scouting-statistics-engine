package ui_package;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import footy.Controller_footmass;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import java.awt.Color;
import java.awt.Font;

public class ui_for_Scout {

	private JFrame frmScout;
	String tempname;
	String tempclub;
	/**
	 * @wbp.parser.entryPoint
	 */
	
	public void initialize(String usr, String pass) {
		
		final Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		tempclub = controllerobj.getscout(usr, pass).getClub_affiliation(); 
		tempname = controllerobj.getscout(usr, pass).getName_scout();
		
		frmScout = new JFrame();
		frmScout.setTitle("Scout's Portal");
		frmScout.setVisible(true);
		frmScout.setBounds(100, 100, 838, 516);
		frmScout.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScout.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Scout for Players");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ui_for_Scout_ScoutPlayers window = new ui_for_Scout_ScoutPlayers();
				window.initialize();
				
			}
		});
		
		JButton btnSetUpOr = new JButton("Set up or change Password");
		btnSetUpOr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String newusr = JOptionPane.showInputDialog(frmScout,"Please Enter your New Username : ","Enter Username");
				String newpass = JOptionPane.showInputDialog(frmScout,"Please Enter your New Password : ","Enter Password");
				controllerobj.edit_my_account_manager(tempname, tempclub, newusr, newpass);
			}
		});
		btnSetUpOr.setBounds(474, 149, 209, 23);
		frmScout.getContentPane().add(btnSetUpOr);
		btnNewButton.setBounds(474, 102, 209, 23);
		frmScout.getContentPane().add(btnNewButton);
		
		JLabel lblNewLabel = new JLabel("Welcome Scout! This Looks like a good day to find a star!");
		lblNewLabel.setForeground(Color.WHITE);
		lblNewLabel.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNewLabel.setBounds(162, 0, 473, 23);
		frmScout.getContentPane().add(lblNewLabel);
		
		JLabel label = new JLabel("");
		label.setForeground(Color.BLACK);
		label.setBounds(0, 0, 824, 477);
		frmScout.getContentPane().add(label);
		
		label.setIcon(new ImageIcon(".\\data\\images\\scoutback.jpg"));
	}
}
