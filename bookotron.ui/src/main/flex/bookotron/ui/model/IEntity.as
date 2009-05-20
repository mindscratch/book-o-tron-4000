package bookotron.ui.model {
public interface IEntity {
    function get id():Number;
    function set id(id:Number):void;
    function get addDate():Date;
    function set addDate(date:Date):void;
    function get modifyDate():Date;
    function set modifyDate(date:Date):void;
    function get addedBy():User;
    function set addedBy(user:User):void;
    function get modifiedBy():User;
    function set modifiedBy(user:User):void;
}
}