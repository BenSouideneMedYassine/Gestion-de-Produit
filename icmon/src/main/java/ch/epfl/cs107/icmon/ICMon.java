package ch.epfl.cs107.icmon;
import ch.epfl.cs107.icmon.actor.ICMonActor;
import ch.epfl.cs107.icmon.actor.items.ICBall;
import ch.epfl.cs107.icmon.actor.items.ICMonItem;
import ch.epfl.cs107.icmon.gamelogic.actions.LogAction;
import ch.epfl.cs107.icmon.gamelogic.actions.RegisterinAreaAction;
import ch.epfl.cs107.icmon.gamelogic.events.CollectItemEvent;
import ch.epfl.cs107.icmon.gamelogic.events.ICMonEvents;
import ch.epfl.cs107.play.areagame.actor.Interactable;
import ch.epfl.cs107.play.areagame.area.Area;
import ch.epfl.cs107.icmon.actor.ICMonPlayer;
import ch.epfl.cs107.icmon.area.ICMonArea;
import ch.epfl.cs107.play.areagame.AreaGame;
import ch.epfl.cs107.play.engine.actor.Actor;
import ch.epfl.cs107.play.engine.actor.Background;
import ch.epfl.cs107.play.engine.actor.Foreground;
import ch.epfl.cs107.play.engine.actor.OrientedAnimation;
import ch.epfl.cs107.play.io.FileSystem;
import ch.epfl.cs107.play.math.DiscreteCoordinates;
import ch.epfl.cs107.play.math.Orientation;
import ch.epfl.cs107.play.math.Vector;
import ch.epfl.cs107.play.window.Keyboard;
import ch.epfl.cs107.play.window.Window;
import ch.epfl.cs107.icmon.area.maps.Town ;
import ch.epfl.cs107.play.areagame.actor.AreaEntity;
import ch.epfl.cs107.play.areagame.actor.AreaEntity;

import java.util.ArrayList;
import java.util.List;


public class ICMon extends AreaGame {

    /** ??? */
    private ICMonActor ball;
    private RegisterinAreaAction action;
    private ICMonItem item;
    public final static float CAMERA_SCALE_FACTOR = 13.f;
    /** ??? */
    private final String[] areas = {"Town"};
    /** ??? */
    private ICMonPlayer player;
    /** ??? */
    private int areaIndex;
    private List<ICMonEvents>events=new ArrayList<>();
    private List<ICMonEvents>completedEvents=new ArrayList<>();
    private List<ICMonEvents>newEvents=new ArrayList<>();
    private RegisterinAreaAction registerActor;
    private ICMon.ICMonGameState gameState;


    /**
     * ???
     */
    private void createAreas() {
        addArea(new Town());
    }

    /**
     * ???
     * @param window (Window): display context. Not null
     * @param fileSystem (FileSystem): given file system. Not null
     * @return ???
     */
    @Override
    public boolean begin(Window window, FileSystem fileSystem) {
        if (super.begin(window, fileSystem)) {
            createAreas();
            initArea(areas[0]);
            createAreas();
            ICMonItem ball=new ICBall(getCurrentArea(), Orientation.DOWN,new DiscreteCoordinates(6,6),"items/ICBall");
            //ball.perform();
            registerActor= new RegisterinAreaAction(ball,getCurrentArea());
            player = new ICMonPlayer((ICMonArea)getCurrentArea(), Orientation.DOWN, new DiscreteCoordinates(5, 5), "Player",gameState);
            player.enterArea(getCurrentArea(), new DiscreteCoordinates(5, 5));
            player.centerCamera();
            events.add(createCollectItemEvent(ball));
            //gameState=new ICMonGameState();
            //player.setGameState(gameState);
            //setCurrentArea("Town", true);
            return true;
        }
        return false;
    }
    public ICMonEvents createCollectItemEvent(ICMonItem item){
        ICMonEvents event=new CollectItemEvent(item,player);
        LogAction firstAction = new LogAction("CollecttItemEvent started !");
        RegisterinAreaAction addBall=new RegisterinAreaAction(ball,getCurrentArea());
        event.onStart(firstAction);
        event.start();
        LogAction finalAction=new LogAction("CollectItemEvent completed !");
        event.onComplete(finalAction);
        event.complete();
        return event;
    }



    /**
     * ???
     * @param deltaTime elapsed time since last update, in seconds, non-negative
     */
    @Override
    public void update(float deltaTime) {
        super.update(deltaTime);
        Keyboard keyboard= getCurrentArea().getKeyboard();
        if(keyboard.get(keyboard.R).isDown()){
            begin(getWindow(),getFileSystem());
        }
        for (ICMonEvents event : events) {
            if (event.completed){
                completedEvents.add(event);
            }else{
                newEvents.add(event);
            }
        }
        for (ICMonEvents event: newEvents){
            events.add(event);
            event.update(deltaTime);
            }
        for (ICMonEvents event: completedEvents){
            events.remove(event);
            event.update(deltaTime);}
        newEvents.clear();
        completedEvents.clear();
    }

    /**
     * ???
     */
    @Override
    public void end() {

    }

    /**
     * ???
     * @return ???
     */
    @Override
    public String getTitle() {
        return "ICMon";
    }

    /**
     * ???
     * @param areaKey ???
     */
    private void initArea(String areaKey) {
        ICMonArea area = (ICMonArea) setCurrentArea(areaKey, true);
        DiscreteCoordinates coords = area.getPlayerSpawnPosition();

    }
    public class ICMonGameState{
        public ICMonGameState(){}
        public void acceptInteraction(Interactable interactable , boolean isCellInteraction){
            for(var event : ICMon.this.events)
                interactable.acceptInteraction(event , isCellInteraction);
        }

    }
}