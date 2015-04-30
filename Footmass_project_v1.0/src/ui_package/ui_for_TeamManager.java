package ui_package;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JOptionPane;

import footy.Controller_footmass;

import javax.swing.JButton;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JLabel;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Font;

public class ui_for_TeamManager {

	private JFrame frmTeamManagersPortal;
	private JTextField txtmangername;
	private JTextField textclub;
	
	String tempname;
	String tempclub;
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize( String username , String password) 
	{
		
		final Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		frmTeamManagersPortal = new JFrame();
		frmTeamManagersPortal.getContentPane().setBackground(new Color(51, 51, 51));
		frmTeamManagersPortal.setTitle("Team Manager's Portal");
		frmTeamManagersPortal.setVisible(true);
		frmTeamManagersPortal.setBounds(100, 100, 800, 450);
		frmTeamManagersPortal.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmTeamManagersPortal.getContentPane().setLayout(null);
		
		//MANAGER OBJECT RETURNS HERE .. 
		tempclub = controllerobj.getteamManager(username, password).getClub_affiliation(); 
		tempname = controllerobj.getteamManager(username, password).getName_manager();
		//
		JButton btnViewIndividualReport = new JButton("View individual Report");
		btnViewIndividualReport.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String namereport = JOptionPane.showInputDialog("Enter the name of your club's player :","View Individual's Report");	
				ui_for_TeamManager_individual window = new ui_for_TeamManager_individual();
				window.initialize(namereport,tempclub);
			}
		});
		btnViewIndividualReport.setBounds(279, 221, 169, 23);
		frmTeamManagersPortal.getContentPane().add(btnViewIndividualReport);
		
		JButton btnNewButton = new JButton("View Team Reports");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmTeamManagersPortal.setVisible(false);
				ui_for_TeamManager_Team window = new ui_for_TeamManager_Team();
				window.initialize(tempname,tempclub);
				
			}
		});
		btnNewButton.setBounds(279, 255, 169, 23);
		frmTeamManagersPortal.getContentPane().add(btnNewButton);
		
		JButton btnManageTransfers = new JButton("Manage Transfers");
		btnManageTransfers.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				ui_for_TeamManager_manageTransfers window = new ui_for_TeamManager_manageTransfers();
				window.initialize(tempname,tempclub);
			}
		});
		btnManageTransfers.setBounds(279, 187, 169, 23);
		frmTeamManagersPortal.getContentPane().add(btnManageTransfers);
		
		JButton btnNewButton_1 = new JButton("Set up or change password");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String newusr = JOptionPane.showInputDialog(frmTeamManagersPortal,"Please Enter your New Username : ","Enter Username");
				String newpass = JOptionPane.showInputDialog(frmTeamManagersPortal,"Please Enter your NEW Password : ","Enter Password");
				
				controllerobj.edit_my_account_manager(tempname, tempclub, newusr, newpass);
			}
		});
		btnNewButton_1.setBounds(279, 289, 169, 23);
		frmTeamManagersPortal.getContentPane().add(btnNewButton_1);
		
		JLabel lblManager = new JLabel("Manager :");
		lblManager.setForeground(Color.WHITE);
		lblManager.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblManager.setBackground(Color.WHITE);
		lblManager.setBounds(20, 24, 116, 14);
		frmTeamManagersPortal.getContentPane().add(lblManager);
		
		txtmangername = new JTextField();
		txtmangername.setEditable(false);
		txtmangername.setBounds(146, 23, 169, 20);
		frmTeamManagersPortal.getContentPane().add(txtmangername);
		txtmangername.setColumns(10);
		
		JLabel lblClub = new JLabel("Club :");
		lblClub.setFont(new Font("Tahoma", Font.BOLD, 16));
		lblClub.setForeground(Color.WHITE);
		lblClub.setBounds(20, 49, 82, 14);
		frmTeamManagersPortal.getContentPane().add(lblClub);
		
		textclub = new JTextField();
		textclub.setEditable(false);
		textclub.setBounds(146, 48, 169, 20);
		frmTeamManagersPortal.getContentPane().add(textclub);
		textclub.setColumns(10);
		
		//
		txtmangername.setText(tempname);
		textclub.setText(tempclub);
		
		JButton btnBACK = new JButton("Back");
		btnBACK.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				frmTeamManagersPortal.setVisible(false);
				footmass GUI = new footmass();
				GUI.initialize();
			}
		});
		btnBACK.setBounds(20, 377, 103, 23);
		frmTeamManagersPortal.getContentPane().add(btnBACK);
		
		JLabel label = new JLabel("");
		label.setIcon(new ImageIcon(".\\data\\images\\managerr.jpg"));
		label.setBounds(0, -1, 794, 412);
		frmTeamManagersPortal.getContentPane().add(label);

	}
}

//