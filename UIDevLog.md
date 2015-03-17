# UI DEV LOG #

## 5/16 - 5/17 ##
  * created bookotron.ui project and began integration with rest of bookotron. utilizing org.spicefactory for di and configuration - see resources/context.xml
  * added support for localization and resource bundles
  * TODO
    * establish logging
    * configure test context and loader
    * stub out base ssig.ui.net.(rest) classes
    * ~~stub out base ssig.ui.model classes in accordance with domain outline~~

## 5/18 ##
  * changed base package from ssig.ui to ssig.ui.bookotron
  * stubbed out base ssig.ui.model classes in accordance with domain outline

## 5/19 ##
  * moved projects out from underneath bookotron.parent
  * created aggregator pom.xml
  * created bookotron.model project
    * implemented interfaces based on those listed on the [Domain](Domain.md) page (still need to have interfaces extend from IEntity and some other things, this will be done when I begin implementing the classes).

## 5/20 ##
  * relocated ssig.**to bookotron.ui** package

## 5/21 ##
  * implemented all interfaces in bookotron.model to provide base implementations

## 5/29 ##
  * implemented a BaseDAO and setup Spring/JPA/Hibernate/HSQL