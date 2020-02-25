package Rootag;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;

public class Root extends Agent {
    // connexion bidirectionnel entre l'interface graphique et l'agent=

    @Override
    protected void setup() {
        addBehaviour(new CyclicBehaviour(this) {
            @Override
            public void action() {
                ACLMessage message = receive();
                if (message != null) {
                    System.out.println(message.getContent());
               
                ACLMessage aclmessage = new ACLMessage(ACLMessage.INFORM);
                aclmessage.setContent("ok");
                aclmessage.addReceiver(message.getSender());
                send(message);
                 }
            }
        });

    }

}
