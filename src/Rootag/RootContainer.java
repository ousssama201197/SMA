package Rootag;

import jade.util.leap.Properties;
import jade.util.ExtendedProperties;
import jade.core.ProfileImpl;
import jade.core.Profile;
import jade.core.Runtime;
import jade.gui.GuiEvent;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;

public class RootContainer  implements Runnable{

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
            Agent = container.createNewAgent("Root" , "Rootag.Root", new Object[]{this});
            Agent.start();
            container.start();

        } catch (ControllerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
   
  

}
