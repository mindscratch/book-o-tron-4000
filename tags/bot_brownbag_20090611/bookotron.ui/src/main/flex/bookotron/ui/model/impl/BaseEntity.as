package bookotron.ui.model.impl {
import bookotron.ui.model.*;

public class BaseEntity implements IEntity{

    private var _id:Number;
    private var _addDate:Date;
    private var _modifyDate:Date;
    private var _addedBy:IUser;
    private var _modifiedBy:IUser;
    private var _deleted:Boolean;
    
    public function BaseEntity() {
    }

    public function get id():Number {
        return _id;
    }

    public function set id(id:Number):void {
        _id = id;
    }

    public function get addDate():Date {
        return _addDate;
    }

    public function set addDate(date:Date):void {
        _addDate = date;
    }

    public function get modifyDate():Date {
        return _modifyDate;
    }

    public function set modifyDate(date:Date):void {
        _modifyDate = date;
    }

    public function get addedBy():IUser {
        return _addedBy;
    }

    public function set addedBy(user:IUser):void {
        _addedBy = user;
    }

    public function get modifiedBy():IUser {
        return _modifiedBy;
    }

    public function set modifiedBy(user:IUser):void {
        _modifiedBy = user;
    }


    public function set deleted(deleted:Boolean):void {
        _deleted = deleted;
    }

    public function get deleted():Boolean {
        return _deleted;
    }
}
}