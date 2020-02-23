package sma;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.MouseMotionAdapter;
import java.lang.management.MemoryManagerMXBean;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.UIManager;

public class prelogin extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	/**
	 * 
	 */

	private JPanel contentPane;
    private static int w;
    private static int h;
    
	public static void main(String[] args) {
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
               h=(int)dimension.getHeight();
               w=(int)dimension.getWidth();  
               new interfGMed();
              // new prelogin();
               
               Runtime runtime = Runtime.getRuntime(); 
               System.out.println("max memory: " + runtime.maxMemory() / 1024);
               
              //new inetf_patient();
               //new interfGMed();
		    //	new interf_dossier_medicale();
					
				
	}


	public prelogin() {
	
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0,0,w,h);
		//setBounds(0,0,1000,1000);
		contentPane    = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(Color.WHITE);
		JFrame f2=this;
		int fh=f2.getHeight();
        int fw=f2.getWidth();
        
       
        
        
        
		JPanel panel = new JPanel();

		panel.setBounds(0, 0,fw, 81);
		panel.setBackground(new Color(82, 179, 217));
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblX = new JLabel("X");
		lblX.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				System.exit(0);
			}
		});
		lblX.setForeground(Color.WHITE);
		
		lblX.setFont(new Font("Tahoma", Font.PLAIN, 35));
		lblX.setBounds(fw-40,22, 33, 36);
		panel.add(lblX);
		
		JLabel label = new JLabel("-");
		label.addMouseListener(new MouseAdapter() {
			@Override
			public void mouseClicked(MouseEvent e) {
				f2.setExtendedState(ICONIFIED);
			}
		});
		label.setForeground(Color.WHITE);
		label.setFont(new Font("Tahoma", Font.PLAIN, 43));
		label.setBounds(fw-80, 22, 26, 36);
		panel.add(label);
	
		JLabel lblLogo = new JLabel("medico-Alg1");
		lblLogo.setForeground(Color.WHITE);
		lblLogo.setFont(new Font("Tahoma", Font.BOLD ,14));
		ImageIcon logo = new ImageIcon(getClass().getResource("img/logo.png"));
		Image logo1 =logo.getImage().getScaledInstance(50,50,Image.SCALE_DEFAULT);
		ImageIcon l = new ImageIcon(logo1);
		lblLogo.setIcon(l);
		lblLogo.setBounds(52, 22, 200, 50);
		panel.add(lblLogo);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(44,62,80));
		panel_2.setBounds(0, 79,fw, 92);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblGestionCabinetMedicale = new JLabel("Gestion Cabinet Medicale");
		lblGestionCabinetMedicale.setForeground(Color.WHITE);
		lblGestionCabinetMedicale.setFont(new Font("Tahoma", Font.PLAIN, 40));
		lblGestionCabinetMedicale.setBounds((panel_2.getWidth()/2)-251, 13,502, 66);
		panel_2.add(lblGestionCabinetMedicale);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0,173,fw,fh-(panel.getHeight()+panel_2.getHeight()));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(1f, 1f, 1f, 0.4f));
		panel_3.setBounds(0, 31, 323, 82);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
		
		JLabel lblSauthentifieComme = new JLabel("S'authentifier comme");
		lblSauthentifieComme.setForeground(new Color(82, 179, 217));
		lblSauthentifieComme.setBackground(Color.WHITE);
		lblSauthentifieComme.setFont(new Font("Tahoma", Font.PLAIN, 28));
		lblSauthentifieComme.setBounds(33, 23, 285, 33);
		panel_3.add(lblSauthentifieComme);
		/*
		JLabel lblNewLabel = new JLabel("");
		ImageIcon icon13 = new ImageIcon(getClass().getResource("img/13.jpg"));
		Image scaleImage7 = icon13.getImage().getScaledInstance(panel_1.getWidth(),panel_1.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon icon14 = new ImageIcon(scaleImage7);
		lblNewLabel.setIcon(icon14);
		lblNewLabel.setBounds(0, 0,panel_1.getWidth(),panel_1.getHeight());
		*/
		
		
		
		
		// panel 4 
		
		JPanel panel_4 = new JPanel();
		int w=879;
	    //panel_4.setBounds(fw/2-(w/2),fh/2-(h/2),w,h);
		panel_4.setBounds(fw/2-(w/2),150,879,500);
		panel_4.setBackground(new Color(1f, 1f, 1f, 0.4f));
		panel_1.add(panel_4);
		panel_4.setLayout(null);
		
	
		
		
		
		
		
		
		JButton btnNewButton = new JButton("Chef cabinet");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   f2.dispose();
				   new login("Chef cabinet");
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton.setBorder(null);
		btnNewButton.setForeground(new Color(82, 179, 217));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.setBounds(38,342, 127, 42);
		panel_4.add(btnNewButton);
		
		
		
		
		
		JLabel label_2 = new JLabel("");
		ImageIcon icon5 = new ImageIcon(getClass().getResource("img/rcp.png"));
		Image scaleImage3 = icon5.getImage().getScaledInstance(260,260,Image.SCALE_DEFAULT);
		ImageIcon icon6 = new ImageIcon(scaleImage3);
		label_2.setIcon(icon6);
		label_2.setBounds(193, 132,235,197);
		panel_4.add(label_2);
		
		
		JLabel label_1 = new JLabel("");
		label_1.setVerticalAlignment(SwingConstants.TOP);
		 ImageIcon icon3 = new ImageIcon(getClass().getResource("img/14.png"));
		Image scaleImage1 = icon3.getImage().getScaledInstance(200,200,Image.SCALE_DEFAULT);
		ImageIcon icon4 = new ImageIcon(scaleImage1);
		label_1.setIcon(icon4);
		label_1.setBounds(474, 121, 178, 175);
		panel_4.add(label_1);
		
		JButton btnNewButton_1 = new JButton("Receptionniste");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				   f2.dispose();
					new login("Receptionniste");
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setForeground(new Color(82, 179, 217));
		btnNewButton_1.setBackground(Color.WHITE);
		btnNewButton_1.setBounds(268, 342, 127, 42);
		panel_4.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Medecin");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			   f2.dispose();
				new login("Medecin");
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_2.setBorder(null);
		btnNewButton_2.setForeground(new Color(82, 179, 217));
		btnNewButton_2.setBackground(Color.WHITE);
		btnNewButton_2.setBounds(511, 342, 127, 42);
		panel_4.add(btnNewButton_2);
		
		JButton btnNewButton_5 = new JButton("Infermiere");
		btnNewButton_5.addActionListener(new ActionListener()
		{
			public void actionPerformed(ActionEvent e) {
				   f2.dispose();
					new login("Infermiere");
			}
		});
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 18));
		btnNewButton_5.setBorder(null);
		btnNewButton_5.setForeground(new Color(82, 179, 217));
		btnNewButton_5.setBackground(Color.WHITE);
		btnNewButton_5.setBounds(729, 342, 127, 42);
		panel_4.add(btnNewButton_5);
		
		JLabel label_3 = new JLabel("");
		ImageIcon icon7 = new ImageIcon(getClass().getResource("img/chef.png"));
		Image scaleImage4 = icon7.getImage().getScaledInstance(260,260,Image.SCALE_DEFAULT);
		ImageIcon icon8 = new ImageIcon(scaleImage4);
		label_3.setIcon(icon8);	
		label_3.setBounds(-34, 132, 208, 185);
		panel_4.add(label_3);
			
		JLabel label_5 = new JLabel("");
		ImageIcon icon11 = new ImageIcon(getClass().getResource("img/inf.png"));
		Image scaleImage6 = icon11.getImage().getScaledInstance(260,260,Image.SCALE_DEFAULT);
		ImageIcon icon12 = new ImageIcon(scaleImage6);
		label_5.setIcon(icon12);
		label_5.setBounds(657, 144, 222, 150);
		panel_4.add(label_5);
		

		
		/*
		
		JLabel lblNewLabel_1 = new JLabel("");
		ImageIcon back = new ImageIcon(getClass().getResource("img/13.jpg"));
		Image back1 = back.getImage().getScaledInstance(panel_1.getWidth(),panel_1.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon back2 = new ImageIcon(back1);
		lblNewLabel_1.setIcon(back2);
		lblNewLabel_1.setBounds(0, 0,panel_1.getWidth(),panel_1.getHeight());
		panel_1.add(lblNewLabel_1);
		
	*/
		
		
		

		setUndecorated(true);
		this.setResizable(true);
	
		
		setVisible(true);
		


		
}
}
