# Packing2D

[![Build Status](https://travis-ci.org/Sciss/Packing2D.svg?branch=master)](https://travis-ci.org/Sciss/Packing2D)
[![Maven Central](https://maven-badges.herokuapp.com/maven-central/de.sciss/packing2d-core/badge.svg)](https://maven-badges.herokuapp.com/maven-central/de.sciss/packing2d-core)

## statement

Packing2D is a Java library with algorithms for rectangle packing.
It was forked from [here](https://github.com/papuja/2DPackingAlgorithmDemo), the original author is 'papuja'.
The project is licensed under the terms of an [MIT license](http://github.com/Sciss/Packing2D/blob/master/LICENSE).

The fork by Hanns Holger Rutz aims at providing easy maven access. Changes:

- uses [sbt](http://scala-sbt.org/) for building
- base package is `de.sciss.packing2d`
- contains sub-modules for `core` and `demo` (as a library user, you will most likely just use `core`)

Note that the original unit test doesn't seem to work.

## building

This fork builds with [sbt](http://www.scala-sbt.org/) 0.13. To launch the demos, run `sbt prefuse-demos/run`.

## linking

To link to this library from Maven:

    <dependency>
      <groupId>de.sciss</groupId>
      <artifactId>packing2d-core</artifactId>
      <version>0.1.0</version>
    </dependency>

Or sbt:

    "de.sciss" % "packing2d-core" % "0.1.0"

## Original read-me

2DPackingAlgorithmDemo
======================

A visual demonstration of a number of ways how a set of rectangles can be packed.

Strip packing algorithms: First-Fit Decreasing Height (FFDH), Next-Fit Decreasing Height (NFDH) and Best-Fit Decreasing Height (BFDH)
