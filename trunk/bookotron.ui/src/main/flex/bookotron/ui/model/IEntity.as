package bookotron.ui.model {
public interface IEntity {
    function get id():Number;
    function set id(id:Number):void;
    function get addDate():Date;
    function set addDate(date:Date):void;
    function get modifyDate():Date;
    function set modifyDate(date:Date):void;
    function get addedBy():IUser;
    function set addedBy(user:IUser):void;
    function get modifiedBy():IUser;
    function set modifiedBy(user:IUser):void;
    function set deleted(deleted:Boolean):void;
    function get deleted():Boolean;
}
}