# Java-Demo

This is a simple WebProject with SpringBoot and Gradle that gets a WebPage to calculate the perimeter and area of a rectangle.

## How to build it

`./gradlew build`

## How to run it

`./gradlew bootRun`

## What is the product

A .war file is generated

## Tests included

1. There is a small unit test on the Rectangle class (Rectangle.java). It verifies that given a set of know data the methods returns correct data
2. There is a small test that verifies that once deployed, all the web pages are accesible and deliveres the expected content
3. SpringBoot includes a test to verify that the build can be executed


