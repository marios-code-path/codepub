#!/bin/sh

source ./bouncer.sh

if exists_or helm
then : OK
else echo "Try homebrew (kubernetes-helm) or ports or apt?"
     exit 1
fi

set -x

helm repo add riffrepo https://riff-charts.storage.googleapis.com
helm repo update

helm search riff

helm install riffrepo/riff --name demo