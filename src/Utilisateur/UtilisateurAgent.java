package Utilisateur;

import Entities.Document;
import Entities.Utilisateur;
import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilisateurAgent extends Agent {
    // connexion bidirectionnel entre l'interface graphique et l'agent=

    private UtilisateurContainer gui;

    @Override
    protected void setup() {
        // Communication bidirectionnel entre Agent,InterfaceG
        gui = (UtilisateurContainer) getArguments()[0];
        // envoyer l'instance du l'agent vers l'interface graphique
        gui.setAgent(this);

        addBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage message = receive();
                if (message != null) {
                    if (message.getContent().equals("documentAjoute")) {
                        GuiEvent event = new GuiEvent(this, 1);
                        event.addParameter(message.getContent());
                        gui.reponse(event);
                    } else {
                        try {
                            if (message.getPerformative() == 11) {

                                gui.AfficherContact(message.getContentObject());

                            } else {

                                if ((ArrayList<Document>) message.getContentObject() != null) {
                                    gui.AfficherDocument(message.getContentObject());
                                }

                            }
                        } catch (UnreadableException ex) {
                            Logger.getLogger(UtilisateurAgent.class.getName()).log(Level.SEVERE, null, ex);
                        }
                    }

                }

            }
        });

    }

    public void EnvoiFichier(String m1 ) {

        ACLMessage aclmessage = new ACLMessage(ACLMessage.REQUEST);
        aclmessage.setContent(m1);
        aclmessage.addReceiver(new AID("Root", AID.ISLOCALNAME));
        send(aclmessage);

    }

    public void DemanderDoc(String m1, String m2) {
        ACLMessage aclmessage = new ACLMessage(ACLMessage.REQUEST);
        aclmessage.setContent(m1 + " " + m2);
        aclmessage.addReceiver(new AID("Root", AID.ISLOCALNAME));
        send(aclmessage);

    }

    void DemanderContacts(Utilisateur user) {
        ACLMessage aclmessage = new ACLMessage(ACLMessage.CFP);
        try {
            aclmessage.setContentObject(user);
        } catch (IOException ex) {
            Logger.getLogger(UtilisateurAgent.class.getName()).log(Level.SEVERE, null, ex);
        }
        aclmessage.addReceiver(new AID("Root", AID.ISLOCALNAME));
        send(aclmessage);

    }

    void evaluation(String path, String note) {
         ACLMessage aclmessage = new ACLMessage(ACLMessage.INFORM);
        aclmessage.setContent(path + " " +note);
        aclmessage.addReceiver(new AID("Root", AID.ISLOCALNAME));
        send(aclmessage);
        
    }

}
