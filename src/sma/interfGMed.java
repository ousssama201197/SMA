package sma;

import java.awt.*;
import java.awt.event.ItemEvent;
import javax.swing.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Image;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.ItemEvent;
import java.awt.event.ItemListener;
import java.awt.event.MouseEvent;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.event.MouseAdapter;
import javax.swing.JTextField;
import javax.swing.ScrollPaneConstants;
import javax.swing.JScrollPane;
import java.sql.*;
import javax.swing.JTabbedPane;
import javax.swing.JTable;
import java.util.Date;
import java.util.Vector;


public class interfGMed extends JFrame {


  private static final long serialVersionUID = 1L;
  private JPanel contentPane;
  private static int w;
  private static int h;

  int fh;
  int fw;
  JPanel panel_2 =new JPanel();
  JPanel panel3=new JPanel();
  JPanel fenetre3_header=new JPanel();

  JButton btnAccuiel=null;
  JButton btnFermerLaSession=null;
  JButton btnAccuiel2=null;
  JButton btnFermerLaSession2=null;

      public interfGMed() {


        Dimension dimension = java.awt.Toolkit.getDefaultToolkit().getScreenSize();
        h=(int)dimension.getHeight();
        w=(int)dimension.getWidth();


        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       // setBounds(0,0,w,h);
        setBounds(w/2-(500),0,1000,1000);
        setUndecorated(true);

        contentPane    = new JPanel();
        contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
        setContentPane(contentPane);
        contentPane.setLayout(null);
        contentPane.setBackground(Color.WHITE);
        JFrame f2=this;

        fh=f2.getHeight();
        fw=f2.getWidth();


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


        JTabbedPane onglet = new JTabbedPane();
        onglet.setBounds(0,81,fw,fh-40);


        panel_2 = new JPanel();
        panel3=new JPanel();

        JPanel p2 =fenetre2();
        JPanel p1 =fenetre1();
        JPanel p3 =fenetre3();
        JPanel p4=fenetre4();

        JScrollPane[] tPan = {new JScrollPane (p1,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_ALWAYS),new JScrollPane(p2,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER), new JScrollPane(p3,ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS,ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER)};
        String[] onglets = {"Recherche","Ajouter","modifier"};


        int i = 0;
        for(JScrollPane pan : tPan){
          onglet.add(onglets[i], pan);

          onglet.setIconAt(i,new ImageIcon("img/"+i+".jpg"));
          i++;
        }

        contentPane.add(onglet);




        f2.addComponentListener(new ComponentAdapter() {
          public void componentResized(ComponentEvent e) {
            int fh=f2.getHeight();
            int fw=f2.getWidth();

            onglet.setSize(fw,fh-40);

            p1.setPreferredSize(new Dimension(1400,1800));
            p2.setPreferredSize(new Dimension(1400,1800));

            panel_2.setSize(fw,71);
            panel3.setSize(fw,71);
            btnFermerLaSession2.setBounds(fw-167, 26, 135, 25);
            btnAccuiel2.setBounds(fw-237, 26,70, 25);
            btnFermerLaSession.setBounds(fw-167, 26, 135, 25);
            btnAccuiel.setBounds(fw-237, 26,70, 25);

            f2.validate();
            f2.repaint();
          }
        });










        setVisible(true);





      }



      ///f0222222222222222222222222222222222222222222222222222222222222222


      public JPanel fenetre2() {


        JTextField nom;
        JTextField prenom;
        JTextField n_telephone;
        JTextField adresse;
        JTextField nom_jeune_fille = new JTextField();
        JTextField n_assurance;
        JTextField e_mail;
        JTextField date_naiss;
        JPanel panel_2_1 = new JPanel();
        JTextField lieu_naiss = new JTextField();



        panel_2_1.setLayout(null);



        panel3.setBackground(new Color(82, 179, 217));


        panel3.setBounds(0, 31,fw, 71);
        panel_2_1.add(panel3);
        panel3.setLayout(null);

        JLabel lblChercherUnmedecin1 = new JLabel("Nouveau medecin");
        lblChercherUnmedecin1.setForeground(Color.WHITE);
        lblChercherUnmedecin1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblChercherUnmedecin1.setBounds(47, 13, 210, 45);
        panel3.add(lblChercherUnmedecin1);


        btnAccuiel2 = new JButton("Accueil");
        btnAccuiel2.setBorder(null);
        btnAccuiel2.setBackground(new Color(82, 179, 217));
        btnAccuiel2.setForeground(Color.WHITE);
        btnAccuiel2.setBounds(fw-220, 26,70, 25);
        btnAccuiel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel3.add(btnAccuiel2);

        btnFermerLaSession2 = new JButton("Se Deconnecter");
        btnFermerLaSession2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {


            int i = JOptionPane.showConfirmDialog(null, "Vous voulez vraiment deconnecter",
                "Veuillez confirmer votre choix",
                JOptionPane.YES_NO_OPTION);
            if(i==1) {



            }else {
              dispose();
              new prelogin();
            }

          }
        });
        btnFermerLaSession2.setBorder(null);
        btnFermerLaSession2.setBackground(new Color(82, 179, 217));
        btnFermerLaSession2.setForeground(Color.WHITE);
        btnFermerLaSession2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnFermerLaSession2.setBounds(fw-150, 26, 135, 25);

        panel3.add(btnFermerLaSession2);

        JPanel panel = new JPanel();
        panel.setBounds(fw/2-(475),0,950, 758);
        panel_2_1.add(panel);
        panel.setLayout(null);

        JLabel label_2 = new JLabel("Nom");
        label_2.setForeground(new Color(0, 153, 204));
        label_2.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label_2.setBounds(54, 141, 97, 21);
        panel.add(label_2);

        JLabel label_3 = new JLabel("Prenom");
        label_3.setForeground(new Color(0, 153, 204));
        label_3.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label_3.setBounds(466, 141, 97, 21);
        panel.add(label_3);

        JLabel label_4 = new JLabel("sexe");
        label_4.setForeground(new Color(0, 153, 204));
        label_4.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label_4.setBounds(54, 342, 97, 21);
        panel.add(label_4);

        JLabel label_5 = new JLabel("Adresse");
        label_5.setForeground(new Color(0, 153, 204));
        label_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label_5.setBounds(54, 283, 97, 21);
        panel.add(label_5);

        JLabel label_6 = new JLabel("Situation familial ");
        label_6.setForeground(new Color(0, 153, 204));
        label_6.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label_6.setBounds(340, 342, 155, 21);

        JLabel label_7 = new JLabel("N\u00B0 telephone");
        label_7.setForeground(new Color(0, 153, 204));
        label_7.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label_7.setBounds(54, 427, 97, 21);
        panel.add(label_7);


        JLabel label_8 = new JLabel("date naissence");
        label_8.setForeground(new Color(0, 153, 204));
        label_8.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label_8.setBounds(54, 207, 142, 21);
        panel.add(label_8);

        date_naiss = new JTextField("annee-mois-jour");
        date_naiss.addFocusListener(new FocusAdapter() {
          @Override
          public void focusGained(FocusEvent e) {
            date_naiss.setText("");
          }
        });





        JComboBox<String> jour = new JComboBox<String>();
        jour.setFont(new Font("Tahoma", Font.PLAIN, 15));
        jour.setModel(new DefaultComboBoxModel<String>(new String[] {"jour","1","2","3","4","5","6","7","8","9","10","11","12","13","14","15","16","17","18","19","20","21","22","23","24","25","26","27","28","29","30","31"}));
        jour.setBounds(209, 207,60,35);
        panel.add(jour);

        JComboBox<String> mois = new JComboBox<String>();
        mois.setFont(new Font("Tahoma", Font.PLAIN, 15));
        mois.setModel(new DefaultComboBoxModel<String>(new String[] {"mois","1","2","3","4","5","6","7","8","9","10","11","12"}));
        mois.setBounds(273, 207,60,35);
        panel.add(mois);

        Date now = new Date();
        @SuppressWarnings("deprecation")
        int s = now.getYear()+1900;
        int debut = 1900;
        Vector<String> result= new Vector<String>();

        while(debut<=s)
        {
          result.add(Integer.toString(debut));
          debut++;
        }


        JComboBox<String> annee = new JComboBox<String>();

        JComboBox<String> comboBox = new JComboBox<String>();
        annee.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {
            Date now = new Date();

            if ((now.getYear()+1900)-Integer.parseInt((String)annee.getSelectedItem())>=14) {

              panel.add(comboBox);
              panel.add(label_6);
              panel.validate();
              panel.repaint();

            }


            else {


              panel.remove(comboBox);
              panel.remove(label_6);
              panel.validate();
              panel.repaint();
            }

          }
        });

        annee.setFont(new Font("Tahoma", Font.PLAIN, 15));
        annee.setModel(new DefaultComboBoxModel<String>(result));
        annee.setBounds(337, 207,60,35);
        panel.add(annee);




        nom = new JTextField();
        nom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nom.setColumns(10);
        nom.setBounds(209, 138, 203, 31);
        panel.add(nom);

        prenom = new JTextField();
        prenom.setFont(new Font("Tahoma", Font.PLAIN, 15));
        prenom.setColumns(10);
        prenom.setBounds(612, 138, 203, 31);
        panel.add(prenom);

        n_telephone = new JTextField();
        n_telephone.setFont(new Font("Tahoma", Font.PLAIN, 15));
        n_telephone.setColumns(10);
        n_telephone.setBounds(209, 427, 203, 31);
        panel.add(n_telephone);

        adresse = new JTextField();
        adresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
        adresse.setColumns(10);
        adresse.setBounds(209, 273, 606, 31);
        panel.add(adresse);

        JLabel label_9 = new JLabel("(Pour les medecin assurer) ");
        label_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
        label_9.setBounds(54, 505, 203, 31);
        panel.add(label_9);


        JButton button_1 = new JButton("Annuler");
        button_1.setForeground(Color.WHITE);
        button_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        button_1.setBackground(new Color(255, 102, 102));
        button_1.setBounds(680, 682, 147, 31);
        panel.add(button_1);

        JComboBox<String> comboBox_1 = new JComboBox<String>();
        comboBox_1.setModel(new DefaultComboBoxModel<String>(new String[] {"Homme", "Femme"}));
        comboBox_1.setFont(new Font("Tahoma", Font.PLAIN, 15));
        comboBox_1.setBounds(209, 340, 122, 27);
        panel.add(comboBox_1);


        JLabel lblNomJauneFille = new JLabel("Nom jeune-fille");
        lblNomJauneFille.setForeground(new Color(0, 153, 204));
        lblNomJauneFille.setFont(new Font("Tahoma", Font.PLAIN, 17));
        lblNomJauneFille.setBounds(610, 340, 142, 21);


        nom_jeune_fille.setFont(new Font("Tahoma", Font.PLAIN, 15));
        nom_jeune_fille.setColumns(10);
        nom_jeune_fille.setBounds(760,340,150, 31);


        comboBox.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {

            if (comboBox.getSelectedItem()=="Mari�e"  && comboBox_1.getSelectedItem()=="Femme") {

              panel.add(lblNomJauneFille);
              panel.add(nom_jeune_fille);
              panel.validate();
              panel.repaint();

            }


            else {


              panel.remove(lblNomJauneFille);
              panel.remove(nom_jeune_fille);
              panel.validate();
              panel.repaint();
            }

          }
        });

        comboBox_1.addItemListener(new ItemListener() {
          public void itemStateChanged(ItemEvent e) {

            if (comboBox.getSelectedItem()=="Mari�e"  && comboBox_1.getSelectedItem()=="Femme") {

              panel.add(lblNomJauneFille);
              panel.add(nom_jeune_fille);
              panel.validate();
              panel.repaint();

            }


            else {


              panel.remove(lblNomJauneFille);
              panel.remove(nom_jeune_fille);
              panel.validate();
              panel.repaint();
            }

          }
        });


        comboBox.setForeground(Color.BLACK);
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"C�libat�re", "Mari�e","Divorc�e"}));
        comboBox.setFont(new Font("Tahoma", Font.PLAIN, 16));
        comboBox.setBounds(466, 340, 127, 27);




        JLabel label_14 = new JLabel("N� assurance");
        label_14.setForeground(new Color(0, 153, 204));
        label_14.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label_14.setBounds(54,545,130, 21);
        panel.add(label_14);


        n_assurance = new JTextField();
        n_assurance.setFont(new Font("Tahoma", Font.PLAIN, 15));
        n_assurance.setColumns(10);
        n_assurance.setBounds(209, 545, 203, 31);
        panel.add(n_assurance);

        JLabel gs= new JLabel("Groupe sanguin");
        gs.setForeground(new Color(0, 153, 204));
        gs.setFont(new Font("Tahoma", Font.PLAIN, 17));
        gs.setBounds(54,595,130, 21);
        panel.add(gs);

        JComboBox<String> gst = new JComboBox<String>();
        gst.setFont(new Font("Tahoma", Font.PLAIN, 15));
        gst.setModel(new DefaultComboBoxModel<String>(new String[] {"Groupe sanguin","A+","A-","B+","B-","AB+","AB-","O+","O-"}));
        gst.setBounds(209,595,70,29);
        panel.add(gst);

        JLabel label_15 = new JLabel("Nationnalit�");
        label_15.setForeground(new Color(0, 153, 204));
        label_15.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label_15.setBounds(466,545,130, 21);
        panel.add(label_15);


        JTextField N = new JTextField();
        N.setFont(new Font("Tahoma", Font.PLAIN, 15));
        N.setColumns(10);
        N.setBounds(612, 545, 203, 31);
        panel.add(N);




        JLabel label_12 = new JLabel("E-mail");
        label_12.setForeground(new Color(0, 153, 204));
        label_12.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label_12.setBounds(466, 431, 97, 21);
        panel.add(label_12);

        e_mail = new JTextField();
        e_mail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        e_mail.setColumns(10);
        e_mail.setBounds(612, 428, 203, 31);
        panel.add(e_mail);

        JLabel label_13 = new JLabel("Lieu naissence");
        label_13.setForeground(new Color(0, 153, 204));
        label_13.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label_13.setBounds(466, 211, 133, 21);
        panel.add(label_13);


        lieu_naiss.setFont(new Font("Tahoma", Font.PLAIN, 15));
        lieu_naiss.setColumns(10);
        lieu_naiss.setBounds(612, 208, 142, 31);
        panel.add(lieu_naiss);







        JButton button = new JButton("Ajouter");
        button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
          }
        });

        button.setForeground(Color.WHITE);
        button.setFont(new Font("Tahoma", Font.PLAIN, 16));
        button.setBackground(new Color(102, 204, 153));
        button.setBounds(466, 682, 147, 31);
        panel.add(button);




        return  panel_2_1;



      }



      public JPanel fenetre1(){

        JPanel panel_1 = new JPanel();
        panel_1.setLayout(null);


        panel_2.setBackground(new Color(82, 179, 217));

        panel_2.setBounds(0, 31,fw, 71);
        panel_1.add(panel_2);
        panel_2.setLayout(null);
        JTextField textField = new JTextField();
        JLabel lblChercherUnmedecin = new JLabel("Rechercher  medecin");
        lblChercherUnmedecin.setForeground(Color.WHITE);
        lblChercherUnmedecin.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblChercherUnmedecin.setBounds(47, 13, 210, 45);
        panel_2.add(lblChercherUnmedecin);


        btnAccuiel = new JButton("Accueil");
        btnAccuiel.setBorder(null);
        btnAccuiel.setBackground(new Color(82, 179, 217));
        btnAccuiel.setForeground(Color.WHITE);
        btnAccuiel.setBounds(fw-220, 26, 70, 25);
        btnAccuiel.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel_2.add(btnAccuiel);

        btnFermerLaSession = new JButton("Se Deconnecter");
        btnFermerLaSession.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {


            int i = JOptionPane.showConfirmDialog(null, "Vous voulez vraiment deconnecter",
                "Veuillez confirmer votre choix",
                JOptionPane.YES_NO_OPTION);
            if(i==1) {



            }else {
              dispose();
              new prelogin();
            }
          }
        });
        btnFermerLaSession.setBorder(null);
        btnFermerLaSession.setBackground(new Color(82, 179, 217));
        btnFermerLaSession.setForeground(Color.WHITE);
        btnFermerLaSession.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnFermerLaSession.setBounds(fw-150, 26, 135, 25);
        panel_2.add(btnFermerLaSession);

        JPanel panel_4 = new JPanel();
        panel_4.setBounds(fw/2-(445),100,890,847);
        panel_1.add(panel_4);
        panel_4.setLayout(null);

        JLabel label = new JLabel("Identifiant  medecin :");
        label.setForeground(new Color(0, 153, 204));
        label.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label.setBounds(89, 65, 169, 31);
        panel_4.add(label);


        textField.setText("");
        textField.setColumns(10);
        textField.setBounds(309, 65, 249, 31);
        panel_4.add(textField);

        JLabel label_1 = new JLabel("Nom");
        label_1.setForeground(new Color(0, 153, 204));
        label_1.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        label_1.setBounds(89, 150, 97, 21);
        panel_4.add(label_1);

        JLabel label_2 = new JLabel("Prenom");
        label_2.setForeground(new Color(0, 153, 204));
        label_2.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        label_2.setBounds(501, 150, 97, 21);
        panel_4.add(label_2);

        JLabel label_3 = new JLabel("Age");
        label_3.setForeground(new Color(0, 153, 204));
        label_3.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        label_3.setBounds(89, 216, 97, 21);
        panel_4.add(label_3);

        JLabel label_4 = new JLabel("sexe");
        label_4.setForeground(new Color(0, 153, 204));
        label_4.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        label_4.setBounds(501, 216, 97, 21);
        panel_4.add(label_4);

        JLabel label_5 = new JLabel("Adresse");
        label_5.setForeground(new Color(0, 153, 204));
        label_5.setFont(new Font("Tahoma", Font.PLAIN, 17));
        label_5.setBounds(89, 292, 97, 21);
        panel_4.add(label_5);

        JLabel label_6 = new JLabel("Situation familial ");
        label_6.setForeground(new Color(0, 153, 204));
        label_6.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        label_6.setBounds(89, 357, 169, 21);
        panel_4.add(label_6);

        JLabel label_7 = new JLabel("N\u00B0 telephone");
        label_7.setForeground(new Color(0, 153, 204));
        label_7.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        label_7.setBounds(89, 428, 97, 21);
        panel_4.add(label_7);

        JButton button = new JButton("Recherche");
        button.setForeground(Color.WHITE);
        button.setBackground(new Color(82, 179, 217));
        button.setBounds(723, 49, 158, 47);
        panel_4.add(button);

        JLabel label_8 = new JLabel("date naissence");
        label_8.setForeground(new Color(0, 153, 204));
        label_8.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        label_8.setBounds(501, 357, 142, 21);
        panel_4.add(label_8);

        JTextField nom = new JTextField();
        nom.setEditable(false);
        nom.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        nom.setForeground(Color.BLACK);
        nom.setColumns(10);
        nom.setBounds(244, 147, 203, 31);
        panel_4.add(nom);

        JTextField prenom = new JTextField();
        prenom.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        prenom.setForeground(Color.BLACK);
        prenom.setEditable(false);
        prenom.setColumns(10);
        prenom.setBounds(647, 147, 203, 31);
        panel_4.add(prenom);

        JTextField situation_f = new JTextField();
        situation_f.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        situation_f.setForeground(Color.BLACK);
        situation_f.setEditable(false);
        situation_f.setColumns(10);
        situation_f.setBounds(244, 354, 203, 31);
        panel_4.add(situation_f);

        JTextField date_naissance = new JTextField();
        date_naissance.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        date_naissance.setForeground(Color.BLACK);
        date_naissance.setEditable(false);
        date_naissance.setColumns(10);
        date_naissance.setBounds(647, 354, 203, 31);
        panel_4.add(date_naissance);

        JTextField n_telephone = new JTextField();
        n_telephone.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        n_telephone.setForeground(Color.BLACK);
        n_telephone.setEditable(false);
        n_telephone.setColumns(10);
        n_telephone.setBounds(244, 425, 203, 31);
        panel_4.add(n_telephone);




        JTextField adresse = new JTextField();
        adresse.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        adresse.setForeground(Color.BLACK);
        adresse.setEditable(false);
        adresse.setColumns(10);
        adresse.setBounds(244, 282, 606, 31);
        panel_4.add(adresse);

        JTextField age = new JTextField();
        age.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        age.setForeground(Color.BLACK);
        age.setEditable(false);
        age.setColumns(10);
        age.setBounds(244, 213, 203, 31);
        panel_4.add(age);

        JTextField sexe = new JTextField();
        sexe.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        sexe.setForeground(Color.BLACK);
        sexe.setEditable(false);
        sexe.setColumns(10);
        sexe.setBounds(647, 213, 203, 31);
        panel_4.add(sexe);



        JLabel label_13 = new JLabel("N\u00B0 assurance");
        label_13.setForeground(new Color(0, 153, 204));
        label_13.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        label_13.setBounds(89, 560, 122, 21);
        panel_4.add(label_13);

        JTextField n_assurance = new JTextField();
        n_assurance.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        n_assurance.setForeground(Color.BLACK);
        n_assurance.setEditable(false);
        n_assurance.setColumns(10);
        n_assurance.setBounds(244,560, 297, 31);
        panel_4.add(n_assurance);   //540

        JLabel label_21 = new JLabel("email");
        label_21.setForeground(new Color(0, 153, 204));
        label_21.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        label_21.setBounds(501, 490, 122, 21);
        panel_4.add(label_21);

        JTextField e_mail = new JTextField();
        e_mail.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        e_mail.setForeground(Color.BLACK);
        e_mail.setEditable(false);
        e_mail.setColumns(10);
        e_mail.setBounds(647,490, 203, 31);
        panel_4.add(e_mail);   //540

        JLabel label_15 = new JLabel("(identifiant : numero assurance ou identifiant de la carte) ");
        label_15.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 15));
        label_15.setBounds(31, 39, 369, 16);
        panel_4.add(label_15);


        JLabel label_20 = new JLabel("Nationnalite");
        label_20.setForeground(new Color(0, 153, 204));
        label_20.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        label_20.setBounds(501, 425, 122, 21);
        panel_4.add(label_20);

        JTextField nas = new JTextField();
        nas.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        nas.setForeground(Color.BLACK);
        nas.setEditable(false);
        nas.setColumns(10);
        nas.setBounds(647,425, 203, 31);
        panel_4.add(nas);   //540








        JLabel label_17 = new JLabel("Nom jeune fille : ");
        label_17.setForeground(new Color(0, 153, 204));
        label_17.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        label_17.setBounds(89, 490, 147, 21);
        panel_4.add(label_17);

        JTextField nom_jeune_fille = new JTextField();
        nom_jeune_fille.setFont(new Font("Microsoft Sans Serif", Font.PLAIN, 17));
        nom_jeune_fille.setForeground(Color.BLACK);
        nom_jeune_fille.setEditable(false);
        nom_jeune_fille.setColumns(10);
        nom_jeune_fille.setBounds(244,  490, 203, 31);
        panel_4.add(nom_jeune_fille);
        button.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
           
          }
        });

        return panel_1;

      }

      public JPanel fenetre3() {

        JPanel fenetre3 = new JPanel();


        fenetre3.setLayout(null);



        JPanel panel3 = new JPanel();
        panel3.setBackground(new Color(82, 179, 217));



        panel3.setBounds(0, 31,fw, 71);
        fenetre3.add(panel3);
        panel3.setLayout(null);

        JLabel lblChercherUnmedecin1 = new JLabel("Modifier les informations du medecin");
        lblChercherUnmedecin1.setForeground(Color.WHITE);
        lblChercherUnmedecin1.setFont(new Font("Tahoma", Font.PLAIN, 19));
        lblChercherUnmedecin1.setBounds(47, 13, 303, 45);
        panel3.add(lblChercherUnmedecin1);


        JButton btnAccuiel2 = new JButton("Accueil");
        btnAccuiel2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {
            //this.dispose();
            //test variable d entre med ou recep ou ..........
          }
        });
        btnAccuiel2.setBorder(null);
        btnAccuiel2.setBackground(new Color(82, 179, 217));
        btnAccuiel2.setForeground(Color.WHITE);
        btnAccuiel2.setBounds(fw-220, 26,70, 25);
        btnAccuiel2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        panel3.add(btnAccuiel2);


        JButton btnFermerLaSession2 = new JButton("Se Deconnecter");
        btnFermerLaSession2.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {


            int i = JOptionPane.showConfirmDialog(null, "Vous voulez vraiment deconnecter",
                "Veuillez confirmer votre choix",
                JOptionPane.YES_NO_OPTION);
            if(i==1) {



            }else {
              dispose();
              new prelogin();
            }
          }
        });
        btnFermerLaSession2.setBorder(null);
        btnFermerLaSession2.setBackground(new Color(82, 179, 217));
        btnFermerLaSession2.setForeground(Color.WHITE);
        btnFermerLaSession2.setFont(new Font("Tahoma", Font.PLAIN, 15));
        btnFermerLaSession2.setBounds(fw-150, 26, 135, 25);

        panel3.add(btnFermerLaSession2);

        JPanel panel = new JPanel();
        panel.setForeground(new Color(51, 204, 255));
        panel.setBounds(fw/2-422, 145, 844, 588);
        fenetre3.add(panel);
        panel.setLayout(null);

        JLabel lblNewLabel = new JLabel("Identifiant medecin");
        lblNewLabel.setForeground(new Color(102, 204, 255));
        lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNewLabel.setBounds(71, 13, 197, 33);
        panel.add(lblNewLabel);

        JTextField id = new JTextField();
        id.setFont(new Font("Tahoma", Font.PLAIN, 15));
        id.setBounds(267, 13, 249, 33);
        panel.add(id);
        id.setColumns(10);

        JLabel lblSituationFamiliale = new JLabel("Situation familiale");
        lblSituationFamiliale.setForeground(new Color(102, 204, 255));
        lblSituationFamiliale.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblSituationFamiliale.setBounds(66, 80, 147, 28);
        panel.add(lblSituationFamiliale);

        JComboBox<String> comboBox = new JComboBox<String>();
        comboBox.setModel(new DefaultComboBoxModel<String>(new String[] {"C�libat�re", "Mariee","Divors�e"}));
        comboBox.setBounds(215, 81, 114, 28);
        panel.add(comboBox);

        JLabel lblNTelephone = new JLabel("N\u00B0 telephone ");
        lblNTelephone.setForeground(new Color(102, 204, 255));
        lblNTelephone.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNTelephone.setBounds(361, 81, 147, 22);
        panel.add(lblNTelephone);

        JTextField n_telephone = new JTextField();
        n_telephone.setFont(new Font("Tahoma", Font.PLAIN, 15));
        n_telephone.setBounds(520, 73, 197, 33);
        panel.add(n_telephone);
        n_telephone.setColumns(10);

        JLabel lblAdresse = new JLabel("Adresse");
        lblAdresse.setForeground(new Color(102, 204, 255));
        lblAdresse.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblAdresse.setBounds(71, 140, 137, 22);
        panel.add(lblAdresse);

        JLabel lblNTelephone_1 = new JLabel("E-mail");
        lblNTelephone_1.setForeground(new Color(102, 204, 255));
        lblNTelephone_1.setFont(new Font("Tahoma", Font.PLAIN, 16));
        lblNTelephone_1.setBounds(71, 206, 137, 22);
        panel.add(lblNTelephone_1);

        JTextField adresse = new JTextField();
        adresse.setFont(new Font("Tahoma", Font.PLAIN, 15));
        adresse.setColumns(10);
        adresse.setBounds(215, 132, 502, 33);
        panel.add(adresse);

        JTextField e_mail = new JTextField();
        e_mail.setFont(new Font("Tahoma", Font.PLAIN, 15));
        e_mail.setColumns(10);
        e_mail.setBounds(215, 198, 249, 33);
        panel.add(e_mail);


        JButton b = new JButton("Modifier");
        b.addActionListener(new ActionListener() {
          public void actionPerformed(ActionEvent e) {

          }
        });
        b.setForeground(Color.WHITE);
        b.setBounds(520,240,100,35);
        b.setBackground(new Color(82, 179, 217));
        panel.add(b);











        return fenetre3;



      }


      public JPanel fenetre4() {




        return null;
      }
    }


    