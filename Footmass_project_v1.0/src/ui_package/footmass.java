package ui_package; 

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JLabel;

import java.awt.Font;
import java.awt.Color;

import javax.swing.JButton;

import footy.Controller_footmass;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class footmass {

	private JFrame frmFootballManagementAnd;
	
	String usr;
	String pass;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize()
	{
		
		//GETTING INSTANCES
		Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		frmFootballManagementAnd = new JFrame();
		frmFootballManagementAnd.setResizable(false);
		frmFootballManagementAnd.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {
				
				int a = JOptionPane.showConfirmDialog(frmFootballManagementAnd, "Do you want to commit these changes to persistence?");
				
				if (a==0)
				{
					System.out.println("Commited changes to Database!");
					//Committing changes to the Database !
					//controllerobj.save_all();
					//all saves here
				}
			}
		});
		frmFootballManagementAnd.setTitle("Football Management, Statistics and Scouting");
		frmFootballManagementAnd.setVisible(true);
		
		frmFootballManagementAnd.setBounds(100, 100, 1150, 500);
		frmFootballManagementAnd.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmFootballManagementAnd.getContentPane().setLayout(null);
		
		JLabel lblWelcomeToFootmass = new JLabel("Welcome To FootMass System");
		lblWelcomeToFootmass.setBounds(407, 22, 393, 25);
		lblWelcomeToFootmass.setForeground(new Color(248, 248, 255));
		lblWelcomeToFootmass.setFont(new Font("Tahoma", Font.BOLD, 20));
		frmFootballManagementAnd.getContentPane().add(lblWelcomeToFootmass);
		
		JButton btnFootmassAdmin = new JButton("FootMass Admin");
		btnFootmassAdmin.setBounds(493, 84, 169, 23);
		btnFootmassAdmin.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmFootballManagementAnd.setVisible(false);
				
				usr = JOptionPane.showInputDialog(frmFootballManagementAnd,"Please Enter your Username : ","Enter Username");
				pass = JOptionPane.showInputDialog(frmFootballManagementAnd,"Please Enter your Username : ","Enter Password");

				if(controllerobj.auth_footmass(usr, pass))
				{
					JOptionPane.showMessageDialog(null, "Authenticated", "Access granted!",JOptionPane.INFORMATION_MESSAGE);
					ui_for_footmassAdmin window = new ui_for_footmassAdmin();
					window.initialize();
				}
				else
					JOptionPane.showMessageDialog(null,  "Not authenticated", "Not authenticated",JOptionPane.ERROR_MESSAGE);
			}
		});
		frmFootballManagementAnd.getContentPane().add(btnFootmassAdmin);
		
		JButton btnTransferAgent = new JButton("Transfer Agent");
		btnTransferAgent.setBounds(493, 141, 169, 23);
		btnTransferAgent.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmFootballManagementAnd.setVisible(false);
				usr = JOptionPane.showInputDialog(frmFootballManagementAnd,"Please Enter your Username : ","Enter Username");
				pass = JOptionPane.showInputDialog(frmFootballManagementAnd,"Please Enter your Username : ","Enter Password");
				
				if(controllerobj.auth_transferagent(usr, pass))
				{
					JOptionPane.showMessageDialog(null, "Authenticated", "Access granted!",JOptionPane.INFORMATION_MESSAGE);
					ui_for_Transgeragent window = new ui_for_Transgeragent();
					window.initialize(usr,pass);
				}
				else
					JOptionPane.showMessageDialog(null,  "Not authenticated", "Not authenticated",JOptionPane.ERROR_MESSAGE);
			}
			
		});
		frmFootballManagementAnd.getContentPane().add(btnTransferAgent);
		
		JButton btnMatchAnalyst = new JButton("Match Analyst");
		btnMatchAnalyst.setBounds(493, 194, 169, 23);
		btnMatchAnalyst.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
			
				frmFootballManagementAnd.setVisible(false); //close parent window
				
				usr = JOptionPane.showInputDialog(frmFootballManagementAnd,"Please Enter your Username : ","Enter Username");
				pass = JOptionPane.showInputDialog(frmFootballManagementAnd,"Please Enter your Username : ","Enter Password");

				if(controllerobj.auth_matchanalyst(usr, pass))
				{
					JOptionPane.showMessageDialog(null, "Authenticated", "Access granted!",JOptionPane.INFORMATION_MESSAGE);
					String home = JOptionPane.showInputDialog("Enter Home Team Name :");
					String away = JOptionPane.showInputDialog("Enter Away Team Name :");	
					ui_for_matchAnalyst window = new ui_for_matchAnalyst();
					window.initialize(home,away);
				}
				else
					JOptionPane.showMessageDialog(null,  "Not authenticated", "Not authenticated",JOptionPane.ERROR_MESSAGE);
			}
		});
		frmFootballManagementAnd.getContentPane().add(btnMatchAnalyst);
		
		JButton btnTeamManager = new JButton("Team Manager");
		btnTeamManager.setBounds(493, 246, 169, 23);
		btnTeamManager.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frmFootballManagementAnd.setVisible(false);
				
				usr = JOptionPane.showInputDialog(frmFootballManagementAnd,"Please Enter your Username : ","Enter Username");
				pass = JOptionPane.showInputDialog(frmFootballManagementAnd,"Please Enter your Password : ","Enter Password");

				if(controllerobj.auth_teamman(usr, pass))
				{
					JOptionPane.showMessageDialog(null,"Authenticated", "Access granted!",JOptionPane.INFORMATION_MESSAGE);
					ui_for_TeamManager window = new ui_for_TeamManager();	//pass here usr and pass
					window.initialize(usr, pass);	
				}

				else
					JOptionPane.showMessageDialog(null,  "Not authenticated", "Not authenticated",JOptionPane.ERROR_MESSAGE);
					
			}
		});
		frmFootballManagementAnd.getContentPane().add(btnTeamManager);
		
		JButton btnCoachingStaff = new JButton("Coaching Staff");
		btnCoachingStaff.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmFootballManagementAnd.setVisible(false);
				usr = JOptionPane.showInputDialog(frmFootballManagementAnd,"Please Enter your Username : ","Enter Username");
				pass = JOptionPane.showInputDialog(frmFootballManagementAnd,"Please Enter your Password : ","Enter Password");

				if(controllerobj.auth_coach(usr, pass))
				{
				JOptionPane.showMessageDialog(null,"Authenticated", "Access granted!",JOptionPane.INFORMATION_MESSAGE);
				ui_for_Coach window = new ui_for_Coach();
				window.initialize(usr,pass);
				}
				else
				JOptionPane.showMessageDialog(null,  "Not authenticated", "Not authenticated",JOptionPane.ERROR_MESSAGE);
					
			}
		});
		btnCoachingStaff.setBounds(493, 360, 169, 23);
		frmFootballManagementAnd.getContentPane().add(btnCoachingStaff);
		
		JButton btnScout = new JButton("Scout");
		btnScout.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				frmFootballManagementAnd.setVisible(false);
				
				usr = JOptionPane.showInputDialog(frmFootballManagementAnd,"Please Enter your Username : ","Enter Username");
				pass = JOptionPane.showInputDialog(frmFootballManagementAnd,"Please Enter your Password : ","Enter Password");

				if(controllerobj.auth_Scout(usr, pass))
				{
					JOptionPane.showMessageDialog(null,"Authenticated", "Access granted!",JOptionPane.INFORMATION_MESSAGE);
					ui_for_Scout window = new ui_for_Scout();
					window.initialize(usr,pass);					
				}
				else
					JOptionPane.showMessageDialog(null,  "Not authenticated", "Not authenticated",JOptionPane.ERROR_MESSAGE);
			}
		});
		btnScout.setBounds(493, 303, 169, 23);
		frmFootballManagementAnd.getContentPane().add(btnScout);
		
		JLabel lblAllRightsReserved = new JLabel("All Rights Reserved Footmass Inc.");
		lblAllRightsReserved.setFont(new Font("Tahoma", Font.PLAIN, 8));
		lblAllRightsReserved.setBounds(514, 436, 148, 14);
		frmFootballManagementAnd.getContentPane().add(lblAllRightsReserved);
		
		JLabel label = new JLabel("");
		label.setBounds(0, 0, 1144, 471);
		frmFootballManagementAnd.getContentPane().add(label);
		label.setIcon(new ImageIcon(".\\data\\images\\Football_Pitch_by_Haqn.png"));
	}
}
