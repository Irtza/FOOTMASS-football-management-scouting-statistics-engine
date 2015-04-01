package ui_package;


import java.util.ArrayList;
import java.util.Iterator;

import javax.swing.JFrame;

import footy.Controller_footmass;
import footy.Player;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextArea;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JScrollBar;

public class ui_for_Scout_ScoutPlayers {

	private JFrame frmScoutForPlayers;
	private JTextField textField_minpa;
	private JTextField textField_minta;
	private JTextField textField_minsa;
	private JTextField textField_minfpg;
	private JTextField textField_mintcpg;
	private JTextField textField_minpcpg;
	private JTextField textField_minspg;
	private JTextField textField_mingpg;
	private JTextField textField_minsapg;
	private JTextField textField_maxsapg;
	private JTextField textField_maxtcpg;
	private JTextField textField_maxpcpg;
	private JTextField textField_maxspg;
	private JTextField textField_maxgpg;
	private JTextField textField_maxfpg;
	private JTextField textField_maxsa;
	private JTextField textField_maxta;
	private JTextField textField_maxpa;

	float min_passing_accuracy_percentage;
	float max_passing_accuracy_percentage;
	float min_tackling_accuracy_percentage;
	float max_tackling_accuracy_percentage;
	float min_shooting_accuracy_percentage;
	float max_shooting_accuracy_percentage;
	float min_fouls_per_game;
	float max_fouls_per_game;
	float min_goals_per_game;
	float max_goals_per_game;
	float min_Saves_per_game;
	float max_Saves_per_game;
	float min_Passes_Completed_per_game;
	float max_Passes_Completed_per_game;
	float min_Tackles_Completed_per_game;
	float max_Tackles_Completed_per_game;
	float min_Shots_Attempted_per_game;
	float max_Shots_Attempted_per_game;
	
	/**
	 * @wbp.parser.entryPoint
	 */
	public void initialize(  ) {
		
		Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		frmScoutForPlayers = new JFrame();
		frmScoutForPlayers.setTitle("Scout for Players");
		frmScoutForPlayers.setVisible(true);
		frmScoutForPlayers.setBounds(100, 100, 773, 599);
		frmScoutForPlayers.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmScoutForPlayers.getContentPane().setLayout(null);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(730, 297, 17, 263);
		frmScoutForPlayers.getContentPane().add(scrollBar);
		
		JLabel lblNewLabel = new JLabel("Min passing accuracy");
		lblNewLabel.setBounds(30, 33, 129, 14);
		frmScoutForPlayers.getContentPane().add(lblNewLabel);
		
		JLabel lblMinPassingAccuracy = new JLabel("Min Tackling Accuracy");
		lblMinPassingAccuracy.setBounds(30, 58, 129, 14);
		frmScoutForPlayers.getContentPane().add(lblMinPassingAccuracy);
		
		JLabel lblMinShootingAccuracy = new JLabel("Min Shooting Accuracy");
		lblMinShootingAccuracy.setBounds(30, 83, 129, 14);
		frmScoutForPlayers.getContentPane().add(lblMinShootingAccuracy);
		
		JLabel lblMinAggression = new JLabel("Min Aggression");
		lblMinAggression.setBounds(30, 108, 129, 14);
		frmScoutForPlayers.getContentPane().add(lblMinAggression);
		
		JLabel lblMinGoalConversion = new JLabel("Min Goal Conversion Rate");
		lblMinGoalConversion.setBounds(30, 133, 129, 14);
		frmScoutForPlayers.getContentPane().add(lblMinGoalConversion);
		
		JLabel lblMinKeeperSave = new JLabel("Min Keeper Save Rate");
		lblMinKeeperSave.setBounds(30, 158, 129, 14);
		frmScoutForPlayers.getContentPane().add(lblMinKeeperSave);
		
		JLabel lblMinPassingPer = new JLabel("Min Passing per game");
		lblMinPassingPer.setBounds(30, 183, 182, 14);
		frmScoutForPlayers.getContentPane().add(lblMinPassingPer);
		
		JLabel lblMinTacklesCompleted = new JLabel("Min Tackles completed per game");
		lblMinTacklesCompleted.setBounds(30, 208, 182, 14);
		frmScoutForPlayers.getContentPane().add(lblMinTacklesCompleted);
		
		JLabel lblMinShotsAttempted = new JLabel("Min Shots Attempted per game");
		lblMinShotsAttempted.setBounds(30, 233, 182, 14);
		frmScoutForPlayers.getContentPane().add(lblMinShotsAttempted);
		
		JLabel lblMaxPassingAccuracy = new JLabel("Max Passing Accuracy");
		lblMaxPassingAccuracy.setBounds(405, 33, 129, 14);
		frmScoutForPlayers.getContentPane().add(lblMaxPassingAccuracy);
		
		JLabel lblMaxTacklingAccuracy = new JLabel("Max Tackling Accuracy");
		lblMaxTacklingAccuracy.setBounds(405, 58, 129, 14);
		frmScoutForPlayers.getContentPane().add(lblMaxTacklingAccuracy);
		
		JLabel lblMaxShootingAccuracy = new JLabel("Max Shooting Accuracy");
		lblMaxShootingAccuracy.setBounds(405, 83, 129, 14);
		frmScoutForPlayers.getContentPane().add(lblMaxShootingAccuracy);
		
		JLabel lblMaxAggression = new JLabel("Max Aggression");
		lblMaxAggression.setBounds(405, 108, 129, 14);
		frmScoutForPlayers.getContentPane().add(lblMaxAggression);
		
		JLabel lblMinGoalConversion_1 = new JLabel("Max Goal Conversion Rate");
		lblMinGoalConversion_1.setBounds(405, 133, 129, 14);
		frmScoutForPlayers.getContentPane().add(lblMinGoalConversion_1);
		
		JLabel lblMinKeeperSave_1 = new JLabel("Max Keeper Save Rate");
		lblMinKeeperSave_1.setBounds(405, 158, 129, 14);
		frmScoutForPlayers.getContentPane().add(lblMinKeeperSave_1);
		
		JLabel lblMaxPassingPer = new JLabel("Max Passing per game");
		lblMaxPassingPer.setBounds(405, 183, 208, 14);
		frmScoutForPlayers.getContentPane().add(lblMaxPassingPer);
		
		JLabel lblMaxTacklesCompleted = new JLabel("Max Tackles completed per game");
		lblMaxTacklesCompleted.setBounds(405, 208, 208, 14);
		frmScoutForPlayers.getContentPane().add(lblMaxTacklesCompleted);
		
		JLabel lblMaxShotsAttempted = new JLabel("Max Shots Attempted per game");
		lblMaxShotsAttempted.setBounds(405, 233, 208, 14);
		frmScoutForPlayers.getContentPane().add(lblMaxShotsAttempted);
		
		JTextArea txtrPotentialSigningsList = new JTextArea();
		txtrPotentialSigningsList.setEditable(false);
		txtrPotentialSigningsList.setBounds(10, 297, 719, 263);
		frmScoutForPlayers.getContentPane().add(txtrPotentialSigningsList);
		
		JButton btnNewButton = new JButton("Generate Scout Report!");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				JOptionPane.showMessageDialog(frmScoutForPlayers, "The Report has been generated!");
				
				txtrPotentialSigningsList.setText(null);
				//GETTING VALUES FORM TEXTFIELDS
				min_passing_accuracy_percentage = Float.parseFloat(textField_minpa.getText().toString());
				min_tackling_accuracy_percentage = Float.parseFloat(textField_minta.getText().toString());
				min_shooting_accuracy_percentage = Float.parseFloat(textField_minsa.getText().toString());		
				min_fouls_per_game = Float.parseFloat(textField_minfpg.getText().toString());		
				min_Tackles_Completed_per_game = Float.parseFloat(textField_mintcpg.getText().toString());
				min_Passes_Completed_per_game = Float.parseFloat(textField_minpcpg.getText().toString());
				min_Saves_per_game = Float.parseFloat(textField_minspg.getText().toString());
				min_goals_per_game = Float.parseFloat(textField_mingpg.getText().toString());
				min_Shots_Attempted_per_game = Float.parseFloat(textField_minsapg.getText().toString());
				max_Shots_Attempted_per_game = Float.parseFloat(textField_maxsapg.getText().toString());
				max_Tackles_Completed_per_game= Float.parseFloat(textField_maxtcpg.getText().toString());
				max_Passes_Completed_per_game = Float.parseFloat(textField_maxpcpg.getText().toString());
				max_Saves_per_game = Float.parseFloat(textField_maxspg.getText().toString());
				max_goals_per_game = Float.parseFloat(textField_maxgpg.getText().toString());
				max_fouls_per_game = Float.parseFloat(textField_maxfpg.getText().toString());
				max_shooting_accuracy_percentage = Float.parseFloat(textField_maxsa.getText().toString());
				max_tackling_accuracy_percentage = Float.parseFloat(textField_maxta.getText().toString());
				max_passing_accuracy_percentage = Float.parseFloat(textField_maxpa.getText().toString());
				
				ArrayList<Player> result = new ArrayList<Player>();
				try{
				result = controllerobj.get_scoutlist(min_passing_accuracy_percentage,max_passing_accuracy_percentage,
						min_tackling_accuracy_percentage,max_tackling_accuracy_percentage,
						min_shooting_accuracy_percentage,max_shooting_accuracy_percentage, 
						min_fouls_per_game, max_fouls_per_game,
						min_goals_per_game,	max_goals_per_game,
						min_Saves_per_game, max_Saves_per_game,  
						min_Passes_Completed_per_game, max_Passes_Completed_per_game,
						min_Tackles_Completed_per_game, max_Tackles_Completed_per_game,
						min_Shots_Attempted_per_game, max_Shots_Attempted_per_game);
			
				}
				catch(NullPointerException ne)
				{
					JOptionPane.showMessageDialog(frmScoutForPlayers, "There is no such Scout to this user account","No such scout!",JOptionPane.ERROR_MESSAGE);
				}
				
				Iterator<Player> it = result.iterator();
				while (it.hasNext())
				{
					Player currobj = it.next();
					txtrPotentialSigningsList.append("Player name : "+ currobj.getName_player()+"  from Club : "+ currobj.getClub_player() + "\n" );
				}
			}
		});
		btnNewButton.setBounds(264, 263, 282, 23);
		frmScoutForPlayers.getContentPane().add(btnNewButton);
		
		textField_minpa = new JTextField();
		textField_minpa.setBounds(222, 33, 86, 20);
		frmScoutForPlayers.getContentPane().add(textField_minpa);
		textField_minpa.setText("0");
		textField_minpa.setColumns(10);

		textField_minta = new JTextField();
		textField_minta.setColumns(10);
		textField_minta.setBounds(222, 58, 86, 20);
		textField_minta.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_minta);
				
		textField_minsa = new JTextField();
		textField_minsa.setColumns(10);
		textField_minsa.setBounds(222, 83, 86, 20);
		textField_minsa.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_minsa);
		
		textField_minfpg = new JTextField();
		textField_minfpg.setColumns(10);
		textField_minfpg.setBounds(222, 108, 86, 20);
		textField_minfpg.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_minfpg);
		
		textField_mintcpg = new JTextField();
		textField_mintcpg.setColumns(10);
		textField_mintcpg.setBounds(222, 208, 86, 20);
		textField_mintcpg.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_mintcpg);
		
		textField_minpcpg = new JTextField();
		textField_minpcpg.setColumns(10);
		textField_minpcpg.setBounds(222, 183, 86, 20);
		textField_minpcpg.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_minpcpg);
				
		textField_minspg = new JTextField();
		textField_minspg.setColumns(10);
		textField_minspg.setBounds(222, 158, 86, 20);
		textField_minspg.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_minspg);
		
		textField_mingpg = new JTextField();
		textField_mingpg.setColumns(10);
		textField_mingpg.setBounds(222, 133, 86, 20);
		textField_mingpg.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_mingpg);

		textField_minsapg = new JTextField();
		textField_minsapg.setBounds(222, 233, 86, 20);
		frmScoutForPlayers.getContentPane().add(textField_minsapg);
		textField_minsapg.setText("0");
		textField_minsapg.setColumns(10);

		textField_maxsapg = new JTextField();
		textField_maxsapg.setColumns(10);
		textField_maxsapg.setBounds(627, 227, 86, 20);
		textField_maxsapg.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_maxsapg);
		
		textField_maxtcpg = new JTextField();
		textField_maxtcpg.setColumns(10);
		textField_maxtcpg.setBounds(627, 202, 86, 20);
		textField_maxtcpg.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_maxtcpg);
		
		textField_maxpcpg = new JTextField();
		textField_maxpcpg.setColumns(10);
		textField_maxpcpg.setBounds(627, 177, 86, 20);
		textField_maxpcpg.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_maxpcpg);
		
		textField_maxspg = new JTextField();
		textField_maxspg.setColumns(10);
		textField_maxspg.setBounds(627, 152, 86, 20);
		textField_maxspg.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_maxspg);
		
		textField_maxgpg = new JTextField();
		textField_maxgpg.setColumns(10);
		textField_maxgpg.setBounds(627, 127, 86, 20);
		textField_maxgpg.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_maxgpg);

		textField_maxfpg = new JTextField();
		textField_maxfpg.setColumns(10);
		textField_maxfpg.setBounds(627, 102, 86, 20);
		textField_maxfpg.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_maxfpg);
		
		textField_maxsa = new JTextField();
		textField_maxsa.setColumns(10);
		textField_maxsa.setBounds(627, 77, 86, 20);
		textField_maxsa.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_maxsa);
				
		textField_maxta = new JTextField();
		textField_maxta.setColumns(10);
		textField_maxta.setBounds(627, 52, 86, 20);
		textField_maxta.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_maxta);
		
		textField_maxpa = new JTextField();
		textField_maxpa.setColumns(10);
		textField_maxpa.setBounds(627, 27, 86, 20);
		textField_maxpa.setText("0");
		frmScoutForPlayers.getContentPane().add(textField_maxpa);
		
	}
}
