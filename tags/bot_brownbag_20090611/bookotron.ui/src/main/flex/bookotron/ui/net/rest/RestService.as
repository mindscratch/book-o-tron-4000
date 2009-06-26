
//http://fbflex.wordpress.com/2008/06/12/a-simple-actionscript-flex-rest-client/

package bookotron.ui.net.rest {
import mx.messaging.messages.HTTPRequestMessage;
import mx.rpc.events.FaultEvent;
import mx.rpc.events.ResultEvent;
import mx.rpc.http.HTTPService;

    //import EnvironmentVars

public class RestService{

    // maintains the base url to which all rest calls will be made
    private var _baseUrl:String;

    // maintains the result format expected back from the server
    private var _resultFormat:String;

    public function RestService(){}

    public function set baseUrl(baseUrl:String):void{
        _baseUrl = baseUrl;
    }

    public function set resultFormat(resultFormat:String):void{
         _resultFormat = resultFormat;
    }

    public function doRestCall(url:String, resultFunction:Function, faultFunction:Function = null,restMethod:String="GET",parms:Object = null):void{

        var httpService:HTTPService = new HTTPService();

        if (restMethod.toUpperCase()!="GET"){

            httpService.method = HTTPRequestMessage.POST_METHOD;
            if (parms == null){
                parms = new Object();
            }

            parms._method = restMethod;

        }else{
            httpService.method = HTTPRequestMessage.GET_METHOD;
        }

        httpService.url = _baseUrl + url;
        httpService.resultFormat = _resultFormat;
        httpService.addEventListener(ResultEvent.RESULT, resultFunction);

        if (faultFunction != null){
            httpService.addEventListener(FaultEvent.FAULT, faultFunction);
        }

        httpService.send(parms);

        }
    }
}