[![Build Status](http://didge.my-wan.de/jenkins/job/GitHub%20eve-crest/badge/icon)](http://didge.my-wan.de/jenkins/job/GitHub%20eveapi/)
[![SonarQube Coverage](https://img.shields.io/sonar/http/sonar.qatools.ru/ru.yandex.qatools.allure:allure-core/coverage.svg)](http://didge.my-wan.de/sonar/api/resources?resource=188&depth=0&metrics=coverage&includetrends=true)


This library provides Java parsers that retrieve xml data from the eve-online API and serves that data in easy to handle Java objects.

If you're happy with this lib feel free to make an isk donation to the character "[Perduim Oneraria](https://gate.eveonline.com/Profile/Perduim%20Oneraria)" ingame.

If you have any questions / suggestions feel free to convo / evemail me.

How to use the EveApi library.

# Introduction #

It isn't always evident how this library is best used. This document will explain how you can easily depend on EveApi and how to actually use it in your Java program.


# Building / depending #
## Maven ##
EveApi uses Maven as it's build tool (http://maven.apache.org/).

Then include this dependency in your own pom.xml
```
<dependency>
    <groupId>com.beimin</groupId>
    <artifactId>eveapi</artifactId>
    <version>5.1.3</version>
</dependency>
```
I used to (ab-)use the google code subversion as a maven repository, but since it's shutting down I shall try to get the eveapi releases into a general (maven central) repository. 
```
<repositories>
    <repository>
        <id>eveapi</id>
        <url>https://eveapi.googlecode.com/svn/m2/releases</url>
    </repository>
</repositories>
```
## Non-maven ##
EveApi depends on the following library:
  * slf4j-api-1.7.2.jar
The previous dependency on commons-digester has been removed in order to make EveAPI compatible with Android.

And you'll need some slf4j implementation like
  * logback-classic-1.0.9.jar + logback-core-1.0.9.jar

You can find where to download those jars [here](http://google.com).

# Usage #
Generally you can look at the automated unit tests that are available in the subversion and in the google code web interface. For instance http://code.google.com/p/eveapi/source/browse/eveapi/trunk/src/test/java/com/beimin/eveapi/account/characters/CharactersParserTest.java which tests and shows how to retrieve the list of Characters connected to an API key.

Really all you need is to determine which information you want to retrieve and ergo which Parser you need to use.
```java

CharactersParser parser = CharactersParser.getInstance();
int keyId = 123;
String vCode = "abc";
ApiAuthorization auth = new ApiAuthorization(keyId, vCode);
CharactersResponse response = parser.getResponse(auth);
Collection<EveCharacter> eveCharacters = response.getAll();
```
Which gives you the characters connected to a certain account.

I hope this gets you started with using EveApi.
