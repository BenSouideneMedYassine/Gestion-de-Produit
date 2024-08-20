package ch.epfl.cs107.icmon.gamelogic.events;

import ch.epfl.cs107.icmon.actor.ICMonPlayer;
import ch.epfl.cs107.icmon.actor.items.ICBall;
import ch.epfl.cs107.icmon.actor.items.ICMonItem;
import ch.epfl.cs107.icmon.actor.npc.ICShopAssistant;
import ch.epfl.cs107.icmon.actor.npc.NPCActor;
import ch.epfl.cs107.icmon.area.ICMonBehavior;
import ch.epfl.cs107.icmon.gamelogic.actions.Action;

import java.util.ArrayList;
import java.util.List;

public class CollectItemEvent extends ICMonEvents{
    private  ICMonPlayer player;
    private ICMonItem item;

    public CollectItemEvent(ICMonItem item, ICMonPlayer player){
        super(player);
        this.item=item;
    }
    @Override
    public void update(float deltaTime) {
        if(item!=null && item.isCollected()){
            complete();
        }
    }



    public void interactWith(ICShopAssistant assistant , boolean isCellInteraction){
        System.out.println("This is an interaction between the player and ICShopAssistant based on events !");
    }


    @Override
    public void interactWith(ICMonPlayer player, boolean isCellInteraction) {

    }

    @Override
    public void interactWith(ICMonBehavior.ICMonCell other, boolean isCellInteraction) {

    }

    @Override
    public void interactWith(ICBall ball, boolean isCellInteraction) {

    }


}
