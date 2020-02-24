package sma;

import jade.util.leap.Properties;
import jade.util.ExtendedProperties;
import jade.core.ProfileImpl;
import jade.core.Profile;
import jade.core.Runtime;
import jade.gui.GuiEvent;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class Container implements Runnable {

    private agent Agent;
    int IdAgent;

    public Container(int ID) {
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
            Agent = container.createNewAgent("utilisateur" + IdAgent, "sma.agent", new  Object[]{this});
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
    
    
    public agent getAgent() {
        return Agent;
    }
 
    public void setAgent(agent agent) {
        this.Agent = agent;
    }
    

}
