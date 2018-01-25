#!/bin/sh -x
# <1>
minikube start --memory=4096

pushd $(go env GOPATH)  #<5>
    # <2>
    git clone -o upstream https://github.com/projectriff/kubernetes-model src/github.com/fabric8io/kubernetes-model/
    git clone -o upstream https://github.com/projectriff/function-sidecar src/github.com/projectriff/function-sidecar/
    git clone -o upstream https://github.com/projectriff/topic-controller src/github.com/projectriff/topic-controller/
    git clone -o upstream https://github.com/projectriff/http-gateway src/github.com/projectriff/http-gateway/

    pushd $RIFF_HOME
        git clone -o upstream https://github.com/projectriff/riff.git
        git clone -o upstream https://github.com/projectriff/function-controller.git
        git clone -o upstream https://github.com/projectriff/java-function-invoker.git
        git clone -o upstream https://github.com/projectriff/node-function-invoker.git
        git clone -o upstream https://github.com/projectriff/shell-function-invoker.git
        git clone -o upstream https://github.com/projectriff/python2-function-invoker.git

        ./build-model upstream riff
        eval $(minikube docker-env)
        ./build-function-sidecar upstream master
        ./build-http-gateway upstream master
        ./build-topic-controller upstream master
        # <3>
        kubectl apply -f config/types
        ./build-function-controller upstream master
        ./build-function-invokers upstream master
        # <4>
        kubectl apply -f config/kafka
        kubectl apply -f config
        kubectl apply -f config/rbac
        kubectl apply -f config/zipkin
    popd
popd
