#!/bin/bash

MY_VERSION=$1; shift
DEMO_VERSION=0.0.1

[[ -z ${MY_VERSION//} ]] \
    || DEMO_VERSION=${MY_VERSION}

export DEMO_VERSION

source ../bouncer.sh
source ../dockerfn.sh

set -a -e -v

mvn clean package

pushd ${RIFF_HOME}

    riff create --name democlient --input bandersnatch --protocol pipes --artifact target/demofn-${DEMO_VERSION}.jar --handler com.codepub.demo.DemoConsumer
    riff create --name demofn --input jabberwock --protocol pipes --artifact target/demofn-${DEMO_VERSION}.jar --handler com.codepub.demo.DemoFunction
    riff create --name demosupply --input jubjub --output jabberwock --protocol pipes --artifact target/demofn-${DEMO_VERSION}.jar --handler com.codepub.demo.DemoSupplier
popd