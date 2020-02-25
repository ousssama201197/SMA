package Rootag;

import jade.core.AID;
import jade.core.Agent;
import jade.core.behaviours.CyclicBehaviour;
import jade.core.behaviours.OneShotBehaviour;
import jade.core.behaviours.ParallelBehaviour;
import jade.gui.GuiAgent;
import jade.gui.GuiEvent;
import jade.lang.acl.ACLMessage;

public class Root extends Agent {
    // connexion bidirectionnel entre l'interface graphique et l'agent=

    @Override
    protected void setup() {
        System.out.println("init " + this.getAID());
        ParallelBehaviour p = new ParallelBehaviour();
        addBehaviour(p);
        p.addSubBehaviour(new CyclicBehaviour() {
            @Override
            public void action() {
                ACLMessage message = receive();
                if (message != null) {
                    System.out.println(message.getContent());
                    ACLMessage aclmessage = new ACLMessage(ACLMessage.REQUEST);
                    aclmessage.setContent("ok");
                    aclmessage.addReceiver(new AID("utilisateur4", AID.ISLOCALNAME));
                    send(aclmessage);
                }
            }
        });

    }

}
