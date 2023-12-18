package MICDA_VOYAGE;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.border.LineBorder;
import javax.swing.UIManager;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.sql.*;
public class PageConnexion {

	private JFrame frmPageDeConnexion;
	private JTextField txtUsername;
	private JPasswordField txtPassword;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PageConnexion window = new PageConnexion();
					window.frmPageDeConnexion.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PageConnexion() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmPageDeConnexion = new JFrame();
		frmPageDeConnexion.getContentPane().setBackground(new Color(245, 245, 245));
		frmPageDeConnexion.setIconImage(Toolkit.getDefaultToolkit().getImage("/Users/mouhamadoumansourndiaye/Desktop/MouhamadouMansourNdiaye-BabacarWade(MICDA_VOYAGES)/MICDA-VOYAGES.png"));
		//frmPageDeConnexion.setFont(new Font("Dialog", Font.PLAIN, 20));
		//frmPageDeConnexion.setAlwaysOnTop(true);
		frmPageDeConnexion.setTitle("Page de Connexion MICDA VOYAGE");
		frmPageDeConnexion.setBackground(Color.decode("#ffffff"));
		frmPageDeConnexion.setSize(1800, 800);
		
		//frmPageDeConnexion.setBounds(100, 100, 564, 572);
		
		frmPageDeConnexion.getContentPane().setLayout(null);
		
		
		JPanel Input = new JPanel();
		
		JLabel lblNewLabel = new JLabel("MICDA VOYAGE");
		lblNewLabel.setForeground(Color.decode("#ffffff"));
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setFont(new Font("Lao MN", Font.PLAIN, 30));
		lblNewLabel.setBounds(0, 50, 540, 56);
		lblNewLabel.setBackground(Color.decode("#fff"));
		Input.add(lblNewLabel);
		
		
		Input.setBackground(Color.decode("#04224c"));
		Input.setBorder(new LineBorder(new Color(4, 34, 76), 1, true));
		Input.setBounds(500, 50, 500, 650);
		frmPageDeConnexion.getContentPane().add(Input);
		Input.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("Username : ");
		lblNewLabel_1.setForeground(Color.decode("#ffffff"));
		lblNewLabel_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1.setBounds(70, 250, 127, 33);
		Input.add(lblNewLabel_1);
		
		JLabel lblNewLabel_1_1 = new JLabel("Password : ");
		lblNewLabel_1_1.setForeground(Color.decode("#ffffff"));
		lblNewLabel_1_1.setFont(new Font("Lucida Grande", Font.PLAIN, 14));
		lblNewLabel_1_1.setBounds(70, 350, 127, 33);
		Input.add(lblNewLabel_1_1);
		
		txtUsername = new JTextField();
		txtUsername.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtUsername.setBounds(175, 250, 260, 35);
		Input.add(txtUsername);
		txtUsername.setColumns(10);
		
		txtPassword = new JPasswordField();
		txtPassword.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		txtPassword.setBounds(175, 350, 260, 35);
		Input.add(txtPassword);
		frmPageDeConnexion.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JButton btnNewButton = new JButton("Connexion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		btnNewButton.setForeground(new Color(0, 0, 0));
		btnNewButton.setFont(new Font("Lucida Grande", Font.PLAIN, 16));
		btnNewButton.setBounds(200, 450, 150, 41);
		Input.add(btnNewButton);
		
		
		//Connexion bd
		try {
			//charger le serveur
			Class.forName("com.mysql.cj.jdbc.Driver");
			//creer la connexion
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/micda_voyage", "root", "root");
			//creer un etat de connexion
			Statement st = con.createStatement();
			//creer est excuter une requete de selection
			ResultSet res = st.executeQuery("select * from Users");
			//parcour des donnees
			while(res.next()) {
				System.out.println("Nom = "+res.getString(2));
			}
		}catch(Exception e) {
			System.out.println(
					"ERROR :"+e.getMessage());
		}
		
	}
}
