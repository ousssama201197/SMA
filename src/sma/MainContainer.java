package sma;

import jade.util.leap.Properties;
import jade.util.ExtendedProperties;
import jade.core.ProfileImpl;
import jade.core.Profile;

import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;

public class MainContainer {

    public static void main(String args[]) {
        try {
            Runtime rt = Runtime.instance();
            Properties p = new ExtendedProperties();
            p.setProperty(Profile.GUI, "true");
            Profile profile = new ProfileImpl(p);
            AgentContainer container = rt.createMainContainer(profile);

            container.start();

            new Thread((Runnable) new Container()).start();
        } catch (ControllerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

}
