#!/usr/bin/env sh

echo 'Testing ImmutableSet'
echo 'Compiling...'
scalac *Immutable*
scala ImmutableTest

echo 'Cleaning up...'
rm *.class

echo 'Testing MutableSet'
echo 'Compiling...'
scalac *Mutable*
scala MutableTest
