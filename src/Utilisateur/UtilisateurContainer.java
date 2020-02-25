package Utilisateur;

import jade.util.leap.Properties;
import jade.util.ExtendedProperties;
import jade.core.ProfileImpl;
import jade.core.Profile;
import jade.core.Runtime;
import jade.gui.GuiEvent;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilisateurContainer  implements Runnable{

    private UtilisateurAgent Agent;
    int IdAgent;

    public UtilisateurContainer(int ID) {
        this.IdAgent = ID;
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
            Agent = container.createNewAgent("utilisateur" + IdAgent, "Utilisateur.UtilisateurAgent", new  Object[]{this});
            Agent.start();
            container.start();

            envoyerALagent();
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
    }
    
    
    public UtilisateurAgent getAgent() {
        return Agent;
    }
 
    public void setAgent(UtilisateurAgent agent) {
        this.Agent = agent;
    }

    void message(GuiEvent g) {
        System.err.println("message");
       GuiEvent event = new GuiEvent(this,2);

        Agent.onGuiEvent(event);
    }
    

}
