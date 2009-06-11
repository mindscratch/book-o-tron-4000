package bookotron.ui.view.vo {
import bookotron.ui.model.IAuthor;
import bookotron.ui.model.impl.collections.AuthorsCollection;

import flash.events.Event;

[Bindable (event="voValueChanged")]
public class AuthorsVo extends BaseVo{

    private var _authors:AuthorsCollection;

    public function AuthorsVo(){
      _authors = new AuthorsCollection();
    }

    public function set authors(authors:AuthorsCollection):void{
        _authors = authors;
        dispatchEvent(new Event(VO_VALUE_CHANGED));
    }

   public function addAuthor(author:IAuthor):void{
        _authors.addItem(author);
        dispatchEvent(new Event(VO_VALUE_CHANGED));
    }

    public function removeAuthor(author:IAuthor):void{
        var idx:int = _authors.getItemIndex(author);
        if(idx){
            _authors.removeItemAt(idx);
            dispatchEvent(new Event(VO_VALUE_CHANGED));
        }
    }

    public function get authors():AuthorsCollection{
        return _authors;
    }
    
}
}