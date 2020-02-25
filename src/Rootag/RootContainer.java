package Rootag;

import Entities.Utilisateur;
import Utilisateur.UtilisateurContainer;
import interfaceGraphique.inscription;
import jade.util.leap.Properties;
import jade.util.ExtendedProperties;
import jade.core.ProfileImpl;
import jade.core.Profile;
import jade.core.Runtime;
import jade.gui.GuiEvent;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import java.util.ArrayList;

public class RootContainer implements Runnable {

    inscription fenetre;
    ArrayList<Utilisateur> users;
    ArrayList<String> centreInt;

    public RootContainer() {
    }

    @Override
    public void run() {
        try {

            Runtime rt = Runtime.instance();
            Properties p = new ExtendedProperties();
            p.setProperty(Profile.MAIN_HOST, "localhost");
            Profile profile = new ProfileImpl(p);
            AgentContainer container = rt.createAgentContainer(profile);
            AgentController Agent = null;
            Agent = container.createNewAgent("Root", "Rootag.Root", new Object[]{this});
            Agent.start();
            container.start();

            // initialisation 
            centreInt = new ArrayList<String>();
            centreInt.add("informatique");
            centreInt.add("Sport");

            fenetre = new inscription(this, centreInt);
            users = new ArrayList<Utilisateur>();

        } catch (ControllerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
    public void autentifier(Utilisateur user) {
         users.add(user);
         new Thread((Runnable) new UtilisateurContainer(4)).start();
    }

}
