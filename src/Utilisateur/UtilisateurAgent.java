package Utilisateur;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;
import jade.lang.acl.MessageTemplate;
import java.util.logging.Level;
import java.util.logging.Logger;

public class UtilisateurAgent extends GuiAgent {
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
                    if (message.getContent().equals("ok")) {
                        GuiEvent event = new GuiEvent(this, 2);
                        event.addParameter(message.getContent());
                        gui.reponse(event);
                    }
                }

            }
        });

    }

    @Override
    public void onGuiEvent(GuiEvent ge) {
        if (ge.getType() == 1) {
            ACLMessage aclmessage = new ACLMessage(ACLMessage.REQUEST);
            aclmessage.setContent(ge.getParameter(0).toString());
            aclmessage.addReceiver(new AID("Root", AID.ISLOCALNAME));
            send(aclmessage);
        }

    }

}
