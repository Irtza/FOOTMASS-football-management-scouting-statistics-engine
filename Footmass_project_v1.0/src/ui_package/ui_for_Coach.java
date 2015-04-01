package ui_package;

import javax.swing.JFrame;
import javax.swing.JOptionPane;

import footy.Controller_footmass;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;

public class ui_for_Coach {

	private JFrame frmCoachsPortal;
	/**
	 * @param pass 
	 * @param usr 
	 * @wbp.parser.entryPoint
	 */
	public void initialize(String usr, String pass) {
		
		Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		frmCoachsPortal = new JFrame();
		frmCoachsPortal.setTitle("Coach's Portal");
		frmCoachsPortal.setVisible(true);
		frmCoachsPortal.setBounds(100, 100, 519, 371);
		frmCoachsPortal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmCoachsPortal.getContentPane().setLayout(null);
		
		String tempclub = controllerobj.getcoach_acc(usr, pass).getClub_affiliation(); 
		String tempname = controllerobj.getcoach_acc(usr, pass).getName_coach();
		
		JButton btnNewButton = new JButton("Set up or change user account password");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String newusr = JOptionPane.showInputDialog(frmCoachsPortal,"Please Enter your New Username : ","Enter Username");
				String newpass = JOptionPane.showInputDialog(frmCoachsPortal,"Please Enter your NEW Password : ","Enter Password");
				
				controllerobj.edit_my_account_manager(tempname, tempclub, newusr, newpass);
			}
		});
		btnNewButton.setBounds(137, 197, 229, 23);
		frmCoachsPortal.getContentPane().add(btnNewButton);
		
		JButton btnViewTeamReport = new JButton("View Team Report");
		btnViewTeamReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ui_for_TeamManager_Team window = new ui_for_TeamManager_Team();
				window.initialize(" ",tempclub);
			}
		});
		btnViewTeamReport.setBounds(137, 163, 229, 23);
		frmCoachsPortal.getContentPane().add(btnViewTeamReport);
		
		JButton btnViewIndividualReport = new JButton("View Individual Report");
		btnViewIndividualReport.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				String namereport = JOptionPane.showInputDialog("Enter the name of your club's player :","View Individual's Report");
				ui_for_TeamManager_individual window = new ui_for_TeamManager_individual();
				window.initialize(namereport,tempclub);
				
			}
		});
		btnViewIndividualReport.setBounds(137, 129, 229, 23);
		frmCoachsPortal.getContentPane().add(btnViewIndividualReport);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(".\\data\\images\\coachh.jpg"));
		label.setBounds(0, -15, 517, 357);
		frmCoachsPortal.getContentPane().add(label);
	}
}