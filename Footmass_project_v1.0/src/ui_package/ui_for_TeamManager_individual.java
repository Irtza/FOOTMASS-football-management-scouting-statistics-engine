package ui_package;

import javax.swing.JFrame;

import footy.Controller_footmass;

import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JLabel;

import java.awt.Font;
import javax.swing.JProgressBar;
import javax.swing.JSeparator;
import java.awt.Color;

public class ui_for_TeamManager_individual 
{
	private JFrame frmViewPlayersReport;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	private JTextField textField_3;
	private JTextField textField_4;
	private JTextField textField_5;
	private JTextField textField_6;
	private JTextField textField_7;
	private JTextField textField_8;
	private JLabel lblPassingEfficiency;
	private JLabel lblTacklingEfficiency;
	private JLabel lblShootingEfficiency;
	private JLabel lblFoulsPerGame;
	private JLabel lblGoalsPerGame;
	private JLabel lblSavesPerMatch;
	private JLabel lblPassingExpectancy;
	private JLabel lblSuccesfullTacklingExpectancy;
	private JLabel lblShootingExpectancy;
	private JLabel lblPlayerName;
	private JTextField textField_playername;
	private JLabel label;
	private JLabel lblProgressBarsShow;

	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(String namereport, String clubmanager) 
	{
		Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		frmViewPlayersReport = new JFrame();
		frmViewPlayersReport.getContentPane().setFont(new Font("Tempus Sans ITC", Font.PLAIN, 11));
		frmViewPlayersReport.setTitle("View Player's report");
		frmViewPlayersReport.setVisible(true);
		frmViewPlayersReport.setBounds(100, 100, 640, 450);
		frmViewPlayersReport.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmViewPlayersReport.getContentPane().setLayout(null);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setColumns(10);
		textField.setBounds(295, 78, 86, 20);
		frmViewPlayersReport.getContentPane().add(textField);
		
		float pa = controllerobj.getplayer_generatereport(namereport, clubmanager).getMy_stats().getPassing_accuracy_percentage();
		textField.setText( Float.toString( pa  ) );
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setColumns(10);
		textField_1.setBounds(295, 107, 86, 20);
		frmViewPlayersReport.getContentPane().add(textField_1);
		
		float ta = controllerobj.getplayer_generatereport(namereport, clubmanager).getMy_stats().getTackling_accuracy_percentage();
		textField_1.setText( Float.toString( ta ) );
		
		textField_2 = new JTextField();
		textField_2.setEditable(false);
		textField_2.setColumns(10);
		textField_2.setBounds(295, 138, 86, 20);
		frmViewPlayersReport.getContentPane().add(textField_2);
		
		float sa = controllerobj.getplayer_generatereport(namereport, clubmanager).getMy_stats().getTackling_accuracy_percentage();
		textField_2.setText( Float.toString( sa ) );
		
		textField_3 = new JTextField();
		textField_3.setEditable(false);
		textField_3.setColumns(10);
		textField_3.setBounds(295, 169, 86, 20);
		frmViewPlayersReport.getContentPane().add(textField_3);
		
		textField_3.setText( Float.toString( controllerobj.getplayer_generatereport(namereport, clubmanager).getMy_stats().getFouls_per_game() ) );
		
		textField_4 = new JTextField();
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		textField_4.setBounds(295, 200, 86, 20);
		frmViewPlayersReport.getContentPane().add(textField_4);
		
		textField_4.setText( Float.toString( controllerobj.getplayer_generatereport(namereport, clubmanager).getMy_stats().getGoals_per_game()  ) );
		
		textField_5 = new JTextField();
		textField_5.setEditable(false);
		textField_5.setColumns(10);
		textField_5.setBounds(295, 226, 86, 20);
		frmViewPlayersReport.getContentPane().add(textField_5);
		
		textField_5.setText( Float.toString( controllerobj.getplayer_generatereport(namereport, clubmanager).getMy_stats().getSaves_per_game() ) );
		
		textField_6 = new JTextField();
		textField_6.setEditable(false);
		textField_6.setColumns(10);
		textField_6.setBounds(295, 255, 86, 20);
		frmViewPlayersReport.getContentPane().add(textField_6);
		
		textField_6.setText( Float.toString( controllerobj.getplayer_generatereport(namereport, clubmanager).getMy_stats().getPasses_Completed_per_game()  ) );
		
		textField_7 = new JTextField();
		textField_7.setEditable(false);
		textField_7.setColumns(10);
		textField_7.setBounds(295, 286, 86, 20);
		frmViewPlayersReport.getContentPane().add(textField_7);
		
		textField_7.setText( Float.toString( controllerobj.getplayer_generatereport(namereport, clubmanager).getMy_stats().getTackles_Completed_per_game() ) );
		textField_8 = new JTextField();
		textField_8.setEditable(false);
		textField_8.setColumns(10);
		textField_8.setBounds(295, 317, 86, 20);
		frmViewPlayersReport.getContentPane().add(textField_8);
		
		textField_8.setText( Float.toString( controllerobj.getplayer_generatereport(namereport, clubmanager).getMy_stats().getShots_Attempted_per_game()  ) );
		
		lblPassingEfficiency = new JLabel("Passing Efficiency :");
		lblPassingEfficiency.setBounds(74, 78, 160, 20);
		frmViewPlayersReport.getContentPane().add(lblPassingEfficiency);
		
		lblTacklingEfficiency = new JLabel("Tackling Efficiency :");
		lblTacklingEfficiency.setBounds(74, 107, 160, 20);
		frmViewPlayersReport.getContentPane().add(lblTacklingEfficiency);
		
		lblShootingEfficiency = new JLabel("Shooting Efficiency :");
		lblShootingEfficiency.setBounds(74, 138, 160, 20);
		frmViewPlayersReport.getContentPane().add(lblShootingEfficiency);
		
		lblFoulsPerGame = new JLabel("Foul expectancy per game :");
		lblFoulsPerGame.setBounds(74, 169, 211, 20);
		frmViewPlayersReport.getContentPane().add(lblFoulsPerGame);
		
		lblGoalsPerGame = new JLabel("Goal Conversion Rate :");
		lblGoalsPerGame.setBounds(74, 200, 160, 20);
		frmViewPlayersReport.getContentPane().add(lblGoalsPerGame);
		
		lblSavesPerMatch = new JLabel("Saves per match :");
		lblSavesPerMatch.setBounds(74, 226, 160, 20);
		frmViewPlayersReport.getContentPane().add(lblSavesPerMatch);
		
		lblPassingExpectancy = new JLabel("Passing expectancy :");
		lblPassingExpectancy.setBounds(74, 255, 160, 20);
		frmViewPlayersReport.getContentPane().add(lblPassingExpectancy);
		
		lblSuccesfullTacklingExpectancy = new JLabel("Succesfull Tackling expectancy :");
		lblSuccesfullTacklingExpectancy.setBounds(74, 286, 211, 20);
		frmViewPlayersReport.getContentPane().add(lblSuccesfullTacklingExpectancy);
		
		lblShootingExpectancy = new JLabel("Shooting expectancy :");
		lblShootingExpectancy.setBounds(74, 317, 211, 20);
		frmViewPlayersReport.getContentPane().add(lblShootingExpectancy);
		
		lblPlayerName = new JLabel("Statistical Report for Player :");
		lblPlayerName.setFont(new Font("Tahoma", Font.BOLD, 14));
		lblPlayerName.setBounds(38, 26, 209, 20);
		frmViewPlayersReport.getContentPane().add(lblPlayerName);
		
		textField_playername = new JTextField();
		textField_playername.setEditable(false);
		textField_playername.setColumns(10);
		textField_playername.setBounds(280, 28, 233, 20);
		frmViewPlayersReport.getContentPane().add(textField_playername);
		textField_playername.setText(namereport);
		
		JProgressBar progressBar = new JProgressBar();
		progressBar.setForeground(Color.GREEN);
		progressBar.setBounds(391, 78, 146, 14);
		progressBar.setValue((int) pa);
		frmViewPlayersReport.getContentPane().add(progressBar);
		
		JProgressBar progressBar_1 = new JProgressBar();
		progressBar_1.setForeground(Color.GREEN);
		progressBar_1.setBounds(391, 107, 146, 14);
		progressBar_1.setValue((int) ta);
		frmViewPlayersReport.getContentPane().add(progressBar_1);
		
		JProgressBar progressBar_2 = new JProgressBar();
		progressBar_2.setForeground(Color.GREEN);
		progressBar_2.setBounds(391, 138, 146, 14);
		progressBar_2.setValue((int) sa);
		
		frmViewPlayersReport.getContentPane().add(progressBar_2);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 57, 604, 2);
		frmViewPlayersReport.getContentPane().add(separator);
		
		lblProgressBarsShow = new JLabel("*Bar Show percentages");
		lblProgressBarsShow.setFont(new Font("Tahoma", Font.ITALIC, 9));
		lblProgressBarsShow.setBounds(10, 386, 199, 14);
		frmViewPlayersReport.getContentPane().add(lblProgressBarsShow);
		
		label = new JLabel("");
		label.setIcon(new ImageIcon(".\\data\\images\\stats.jpg"));
		label.setBounds(0, 1, 624, 410);
		frmViewPlayersReport.getContentPane().add(label);
	}
}