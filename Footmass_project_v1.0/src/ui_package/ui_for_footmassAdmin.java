package ui_package;

import javax.swing.JFrame;
import javax.swing.JButton;
import javax.swing.JOptionPane;

import footy.Controller_footmass;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
public class ui_for_footmassAdmin {

	private JFrame frmWelcomeFootmassAdmin;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize()
	{
		final Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		frmWelcomeFootmassAdmin = new JFrame();
		
		frmWelcomeFootmassAdmin.setVisible(true);
		
		frmWelcomeFootmassAdmin.setTitle("Welcome Footmass Admin!");
		frmWelcomeFootmassAdmin.setBounds(100, 100, 814, 500);
		frmWelcomeFootmassAdmin.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmWelcomeFootmassAdmin.getContentPane().setLayout(null);
		
		JButton btnNewButton = new JButton("Add a New Player");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmWelcomeFootmassAdmin.setVisible(false);
				ui_for_footmassadmin_addPlayer window = new ui_for_footmassadmin_addPlayer();
				window.initialize();	
			}
		});
		btnNewButton.setBounds(316, 84, 150, 23);
		frmWelcomeFootmassAdmin.getContentPane().add(btnNewButton);
		
		JButton btnUpdateExistinPlayer = new JButton("Delete Existing Player");
		btnUpdateExistinPlayer.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmWelcomeFootmassAdmin.setVisible(false);
				ui_for_footmassadmin_deletePlayer window = new ui_for_footmassadmin_deletePlayer();
				window.initialize();
			}
		});
		btnUpdateExistinPlayer.setBounds(316, 117, 150, 23);
		frmWelcomeFootmassAdmin.getContentPane().add(btnUpdateExistinPlayer);
		
		JButton btnNewButton_1 = new JButton("Add Team Manager");
		btnNewButton_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmWelcomeFootmassAdmin.setVisible(false);
				ui_for_footmassadmin_addManager window = new ui_for_footmassadmin_addManager();
				window.initialize();
			}
		});
		btnNewButton_1.setBounds(316, 151, 150, 23);
		frmWelcomeFootmassAdmin.getContentPane().add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete Team Manager");
		btnNewButton_2.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0){
				frmWelcomeFootmassAdmin.setVisible(false);
				ui_for_footmassadmin_deleteManager window = new ui_for_footmassadmin_deleteManager();
				window.initialize();
			}
		});
		btnNewButton_2.setBounds(316, 185, 150, 23);
		frmWelcomeFootmassAdmin.getContentPane().add(btnNewButton_2);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frmWelcomeFootmassAdmin.setVisible(false);
				footmass window = new footmass();
				window.initialize();				
			}
		});
		btnBack.setBounds(10, 427, 89, 23);
		frmWelcomeFootmassAdmin.getContentPane().add(btnBack);
		
		JButton btnNewButton_4 = new JButton("Add Coach");
		btnNewButton_4.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String name_coach = JOptionPane.showInputDialog("Enter name of the Coach");
				String club_affiliation =  JOptionPane.showInputDialog("Enter name of the Club");
				
				try {
					controllerobj.add_coach(name_coach, club_affiliation);
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(frmWelcomeFootmassAdmin, "Cant add Coach Club doesnt exist","Error adding coach",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton_4.setBounds(316, 219, 150, 23);
		frmWelcomeFootmassAdmin.getContentPane().add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Delete Coach");
		btnNewButton_5.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String name_coach = JOptionPane.showInputDialog("Enter name of the Coach");
				String club_affiliation =  JOptionPane.showInputDialog("Enter name of the Club");
				
				try {
					controllerobj.delete_Coach(name_coach, club_affiliation);
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(frmWelcomeFootmassAdmin, "Cant add Coach Club doesnt exist","Error adding coach",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_5.setBounds(316, 253, 150, 23);
		frmWelcomeFootmassAdmin.getContentPane().add(btnNewButton_5);
		
		JButton btnNewButton_6 = new JButton("Add Transfer Agent");
		btnNewButton_6.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				String name_transferAgent = JOptionPane.showInputDialog("Enter name of the Transfer Agent");
				String club_affiliation =  JOptionPane.showInputDialog("Enter name of the Club");
				
				try {
					controllerobj.add_transfer_agent(name_transferAgent, club_affiliation);
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(frmWelcomeFootmassAdmin, "Cant add Transfer Agent Club doesnt exist","Error adding Transfer Agent",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_6.setBounds(316, 287, 150, 23);
		frmWelcomeFootmassAdmin.getContentPane().add(btnNewButton_6);
		
		JButton btnNewButton_7 = new JButton("Delete Transfer Agent");
		btnNewButton_7.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String name_transferAgent = JOptionPane.showInputDialog("Enter name of the Transfer Agent");
				String club_affiliation =  JOptionPane.showInputDialog("Enter name of the Club");
				
				try {
					controllerobj.delete_transferagent(name_transferAgent, club_affiliation);
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(frmWelcomeFootmassAdmin, "Cant delete Transfer Agent Club doesnt exist","Error deleting Transfer Agent",JOptionPane.ERROR_MESSAGE);
				}
				
			}
		});
		btnNewButton_7.setBounds(316, 321, 150, 23);
		frmWelcomeFootmassAdmin.getContentPane().add(btnNewButton_7);
		
		JButton btnNewButton_8 = new JButton("Add Scout");
		btnNewButton_8.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String name_scout = JOptionPane.showInputDialog("Enter name of the Scout");
				String club_affiliation =  JOptionPane.showInputDialog("Enter name of the Club");
				
				try {
					controllerobj.add_Scout(name_scout, club_affiliation);
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(frmWelcomeFootmassAdmin, "Cant add Scout Club doesnt exist","Error adding Scout",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_8.setBounds(316, 355, 150, 23);
		frmWelcomeFootmassAdmin.getContentPane().add(btnNewButton_8);
		
		JButton btnNewButton_9 = new JButton("Delete Scout");
		btnNewButton_9.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				String name_scout = JOptionPane.showInputDialog("Enter name of the Scout");
				String club_affiliation =  JOptionPane.showInputDialog("Enter name of the Club");
				
				try {
					controllerobj.delete_Scout(name_scout, club_affiliation);
				} catch (Exception e2) {
					JOptionPane.showConfirmDialog(frmWelcomeFootmassAdmin, "Cant delete Scout","Error deleting Scout",JOptionPane.ERROR_MESSAGE);
				}
			}
		});
		btnNewButton_9.setBounds(316, 389, 150, 23);
		frmWelcomeFootmassAdmin.getContentPane().add(btnNewButton_9);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(".\\data\\images\\base.jpg"));
		lblNewLabel.setBounds(0, 0, 798, 461);
		frmWelcomeFootmassAdmin.getContentPane().add(lblNewLabel);
	}
}
