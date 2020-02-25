package Utilisateur;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;

public class UtilisateurAgent extends GuiAgent {
    // connexion bidirectionnel entre l'interface graphique et l'agent=

    private UtilisateurContainer gui;

    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage message = receive();
                if (message != null) {
                    System.out.println(message.getContent());
                    GuiEvent g = new GuiEvent(this, 1);
                    g.addParameter(message.getContent());
                    gui.message(g);
                }

            }
        });

        // Communication bidirectionnel entre Agent,InterfaceG
        gui = (UtilisateurContainer) getArguments()[0];
        // envoyer l'instance du l'agent vers l'interface graphique
        gui.setAgent(this);

    }

    @Override
    public void onGuiEvent(GuiEvent event) {

        if (event.getType() == 1) {
            String message = (String) event.getParameter(0);
            ACLMessage aclmessage = new ACLMessage(ACLMessage.INFORM);
            aclmessage.setContent(message);
            aclmessage.addReceiver(new AID("Root", AID.ISLOCALNAME));
            send(aclmessage);
        } else {

        }

    }

}
