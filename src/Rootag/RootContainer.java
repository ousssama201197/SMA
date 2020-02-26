package Rootag;

import Entities.Document;
import Entities.Utilisateur;
import Utilisateur.UtilisateurContainer;
import interfaceGraphique.inscription;
import jade.util.leap.Properties;
import jade.util.ExtendedProperties;
import jade.core.ProfileImpl;
import jade.core.Profile;
import jade.core.Runtime;
import jade.wrapper.AgentContainer;
import jade.wrapper.AgentController;
import jade.wrapper.ControllerException;
import java.util.ArrayList;

public class RootContainer implements Runnable {

    
    
    Root agent;
    inscription fenetre;
    ArrayList<Utilisateur> users;
    ArrayList<String> centreInt;
    ArrayList<Document> documents;
    

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
            documents = new ArrayList<Document>();

        } catch (ControllerException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }
    
      public void AjouteDocuments(String path,String userName) {
          Utilisateur user=null;
                      System.err.println("UsersSize :"+users.size() +" "+users.get(0).getCentreInt()+ " "+ userName);

            for(int i=0;i<users.size();i++){
            if(users.get(i).getNom().equals(userName)) {
                user=users.get(i);
            }
        }
          Document doc = new Document(path,user.getCentreInt());
          documents.add(doc);       
    }
    
    public void autentifier(Utilisateur user) {
        boolean Existe=false;
        for(int i=0;i<users.size();i++){
            if(users.get(i).getNom().equals(user.getNom())) Existe = true;
        }
         if(Existe == false){
         users.add(user);
         new Thread((Runnable) new UtilisateurContainer(user)).start();
         }
    }   
    
    public Root getAgent() {
        return agent;
    }

    public void setAgent(Root agent) {
        this.agent = agent;
    }

    public ArrayList<Document>  getDocument(String nom) {
         ArrayList<Document> docs = new ArrayList<Document>();
         if(documents.size() > 0){
         String CentreInt="";       
         System.err.println(nom+" "+users.size());
         for(int i=0;i<users.size();i++){
            if(users.get(i).getNom().equals(nom)) {
            CentreInt = users.get(i).getCentreInt();
            }
        }
         if(!CentreInt.equals("")){
          for(int i=0;i<documents.size();i++){
            if(documents.get(i).getCentreInt().equals(CentreInt)) {
                  docs.add(documents.get(i));
            }
        }
          
    }
         }
         return docs;
      
    }
    
    
    
    

}
