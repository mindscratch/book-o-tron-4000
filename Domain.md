The link below will display an initial UML Class diagram showing the objects and their properties, more work needs to be done to draw the relationships (figured that could happen once we iron out the objects).

<a href='http://yuml.me/diagram/scruffy/class/[IEntity|getId():Long;setId(Long):void;getAddDate():Date;setAddDate(Date);getModifyDate():Date;setModifyDate(Date):void;getAddedBy():User;setAddedBy(User):void;getModifiedBy():User;setModifiedBy(User):void], [IContent|getTitle():String;setTitle(String):void;getAuthors():Collection-Author-;setAuthors(Collection-Author-):void;getPubDate():Date;setPubDate(Date):void;getTags():Collection-Tag-;setTags(Collection-Tag-);getPublisher():Publisher;setPublisher(Publisher):void;getDescription():String;setDescription(String):void;getReviews():Collection-Review-;setReviews(Collection-Review-):void;getAcquiredDate():Date;setAcquiredDate(Date);getPrice():float;setPrice(float):void], [ITextContent|getNumPages():int;setNumPages(int):void] [Book|isbns:Collection-ISBN-;edition:String;], [Pdf|fileSize:long], [ISBN|value:String], [Author|firstName:String;lastName;authored:Collection-Book-], [Tag|name:String;value:String], [Publisher|name:String;website:String], [Review|user:User;book:Book;text:String;comments:Collection-Comment-], [User|name:String;email:String;lastLogin:Date], [Comment|user:User;review:Review], [IEntity]^[IContent], [IContent]^[ITextContent], [ITextContent]^[Book], [ITextContent]^[Pdf], [IEntity]^[Comment], [IEntity]^[ISBN], [IEntity]^[User], [IEntity]^[Review], [IEntity]^[Publisher], [IEntity]^[Tag], [IEntity]^[Author],'>UML Class Diagram</a>


This snippet is the text pasted into <a href='http://www.yuml.me/diagram/class/draw'>yUML</a> to generate the diagram mentioned above.  This snippet is provided as a copy-paste reference for yUML.

```
[IEntity|getId():Long;setId(Long):void;getAddDate():Date;setAddDate(Date);getModifyDate():Date;setModifyDate(Date):void;getAddedBy():User;setAddedBy(User):void;getModifiedBy():User;setModifiedBy(User):void],

[IContent|getTitle():String;setTitle(String):void;getAuthors():Collection-Author-;setAuthors(Collection-Author-):void;getPubDate():Date;setPubDate(Date):void;getTags():Collection-Tag-;setTags(Collection-Tag-);getPublisher():Publisher;setPublisher(Publisher):void;getDescription():String;setDescription(String):void;getReviews():Collection-Review-;setReviews(Collection-Review-):void;getAcquiredDate():Date;setAcquiredDate(Date);getPrice():float;setPrice(float):void],

[ITextContent|getNumPages():int;setNumPages(int):void]
[Book|isbns:Collection-ISBN-;edition:String;],
[Pdf|fileSize:long],

[ISBN|value:String],
[Author|firstName:String;lastName;authored:Collection-Book-],
[Tag|name:String;value:String],
[Publisher|name:String;website:String],
[Review|user:User;book:Book;text:String;comments:Collection-Comment-],
[User|name:String;email:String;lastLogin:Date],
[Comment|user:User;review:Review],


[IEntity]^[IContent],
[IContent]^[ITextContent],
[ITextContent]^[Book],
[ITextContent]^[Pdf],
[IEntity]^[Comment],
[IEntity]^[ISBN],
[IEntity]^[User],
[IEntity]^[Review],
[IEntity]^[Publisher],
[IEntity]^[Tag],
[IEntity]^[Author],
```