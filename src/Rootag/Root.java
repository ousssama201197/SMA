package Rootag;

import Entities.Document;
import Entities.Utilisateur;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.UnreadableException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.logging.Level;
import java.util.logging.Logger;

public class Root extends Agent {

    // connexion bidirectionnel entre l'interface graphique et l'agent=
    RootContainer gui;

    @Override
    protected void setup() {
        gui = (RootContainer) getArguments()[0];
        // envoyer l'instance du l'agent vers l'interface graphique
        gui.setAgent(this);

        ParallelBehaviour p = new ParallelBehaviour();
        addBehaviour(p);
        p.addSubBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage message = receive();
                if (message != null) {
                    String[] msg = message.getContent().split(" ");

                    if (msg.length == 2) {
                        if (message.getPerformative() == 7) {   // INFORM
                            gui.setevaluation(msg[0], msg[1]);

                        } else {

                            try {
                                ArrayList<Document> docs = gui.getDocument(msg[1]);
                                ACLMessage aclmessage = new ACLMessage(ACLMessage.INFORM);
                                aclmessage.setContentObject(docs);
                                aclmessage.addReceiver(message.getSender());
                                send(aclmessage);
                            } catch (IOException ex) {
                                Logger.getLogger(Root.class.getName()).log(Level.SEVERE, null, ex);
                            }

                        }
                    
                } else {
                    if (message.getPerformative() == 3) {
                        try {
                            Utilisateur user = (Utilisateur) message.getContentObject();
                            ArrayList<Utilisateur> Users = gui.getContacts(user.getCentreInt());
                            ACLMessage aclmessage = new ACLMessage(ACLMessage.PROPOSE);
                            aclmessage.setContentObject(Users);
                            aclmessage.addReceiver(message.getSender());
                            send(aclmessage);
                        } catch (UnreadableException ex) {
                            Logger.getLogger(Root.class.getName()).log(Level.SEVERE, null, ex);
                        } catch (IOException ex) {
                            Logger.getLogger(Root.class.getName()).log(Level.SEVERE, null, ex);
                        }

                    } else {
                        ACLMessage aclmessage = new ACLMessage(ACLMessage.CONFIRM);
                        String[] username = message.getSender().getName().split("@");
                        gui.AjouteDocuments(message.getContent(), username[0]);
                        aclmessage.setContent("documentAjoute");
                        System.out.println(message.getContent());
                        aclmessage.addReceiver(message.getSender());
                        send(aclmessage);

                    }
                }
            }
        }
    }

);

    }

}
