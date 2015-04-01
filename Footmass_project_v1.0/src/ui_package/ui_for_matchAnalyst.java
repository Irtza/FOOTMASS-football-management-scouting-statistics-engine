package ui_package;

import javax.swing.JFrame;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JPanel;
import javax.swing.JButton;

import javax.swing.JComboBox;

import footy.Controller_footmass;
import footy.Player;
import footy.Stats;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import java.util.Iterator;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class ui_for_matchAnalyst {

	private JFrame Match_Analyst_Recording_Frame;
	private JTextField textFieldhome;
	private JTextField textFieldaway;

	String home;
	String away;
	
	int a_Passes_Attempted;
	int a_Passes_Completed; 
	int a_Tackles_Attempted;
	int a_Tackles_Completed;
	int a_Shots_Attempted;
	int a_Shots_on_Target;
	int a_Goals;
	int a_Saves;
	int a_Yellow_Cards_Awarded;
	int a_Red_Cards_awarded;
	int a_Fouls_Committed;
	int a_Matches_Played;
	
	int h_Passes_Attempted;
	int h_Passes_Completed; 
	int h_Tackles_Attempted;
	int h_Tackles_Completed;
	int h_Shots_Attempted;
	int h_Shots_on_Target;
	int h_Goals;
	int h_Saves;
	int h_Yellow_Cards_Awarded;
	int h_Red_Cards_awarded;
	int h_Fouls_Committed;
	int h_Matches_Played;
		
	/**
	 * @wbp.parser.entryPoint
	 */
	public  void initialize(String home,String away)
	{		
		Controller_footmass controllerobj = Controller_footmass.getInstance();
		
		Match_Analyst_Recording_Frame = new JFrame();
		Match_Analyst_Recording_Frame.setTitle("Match Recording Center");
		Match_Analyst_Recording_Frame.setVisible(true);
		Match_Analyst_Recording_Frame.setBounds(100, 100, 720, 612);
		Match_Analyst_Recording_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Match_Analyst_Recording_Frame.getContentPane().setLayout(null);

		resetcounter();									//RESET UI VARIABLES
	
		JPanel panel = new JPanel();
		panel.setBounds(56, 20, 237, 500);
		Match_Analyst_Recording_Frame.getContentPane().add(panel);
		panel.setLayout(null);
		
		JLabel lblShot = new JLabel("Shot");
		lblShot.setBounds(10, 139, 46, 14);
		lblShot.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblShot);
		
		JLabel lblPass = new JLabel("Pass");
		lblPass.setBounds(10, 85, 46, 14);
		lblPass.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblPass);
		
		JLabel label_2 = new JLabel("Team Name:");
		label_2.setBounds(10, 37, 105, 14);
		panel.add(label_2);
		
		textFieldhome = new JTextField();
		textFieldhome.setBounds(125, 34, 102, 20);
		textFieldhome.setEditable(false);
		panel.add(textFieldhome);
		textFieldhome.setColumns(10);
		textFieldhome.setText(home);
		
		JLabel lblHomeTeam = new JLabel("Home Team");
		lblHomeTeam.setBounds(10, 7, 107, 19);
		panel.add(lblHomeTeam);
		lblHomeTeam.setFont(new Font("Tahoma", Font.BOLD, 15));
		
		JLabel lblGoal = new JLabel("Card");
		lblGoal.setBounds(10, 268, 75, 14);
		lblGoal.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblGoal);
		
		JLabel lblTackles = new JLabel("Tackle");
		lblTackles.setBounds(10, 219, 75, 14);
		lblTackles.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel.add(lblTackles);
		
		JButton btnpa = new JButton("Attempted");
		btnpa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				h_Passes_Attempted++;
			}
		});
		btnpa.setBounds(106, 83, 121, 23);
		panel.add(btnpa);
		
		JButton btnsa = new JButton("Attempted");
		btnsa.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				h_Shots_Attempted++;
			}
		});
		btnsa.setBounds(106, 137, 121, 23);
		panel.add(btnsa);
		
		JButton btnta = new JButton("Attempted");
		btnta.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				h_Tackles_Attempted++;
			}
		});
		btnta.setBounds(106, 213, 121, 23);
		panel.add(btnta);
		
		JButton btnpc = new JButton("Completed");
		btnpc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				h_Passes_Completed++;
			}
		});
		btnpc.setBounds(106, 103, 121, 23);
		panel.add(btnpc);
		
		JButton btnsont = new JButton("On target");
		btnsont.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				h_Shots_on_Target++;
			}
		});
		btnsont.setBounds(106, 158, 121, 23);
		panel.add(btnsont);
		
		JButton btnGoal = new JButton("Goal");
		btnGoal.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				h_Goals++;
			}
		});
		btnGoal.setBounds(106, 179, 121, 23);
		panel.add(btnGoal);
		
		JButton btntc = new JButton("Completed");
		btntc.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				h_Tackles_Completed++;
			}
		});
		btntc.setBounds(106, 232, 121, 23);
		panel.add(btntc);
		
		JButton btncr = new JButton("Red");
		btncr.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				h_Red_Cards_awarded++;
			}
		});
		btncr.setBounds(106, 285, 121, 23);
		panel.add(btncr);
		
		JButton btncy = new JButton("Yellow");
		btncy.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				h_Yellow_Cards_Awarded++;
			}
		});
		btncy.setBounds(106, 266, 121, 23);
		panel.add(btncy);
		
		JButton btncf = new JButton("Foul");
		btncf.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				h_Fouls_Committed++;
			}
		});
		btncf.setBounds(106, 305, 121, 23);
		panel.add(btncf);
		
		JLabel lblPlayerHome = new JLabel("Player with ball possession :");
		lblPlayerHome.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlayerHome.setBounds(10, 397, 185, 14);
		panel.add(lblPlayerHome);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(412, 20, 237, 500);
		Match_Analyst_Recording_Frame.getContentPane().add(panel_3);
		panel_3.setLayout(null);
		
		JLabel label = new JLabel("Shot");
		label.setBounds(10, 139, 46, 14);
		label.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(label);
		
		JLabel label_1 = new JLabel("Pass");
		label_1.setBounds(10, 85, 46, 14);
		label_1.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(label_1);
		
		JLabel label_3 = new JLabel("Team Name:");
		label_3.setBounds(10, 37, 102, 14);
		panel_3.add(label_3);
		
		textFieldaway = new JTextField();
		textFieldaway.setBounds(109, 34, 118, 20);
		textFieldaway.setEditable(false);
		textFieldaway.setColumns(10);
		panel_3.add(textFieldaway);
		textFieldaway.setText(away);
		
		
		JLabel lblAwayTeam = new JLabel("Away Team");
		lblAwayTeam.setBounds(10, 7, 102, 19);
		lblAwayTeam.setFont(new Font("Tahoma", Font.BOLD, 15));
		panel_3.add(lblAwayTeam);
		
		JLabel label_6 = new JLabel("Card");
		label_6.setBounds(10, 268, 46, 14);
		label_6.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(label_6);
		
		JLabel label_7 = new JLabel("Tackle");
		label_7.setBounds(10, 219, 46, 14);
		label_7.setFont(new Font("Tahoma", Font.PLAIN, 14));
		panel_3.add(label_7);
		
		JButton btnpa_1 = new JButton("Attempted");
		btnpa_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a_Passes_Attempted++;
			}
		});
		btnpa_1.setBounds(106, 83, 121, 23);
		panel_3.add(btnpa_1);
		
		JButton btnsa_1 = new JButton("Attempted");
		btnsa_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a_Shots_Attempted++;
			}
		});
		btnsa_1.setBounds(106, 137, 121, 23);
		panel_3.add(btnsa_1);
		
		JButton btnta_1 = new JButton("Attempted");
		btnta_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a_Tackles_Attempted++;
			}
		});
		btnta_1.setBounds(106, 213, 121, 23);
		panel_3.add(btnta_1);
		
		JButton btnpc_1 = new JButton("Completed");
		btnpc_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a_Passes_Completed++;
			}
		});
		btnpc_1.setBounds(106, 103, 121, 23);
		panel_3.add(btnpc_1);
		
		JButton btnsont_1 = new JButton("On target");
		btnsont_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a_Shots_on_Target++;
			}
		});
		btnsont_1.setBounds(106, 158, 121, 23);
		panel_3.add(btnsont_1);
		
		JButton btnGoal_1 = new JButton("Goal");
		btnGoal_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a_Goals++;
			}
		});
		btnGoal_1.setBounds(106, 179, 121, 23);
		panel_3.add(btnGoal_1);
		
		JButton btntc_1 = new JButton("Completed");
		btntc_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a_Tackles_Completed++;
			}
		});
		btntc_1.setBounds(106, 232, 121, 23);
		panel_3.add(btntc_1);
		
		JButton btncr_1 = new JButton("Red");
		btncr_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a_Red_Cards_awarded++;
			}
		});
		btncr_1.setBounds(106, 285, 121, 23);
		panel_3.add(btncr_1);
		
		JButton btncy_1 = new JButton("Yellow");
		btncy_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a_Yellow_Cards_Awarded++;
			}
		});
		btncy_1.setBounds(106, 266, 121, 23);
		panel_3.add(btncy_1);
		
		JButton btncf_1 = new JButton("Foul");
		btncf_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btncf_1.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				a_Fouls_Committed++;
			}
		});
		btncf_1.setBounds(106, 307, 121, 23);
		panel_3.add(btncf_1);
		
		JLabel lblPlayerWithBall = new JLabel("Player with ball possession :");
		lblPlayerWithBall.setFont(new Font("Tahoma", Font.BOLD, 11));
		lblPlayerWithBall.setBounds(10, 397, 185, 14);
		panel_3.add(lblPlayerWithBall);
		
		// Array of strings for the combo boxes
		String [] homenames = new String[30];
		String [] awaynames = new String[30];
		
		//Populating them
		int i=0;
		Iterator<Player> it = controllerobj.get_clublist(home).iterator();
		while (it.hasNext())
		{
			Player homeobj = it.next();
			homenames[i]=homeobj.getName_player();
			i++;
		}
		
		i=0;
		Iterator<Player> jt = controllerobj.get_clublist(away).iterator();
		while (jt.hasNext())
		{
			Player awayobj = jt.next();
			awaynames[i]=awayobj.getName_player();
			i++;
		}
		JComboBox comboBox = new JComboBox(awaynames);
		comboBox.setBounds(65, 422, 162, 20);
		panel_3.add(comboBox);
		
		JButton btnChangePossAway = new JButton("Change possession");
		btnChangePossAway.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Stats stats_curr_a = controllerobj.getplayer(comboBox.getSelectedItem().toString() , away).getMy_stats();
				
				stats_curr_a.setGoals(a_Goals);
				stats_curr_a.setFouls_Committed(a_Fouls_Committed);
				stats_curr_a.setPasses_Attempted(a_Passes_Attempted);
				stats_curr_a.setPasses_Completed(a_Passes_Completed);
				stats_curr_a.setYellow_Cards_Awarded(a_Yellow_Cards_Awarded);
				stats_curr_a.setRed_Cards_awarded(a_Red_Cards_awarded);
				stats_curr_a.setSaves(a_Saves);
				stats_curr_a.setShots_Attempted(a_Shots_Attempted);
				stats_curr_a.setShots_on_Target(a_Shots_on_Target);
				stats_curr_a.setTackles_Attempted(a_Tackles_Attempted);
				stats_curr_a.setTackles_Completed(a_Tackles_Completed);
				
				controllerobj.getplayer(  comboBox.getSelectedItem().toString() , away).setMy_stats(stats_curr_a);
				
				resetcounter();
			}
		});
		btnChangePossAway.setBounds(65, 453, 130, 23);
		panel_3.add(btnChangePossAway);
		
		JComboBox comboBox_1 = new JComboBox(homenames);
		comboBox_1.setBounds(64, 422, 163, 20);
		panel.add(comboBox_1);
		
		JButton btnChangePosshome = new JButton("Change possession");
		btnChangePosshome.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Stats stats_curr = controllerobj.getplayer(comboBox_1.getSelectedItem().toString() , home).getMy_stats();
				
				stats_curr.setGoals(h_Goals);
				stats_curr.setFouls_Committed(h_Fouls_Committed);
				stats_curr.setPasses_Attempted(h_Passes_Attempted);
				stats_curr.setPasses_Completed(h_Passes_Completed);
				stats_curr.setYellow_Cards_Awarded(h_Yellow_Cards_Awarded);
				stats_curr.setRed_Cards_awarded(h_Red_Cards_awarded);
				stats_curr.setSaves(h_Saves);
				stats_curr.setShots_Attempted(h_Shots_Attempted);
				stats_curr.setShots_on_Target(h_Shots_on_Target);
				stats_curr.setTackles_Attempted(h_Tackles_Attempted);
				stats_curr.setTackles_Completed(h_Tackles_Completed);
				
				controllerobj.getplayer(  comboBox_1.getSelectedItem().toString() , home).setMy_stats(stats_curr);
				
				resetcounter();

			}
		});
		btnChangePosshome.setBounds(64, 453, 131, 23);
		panel.add(btnChangePosshome);
		
		JButton btnNewButton = new JButton("Final Whistle !");
		btnNewButton.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				
				Iterator<Player> it = controllerobj.get_clublist(home).iterator();
				while (it.hasNext())
				{
					Player homeobj = it.next();
					homeobj.getMy_stats().setMatches_Played(1);
					//debug here maybe
				}
				
				Iterator<Player> jt = controllerobj.get_clublist(away).iterator();
				while (jt.hasNext())
				{
					Player awayobj = jt.next();
					awayobj.getMy_stats().setMatches_Played(1);
				}
				
				System.out.println("home team has played a match");
				System.out.println("away team has played a match");
				
				resetcounter();
				
				Match_Analyst_Recording_Frame.setVisible(false);
				footmass window = new footmass();
				window.initialize();
			}
		});
		btnNewButton.setBounds(243, 531, 200, 23);
		Match_Analyst_Recording_Frame.getContentPane().add(btnNewButton);
		
		JLabel label_4 = new JLabel("");
		label_4.setIcon(new ImageIcon(".\\data\\images\\free-wallpaper-8.jpg"));
		label_4.setBounds(0, 0, 704, 573);
		Match_Analyst_Recording_Frame.getContentPane().add(label_4);
	}
	public void resetcounter()
	{
		this.a_Passes_Attempted=0;
		this.a_Passes_Completed=0; 
		this.a_Tackles_Attempted=0;
		this.a_Tackles_Completed=0;
		this.a_Shots_Attempted=0;
		this.a_Shots_on_Target=0;
		this.a_Goals=0;
		this.a_Saves=0;
		this.a_Yellow_Cards_Awarded=0;
		this.a_Red_Cards_awarded=0;
		this.a_Fouls_Committed=0;
		this.a_Matches_Played=0;

		this.h_Passes_Attempted=0;
		this.h_Passes_Completed=0; 
		this.h_Tackles_Attempted=0;
		this.h_Tackles_Completed=0;
		this.h_Shots_Attempted=0;
		this.h_Shots_on_Target=0;
		this.h_Goals=0;
		this.h_Saves=0;
		this.h_Yellow_Cards_Awarded=0;
		this.h_Red_Cards_awarded=0;
		this.h_Fouls_Committed=0;
		this.h_Matches_Played=0;
	}
}
