#!/bin/sh

set -x

helm repo add riffrepo https://riff-charts.storage.googleapis.com
helm repo update

helm search riff

helm install riffrepo/riff --name demo