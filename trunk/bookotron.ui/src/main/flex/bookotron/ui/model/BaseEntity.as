package bookotron.ui.model {
public class BaseEntity implements IEntity{

    private var _id:Number;
    private var _addDate:Date;
    private var _modifyDate:Date;
    private var _addedBy:User;
    private var _modifiedBy:User;
    
    public function BaseEntity() {
    }

    public function get id():Number {
        return this._id;
    }

    public function set id(id:Number):void {
        this._id = id;
    }

    public function get addDate():Date {
        return this._addDate;
    }

    public function set addDate(date:Date):void {
        this._addDate = date;
    }

    public function get modifyDate():Date {
        return this._modifyDate;
    }

    public function set modifyDate(date:Date):void {
        this._modifyDate = date;
    }

    public function get addedBy():User {
        return this._addedBy;
    }

    public function set addedBy(user:User):void {
        this._addedBy = user;
    }

    public function get modifiedBy():User {
        return this._modifiedBy;
    }

    public function set modifiedBy(user:User):void {
        this._modifiedBy = user;
    }
}
}