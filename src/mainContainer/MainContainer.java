package mainContainer;


import Rootag.RootContainer;
import Utilisateur.UtilisateurContainer;
import jade.util.leap.Properties;
import jade.util.ExtendedProperties;
import jade.core.ProfileImpl;
import jade.core.Profile;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.ControllerException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class MainContainer {

    
    public static void main(String args[]) {
        
            Runtime rt = Runtime.instance();
            Properties p = new ExtendedProperties();
            p.setProperty(Profile.GUI, "true");
            Profile profile = new ProfileImpl(p);
            AgentContainer container = rt.createMainContainer(profile);
        try {
            container.start();
        } catch (ControllerException ex) {
                   System.err.println("erreur");
        }
            
            int i=1;
            new Thread((Runnable) new RootContainer()).start();
            i=3;
        try {
            Thread.sleep(1000);
        } catch (InterruptedException ex) {
            Logger.getLogger(MainContainer.class.getName()).log(Level.SEVERE, null, ex);
        }
            new Thread((Runnable) new UtilisateurContainer(i)).start();

   

    }

}
