package sma;

import jade.core.AID;
import jade.core.Agent;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;

public class agent extends GuiAgent {
    // connexion bidirectionnel entre l'interface graphique et l'agent=

    private Container gui;

    @Override
    protected void setup() {
        // Communication bidirectionnel entre Agent,InterfaceG
        gui = (Container) getArguments()[0];
        // envoyer l'instance du l'agent vers l'interface graphique
        gui.setAgent(this);
        
    }

    @Override
    public void onGuiEvent(GuiEvent event) {
    if(event.getType() == 1){
       String message = (String) event.getParameter(0);
       ACLMessage aclmessage = new ACLMessage(ACLMessage.REQUEST);
       aclmessage.setContent(message);
       aclmessage.addReceiver(new AID("rma",AID.ISLOCALNAME));
       send(aclmessage);
            }
    }

}
