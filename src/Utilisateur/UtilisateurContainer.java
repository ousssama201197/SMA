package Utilisateur;

import interfaceGraphique.fenetre;
import jade.util.leap.Properties;
import jade.util.ExtendedProperties;
import jade.core.ProfileImpl;
import jade.core.Profile;
import jade.core.Runtime;
import jade.gui.GuiEvent;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;


public class UtilisateurContainer  implements Runnable{

    private UtilisateurAgent Agent;
    String AgentName;
    fenetre fenetre;
    public UtilisateurContainer(String nom) {
        this.AgentName = nom;
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
            Agent = container.createNewAgent(AgentName, "Utilisateur.UtilisateurAgent", new  Object[]{this});
            Agent.start();
            container.start();
           fenetre =  new fenetre(this);
        } catch (ControllerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
   

    public void envoyerALagent(){
        String message = "1ereM";
        GuiEvent event = new GuiEvent(this,1);
        event.addParameter(message);
        Agent.onGuiEvent(event);
        event =null;
    }
    
    
    public UtilisateurAgent getAgent() {
        return Agent;
    }
 
    public void setAgent(UtilisateurAgent agent) {
        this.Agent = agent;
    }


    void reponse(GuiEvent event) {
      fenetre.affichermessage(event.getParameter(0).toString());

    }


    

}
