package ch.epfl.cs107.icmon.handler;

import ch.epfl.cs107.icmon.actor.ICMonPlayer;
import ch.epfl.cs107.icmon.actor.items.ICBall;
import ch.epfl.cs107.icmon.actor.npc.ICShopAssistant;
import ch.epfl.cs107.icmon.actor.npc.NPCActor;
import ch.epfl.cs107.icmon.area.ICMonBehavior;
import ch.epfl.cs107.play.areagame.actor.Interactable;
import ch.epfl.cs107.play.areagame.handler.AreaInteractionVisitor;
import ch.epfl.cs107.play.math.DiscreteCoordinates;

import java.util.List;

public interface ICMonInteractionVisitor extends AreaInteractionVisitor {

    void interactWith(ICMonPlayer player, boolean isCellInteraction);

    void interactWith(ICMonBehavior.ICMonCell other, boolean isCellInteraction);
    void interactWith(ICBall ball, boolean isCellInteraction);
    void interactWith(ICShopAssistant assistant, boolean isCellInteraction);

}
