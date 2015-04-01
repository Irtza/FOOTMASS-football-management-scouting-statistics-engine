package ui_package;

import footy.Controller_footmass;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class ui_for_footmassadmin_addPlayer {

	
	private JFrame frmAddANew;
	private JTextField textField;
	private JTextField textField_1;
	
	String name_ui;
	String club_ui;
	String age_ui;
	String position_ui;

	String[] ages = { "16", "17", "18", "19", "20" , "21", "22", "23", "24", "25", "26", "27", "28", "29", "30" , "31", "32", "33", "34", "35", "36", "37", "38", "39", "40" , "41", "42", "43", "44", "45", "46", "47", "48", "49", "50"};
	String[] positions = {"GK" , "LB" , "CB" , "RB" , "CDM" , "CM" , "RM" , "LM" ,"RW" , "LW" ,"CAM" , "CF" ,"ST" };	
	
	public void initialize()
	{
		Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		frmAddANew = new JFrame();
		frmAddANew.setResizable(false);
		frmAddANew.setVisible(true);
		frmAddANew.setTitle("Add a new Player");
		frmAddANew.setBounds(100, 100, 450, 300);
		frmAddANew.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddANew.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Name :");
		lblNewLabel.setBounds(113, 55, 46, 14);
		frmAddANew.getContentPane().add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("Club :");
		lblNewLabel_1.setBounds(113, 89, 46, 14);
		frmAddANew.getContentPane().add(lblNewLabel_1);
		
		JLabel lblAge = new JLabel("Age :");
		lblAge.setBounds(113, 124, 46, 14);
		frmAddANew.getContentPane().add(lblAge);
		
		JLabel lblPosition = new JLabel("Position :");
		lblPosition.setBounds(113, 153, 46, 14);
		frmAddANew.getContentPane().add(lblPosition);
		
		textField = new JTextField();
		textField.setBounds(193, 49, 86, 20);
		frmAddANew.getContentPane().add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(193, 83, 86, 20);
		frmAddANew.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		
		final JComboBox comboBox = new JComboBox(ages);
		comboBox.setMaximumRowCount(34);
		comboBox.setBounds(219, 118, 60, 20);
		frmAddANew.getContentPane().add(comboBox);
		
		final JComboBox comboBox_1 = new JComboBox(positions);
		comboBox_1.setMaximumRowCount(13);
		comboBox_1.setBounds(219, 147, 60, 20);
		frmAddANew.getContentPane().add(comboBox_1);
		
		JButton btnOk = new JButton("OK");
		btnOk.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				name_ui = textField.getText();
				club_ui = textField_1.getText();
				age_ui = comboBox.getSelectedItem().toString();
				position_ui = comboBox_1.getSelectedItem().toString();
				
				if (textField.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please enter the name of the Player","Re-Enter Name",JOptionPane.ERROR_MESSAGE);
				}
				else if (textField_1.getText().equals(""))
				{
					JOptionPane.showMessageDialog(null,"Please enter the Club of the Player","Re-Enter Club",JOptionPane.ERROR_MESSAGE);
				}
				else
				controllerobj.add_player(name_ui,club_ui,age_ui,position_ui,0,0,0,0,0,0,0,0,0,0,0,0);
			}
		});
		btnOk.setBounds(207, 195, 72, 23);
		frmAddANew.getContentPane().add(btnOk);
		
		JButton btnNewButton = new JButton("Back");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent arg0) {
				
				frmAddANew.setVisible(false);
				ui_for_footmassAdmin window = new ui_for_footmassAdmin();
				window.initialize();
				
			}
		});
		btnNewButton.setBounds(125, 195, 72, 23);
		frmAddANew.getContentPane().add(btnNewButton);
		
	}
}
