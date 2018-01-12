#!/bin/bash

set -a -e -v

if [ -v $RIFFHOME ]; then
	echo Set \$RIFFHOME root of riff directory.
	exit 0
fi

PROJDIR=`pwd`

mvn clean package

pushd $RIFFHOME
	./riff build -n demofn -v 0.0.1 -f $PROJDIR
	./riff apply -f $PROJDIR
popd
