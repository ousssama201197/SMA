package Utilisateur;

import Entities.Utilisateur;
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
import java.io.File;
import java.io.Serializable;


public class UtilisateurContainer  implements Runnable{

    private UtilisateurAgent Agent;
    Utilisateur utilisateur;
    fenetre fenetre;
    public UtilisateurContainer(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
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
            Agent = container.createNewAgent(utilisateur.getNom(), "Utilisateur.UtilisateurAgent", new  Object[]{this});
            Agent.start();
            container.start();
            
           fenetre =  new fenetre(this);
        } catch (ControllerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }
   
    public void DemanderDocument(){
          System.out.println(utilisateur.getNom());
          Agent.DemanderDoc("DemDoc", utilisateur.getNom());
        
    }

    public void EnvoyerDocument(File fichier){
        Agent.EnvoiFichier(fichier.getPath());
    }
    
    
    
    
    public UtilisateurAgent getAgent() {
        return Agent;
    }
 
    public void setAgent(UtilisateurAgent agent) {
        this.Agent = agent;
    }


    void reponse(GuiEvent event) {
        if(event.getType() == 1)
      fenetre.messageDocumentAjouter();
    }

    void AfficherDocument(Serializable contentObject) {
      fenetre.AfficherListDocuments(contentObject);

    }


    

}
