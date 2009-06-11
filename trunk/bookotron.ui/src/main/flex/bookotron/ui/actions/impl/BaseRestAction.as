package bookotron.ui.actions.impl {
import bookotron.ui.net.rest.RestService;

import flash.events.EventDispatcher;

import mx.logging.ILogger;
import mx.logging.Log;

public class BaseRestAction extends EventDispatcher {

    protected var _restService:RestService;

    protected var _serviceUrl:String;

    private static const logger:ILogger = Log.getLogger("BaseRestAction");

    public function BaseRestAction(){}
    
    [Inject]
    public function set restService(restService:RestService):void{
        _restService = restService;
        logger.info("restService injected");
    }

    public function set serviceUrl(serviceUrl:String):void{
       _serviceUrl = serviceUrl;
        logger.info("serviceUrl injected");
    }
}
}