package ui_package;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;

import footy.Controller_footmass;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ui_for_footmassadmin_addManager {

	private JFrame frmAddTeamManager;
	private JTextField textField;
	private JTextField textField_1;

	String name_man_ui;
	String club_man_ui;

	/**
	 * Create the application.
	 * @wbp.parser.entryPoint
	 */
	public void initialize()
	{
		Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		frmAddTeamManager = new JFrame();
		frmAddTeamManager.setVisible(true);
		frmAddTeamManager.setResizable(false);
		frmAddTeamManager.setTitle("Add Team Manager");
		frmAddTeamManager.setBounds(100, 100, 450, 300);
		frmAddTeamManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddTeamManager.getContentPane().setLayout(null);
		
		JLabel lblEnterManagerName = new JLabel("Enter Manager Name :");
		lblEnterManagerName.setBounds(107, 87, 116, 14);
		frmAddTeamManager.getContentPane().add(lblEnterManagerName);
		
		JLabel lblEnterManagerClub = new JLabel("Enter Manager Club :");
		lblEnterManagerClub.setBounds(107, 112, 116, 14);
		frmAddTeamManager.getContentPane().add(lblEnterManagerClub);
		
		textField = new JTextField();
		textField.setBounds(233, 84, 86, 20);
		frmAddTeamManager.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(233, 109, 86, 20);
		frmAddTeamManager.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnNewButton = new JButton("Ok");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				name_man_ui = textField.getText();
				club_man_ui = textField_1.getText();
				
				if (textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please enter the name of the Manager","Re-Enter Name",JOptionPane.ERROR_MESSAGE);
				}
				else if (textField_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please enter the Club of the Manager","Re-Enter Club",JOptionPane.ERROR_MESSAGE);
				}
				else
					try {
						controllerobj.add_team_manager(name_man_ui, club_man_ui);
					} catch (Exception e) {
						JOptionPane.showMessageDialog(frmAddTeamManager,"The club doesnt exist","Cannot add Manager", JOptionPane.ERROR_MESSAGE);
					}
				}
		});
		btnNewButton.setBounds(233, 163, 89, 23);
		frmAddTeamManager.getContentPane().add(btnNewButton);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmAddTeamManager.setVisible(false);
				ui_for_footmassAdmin window = new ui_for_footmassAdmin();
				window.initialize();
			}
		});
		btnBack.setBounds(134, 163, 89, 23);
		frmAddTeamManager.getContentPane().add(btnBack);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 46, 14);
		frmAddTeamManager.getContentPane().add(lblNewLabel);
	}


}
