package ui_package;

import javax.swing.JFrame;

import footy.Controller_footmass;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ui_for_footmassadmin_deleteManager {

	private JFrame frmDeleteManager;
	private JTextField textField;
	private JTextField textField_1;
	
	String name_man_ui;
	String club_man_ui;


	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize()
	{
		
		final Controller_footmass controllerobj = Controller_footmass.getInstance();
	
		frmDeleteManager = new JFrame();
		frmDeleteManager.setTitle("Delete Manager");
		frmDeleteManager.setResizable(false);
		frmDeleteManager.setVisible(true);
		frmDeleteManager.setBounds(100, 100, 450, 300);
		frmDeleteManager.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeleteManager.getContentPane().setLayout(null);
		
		JLabel lblEnterName = new JLabel("Enter the Manager name :");
		lblEnterName.setBounds(95, 88, 126, 14);
		frmDeleteManager.getContentPane().add(lblEnterName);
		
		JLabel lblEnterClub = new JLabel("Enter Manager club :");
		lblEnterClub.setBounds(121, 125, 100, 14);
		frmDeleteManager.getContentPane().add(lblEnterClub);
		
		textField = new JTextField();
		textField.setBounds(231, 85, 86, 20);
		frmDeleteManager.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(231, 122, 86, 20);
		frmDeleteManager.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JButton btnOk = new JButton("Ok");
		btnOk.addMouseListener(new MouseAdapter() {
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
				{
					controllerobj.delete_team_manager(name_man_ui, club_man_ui);
				
				}
			}
		});
		btnOk.setBounds(228, 167, 89, 23);
		frmDeleteManager.getContentPane().add(btnOk);
		
		JButton btnBack = new JButton("Back");
		btnBack.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				frmDeleteManager.setVisible(false);
				ui_for_footmassAdmin window = new ui_for_footmassAdmin();
				window.initialize();
			}
		});
		btnBack.setBounds(129, 167, 89, 23);
		frmDeleteManager.getContentPane().add(btnBack);
	}
}