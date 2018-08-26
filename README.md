DEPRECATED
==========
CCP switched of the XML and CREST API on May 8th, 2018. Therefore this library is useless from that day on.

See: https://developers.eveonline.com/blog/article/important-information-on-the-future-of-the-eve-api

[![Maven Central](https://img.shields.io/maven-central/v/com.beimin/eveapi.svg?maxAge=2592000)](http://mvnrepository.com/artifact/com.beimin/eveapi)

This library provides Java parsers that retrieve xml data from the eve-online API and serves that data in easy to handle Java objects.

If you have any questions / suggestions feel free to create an issue on GitHub.

# WARNING #
**Caution**

This library is in maintainance mode from release _7.0.0_ as CCP wants to close the XML API within 18 months!
More information can be found here: https://community.eveonline.com/news/dev-blogs/introducing-esi/

**Caution**

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
    <version>6.0.0</version>
</dependency>
```
Since version 6.0.0 eveapi is available in Maven central (http://mvnrepository.com/artifact/com.beimin/eveapi). 
## Non-maven ##
EveApi depends on the following library:
  * slf4j-api-1.7.12.jar
The previous dependency on commons-digester has been removed in order to make EveAPI compatible with Android.

And you'll need some slf4j implementation like
  * logback-classic-1.1.3.jar + logback-core-1.1.3.jar

You can find where to download those jars [here](http://google.com).

## Online tests ##
The default unit tests are offline against some data downloaded from the API. The online tests are disabled by default and can be executed with:

```shell
mvn clean test -Ponline
```

# Usage #
Generally you can look at the automated unit tests that are available in the source code and can be viewed on GitHub. For instance https://github.com/ZyorTaelon/eveapi/blob/master/src/test/java/com/beimin/eveapi/account/characters/CharactersParserTest.java which tests and shows how to retrieve the list of Characters connected to an API key.

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

# SAXNotRecognizedException on Android #
There seams to be a problem with some XML parser implementation on Android that cause a SAXNotRecognizedException. This can be prevented by disabling secure XML processing with the method _ApiConnector.setSecureXmlProcessing(false)_.

__Warning: Disabling this feature makes the XML parser vulnerable to denial-of-service attacks!__ 

# Documentation of the API #

* http://eveonline-third-party-documentation.readthedocs.io/en/latest/xmlapi/index.html
