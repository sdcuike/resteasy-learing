#!/bin/bash

export JAVA_HOME=/opt/jdk8
export CLASSPATH=.:$JAVA_HOME/lib
export PATH=$PATH:$JAVA_HOME/bin


deployDir=$(cd "$(dirname "$0")"; cd ..; pwd)
echo deployDir $deployDir

echo JAVA_HOME:$JAVA_HOME
echo CLASSPATH:$CLASSPATH
echo PATH:$PATH



cd $deployDir

java     $JAVA_OPTS $JAVA_MEM_OPTS    -classpath  $deployDir/config:$deployDir/lib/* com.doctor.guava.classpath.ScanYourPathDemo

