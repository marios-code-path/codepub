#!/bin/bash

#TODO extract from pom?
export DEMO_VERSION=0.0.1

eval $(minikube docker-env)

source ../bouncer.sh
source ../dockerfn.sh

set -a -e -v

PROJDIR=${PWD}

mvn clean package


pushd $RIFF_HOME
    riff create --name demofn --input demo-in --protocol pipes --artifact target/demofn-${DEMO_VERSION}.jar --handler com.codepub.demo.DemoFunction
    riff create --name demosupply --input supply-in --protocol pipes --artifact target/demofn-${DEMO_VERSION}.jar --handler com.codepub.demo.DemoSupplier
#	./riff build -n demofn -v $DEMO_VERSION -f $PROJDIR
# Uh... How do I know when update should be use ? ( kubectl get pods | grep demo ?  )
#	./riff apply -n demofn -v $DEMO_VERSION -f $PROJDIR
popd
