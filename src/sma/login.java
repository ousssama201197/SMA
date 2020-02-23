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
import java.awt.event.MouseEvent;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JTextField;
import javax.swing.JPasswordField;
import java.sql.*;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class login extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;
    private static int w;
    private static int h;
    private JTextField textField;
    private JPasswordField passwordField;
    
    ResultSet rs;
	Connection con=null;
	
    
    
    
    
	public login(String x) {
	
				 
		Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        h=(int)dimension.getHeight();
        w=(int)dimension.getWidth();
			
		
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
		panel_2.setBounds(0, 80,fw, 92);
		contentPane.add(panel_2);
		panel_2.setLayout(null);
		
		JLabel lblGestionCabinetMedicale = new JLabel("Gestion Cabinet Medicale");
		lblGestionCabinetMedicale.setForeground(Color.WHITE);
		lblGestionCabinetMedicale.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 40));
		lblGestionCabinetMedicale.setBounds((panel_2.getWidth()/2)-251, 13,502, 66);
		panel_2.add(lblGestionCabinetMedicale);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0,173,fw,fh-(panel.getHeight()+panel_2.getHeight()));
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JPanel panel_3 = new JPanel();
	    panel_3.setBackground(new Color(82, 179, 217));
	    int panel3w=551;
	    panel_3.setBounds((fw/2)-(panel3w/2),100,551, 506);
		panel_1.add(panel_3);
		panel_3.setLayout(null);
	
		JButton btnNewButton = new JButton("S'identifier");
		btnNewButton.setBorder(null);
		btnNewButton.setBackground(new Color (38, 166, 91));
		btnNewButton.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		btnNewButton.addActionListener(new ActionListener() {
			@SuppressWarnings("deprecation")
			public void actionPerformed(ActionEvent e) {
//
//                System.out.println("afdfdsfsd");
//                  if (x == "Medecin" ) {
//                	  String[] data=null;
//				       data = medecin.authentifier(textField.getText(), passwordField.getText());
//	                  if(data!=null) {
//	                	  if (data[2]=="") {
//	                	 int nbr_rdv =medecin.nbr_rdv(Integer.parseInt(data[0])); 
//	                	 f2.dispose();
//	                	  new interf_med(data[1],nbr_rdv,Integer.parseInt(data[0]));
//	                	  }
//	                	  else {
//	                		  f2.dispose();
//	                	new interf_chef_srv(Integer.parseInt(data[0]));
//	                	  }
//	                	  
//	                  }else {
//	                	  f2.dispose();
//						  new prelogin();
//	                	  
//	                  }

							
//							
//							
//                  }
//                  
//                  else {// else 1
//                	  if (x=="Receptionniste") {
//                	 	  int id=-1;
//   				       id = receptionniste.authentifier(textField.getText(), passwordField.getText());
//   	                  if(id!=-1) {
//   	                	f2.dispose();
//   	                	 new interf_recc(id);
//   	               	
//   	               }else {
//	                	  f2.dispose();
//							 new prelogin();
//	                	  
//	                  }
//
//                		  
//                		 
//                  }
//                	  
//                	  else { // 2
//                		  if(x=="Infermiere")
//                		  {
//                			 
//                            	  
//                			  
//                			  
//                		  }
//                		  else {
//                			  
//                			  
//                			  
//                			  
//                			  
//                			  
//                		  }
//                		  
//                		  
//                	  }
//                  
//                  
//                  
//                  
//                  } // else 1
//						
//						
//						
//				
//				}
//
//				
//
                        }
		});
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setBounds(223, 406, 146, 42);
		panel_3.add(btnNewButton);
		
		textField = new JTextField();
		textField.setBorder(null);
		textField.setFont(new Font("Tahoma", Font.BOLD, 25));
		textField.setBounds(223, 201, 302, 42);
		textField.setBackground(new Color(238, 238, 238));;
		panel_3.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBorder(null);
		passwordField.setFont(new Font("Tahoma", Font.BOLD, 25));
		passwordField.setBackground(new Color(238, 238, 238));;
		passwordField.setBounds(223, 287, 302, 42);
		panel_3.add(passwordField);
		
		JLabel lblNewLabel_1 = new JLabel("Nom d'utilisateur :");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(35, 205, 161, 33);
		panel_3.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("Mot de passe :");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 20));
		lblNewLabel_2.setBounds(35, 291, 161, 33);
		panel_3.add(lblNewLabel_2);
		
		JLabel lblComme = new JLabel("comme  :");
		lblComme.setForeground(Color.BLACK);
		lblComme.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		lblComme.setBounds(10, 92, 189, 42);
		panel_3.add(lblComme);
		
		JLabel lblNewLabel_3 = new JLabel(x);
		lblNewLabel_3.setForeground(new  Color(44, 62, 80));
		lblNewLabel_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 25));
		lblNewLabel_3.setBounds(150, 84, 264, 59);
		panel_3.add(lblNewLabel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBackground(new Color(1f, 1f, 1f, 0.4f));
		panel_4.setBounds(0, 0, 551, 87);
		panel_3.add(panel_4);
		panel_4.setLayout(null);
		
		JLabel lblSauthentifie = new JLabel("S'authentifier :");
		lblSauthentifie.setBounds(0, 0, 341, 87);
		panel_4.add(lblSauthentifie);
		lblSauthentifie.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 42));
		lblSauthentifie.setForeground(Color.WHITE);
		
		JButton btnNewButton_1 = new JButton("Annuler");
		btnNewButton_1.setForeground(Color.WHITE);
		btnNewButton_1.setBorder(null);
		btnNewButton_1.setBackground(new Color (236,100,75));
		btnNewButton_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
		btnNewButton_1.setBounds(391, 406, 132, 42);
		panel_3.add(btnNewButton_1);
	
		
		
		
		
		JLabel lblNewLabel_4 = new JLabel("");
		ImageIcon icon7 = new ImageIcon(getClass().getResource("img/13.jpg"));
		Image scaleImage4 = icon7.getImage().getScaledInstance(panel_1.getWidth(),panel_1.getHeight(),Image.SCALE_DEFAULT);
		ImageIcon icon8 = new ImageIcon(scaleImage4);
		lblNewLabel_4.setIcon(icon8);
		lblNewLabel_4.setBounds(0, 0,panel_1.getWidth(),panel_1.getHeight());
		panel_1.add(lblNewLabel_4);
		
	
	
		
		
		

		setUndecorated(true);
		this.setResizable(true);
	
		
		setVisible(true);
		


		
}
}
