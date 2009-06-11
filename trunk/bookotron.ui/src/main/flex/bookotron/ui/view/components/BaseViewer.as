package bookotron.ui.view.components {

import flash.events.Event;

import mx.containers.VBox;
import mx.logging.ILogger;
import mx.logging.Log;

public class BaseViewer extends VBox{

    private static const logger:ILogger = Log.getLogger("BaseViewer");

    private static const CONFIGURE_IOC:String = "configureIOC";

    public function BaseViewer() {
        super();
        addEventListener(Event.ADDED_TO_STAGE, onAddedToStage);
    }

    private function onAddedToStage(ev:Event):void{
        logger.info("onAddedToStage. Component is being introduced to Parsely");
        dispatchEvent(new Event(CONFIGURE_IOC, true));
    }
}
}