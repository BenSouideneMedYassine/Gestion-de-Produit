package ch.epfl.cs107.icmon.gamelogic.events;

import ch.epfl.cs107.icmon.actor.ICMonPlayer;
import ch.epfl.cs107.icmon.actor.items.ICBall;
import ch.epfl.cs107.icmon.actor.npc.ICShopAssistant;
import ch.epfl.cs107.icmon.actor.npc.NPCActor;
import ch.epfl.cs107.icmon.area.ICMonBehavior;

public class EndOfTheGameEvent extends ICMonEvents {

    @Override
    public void update(float deltaTime) {

    }

    @Override
    public void interactWith(ICMonPlayer player, boolean isCellInteraction) {
        System.out.println("I heard that you were able to implement this step successfully. Congrats !");
    }

    @Override
    public void interactWith(ICMonBehavior.ICMonCell other, boolean isCellInteraction) {

    }

    @Override
    public void interactWith(ICBall ball, boolean isCellInteraction) {

    }

    @Override
    public void interactWith(ICShopAssistant assistant, boolean isCellInteraction) {

    }


}
