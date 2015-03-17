# Introduction #

Book-o-tron's should be built and laid out with maven.  The first impl should consist of a parent project with two modules; flex ui and server side application.

## Flex UI ##
The client-side application will take the form a flex-based GUI following traditional mvc and service locator patterns. Communication with the server-side application will be done through flex's own mx.rpc.http.HTTPService and/or mx.rpc.soap.WebService. Data will be exchanged with the server-side through XML or JSON structures. Utilization of an IOC framework like spring actionscript or parsley should be considered to simplify configuration of the flex client.  Testing support will be provided by the flexunit and flexcover projects.

## Server Side Application ##

The Server side application shall consist of 3 core layers: _Resource_, _Service_, and _Data Access_.  Each layer will be packaged into a separate jar file containing all required resources for that layer.  If new functionality is required that falls outside of these layers (i.e. monitoring) then a new jar file will be created which contains the new functionality.  This new functionality will be wired into the existing core layers through the use of Aspects.  This allows the addition and subtraction of non-core functionality without requiring modification to or recompilation of the 3 core layers.

The _Resource_ layer should provide a RESTful style interface to all application data.  Its purpose is to provide a way for a user to interact with book-o-tron without having to use the Flex UI.  A resource will perform its action by calling one or more services.

The _Service_ layer should provide all logical services.  A service should perform its action by making one or more calls to the data access layer within a single transaction.

The _Data Access_ layer should encapsulate all data access CRUD operations.