DOCKER_REPO=${USERNAME}

function docker_images_repo {
    eval $(minikube docker-env)

    set -v -a

    docker images --filter=reference=${DOCKER_REPO}'*'
}

# image container ID for given repository prefix
function docker_image_of {
    #set -a -e -v
    eval $(minikube docker-env)

    IMAGE_NAME=$1; shift

    docker images --filter=reference=${DOCKER_REPO}'/'${IMAGE_NAME} --format "{{.ID}}"
}

# removes the named image after repository is prefixed
function docker_rmi {

    eval $(minikube docker-env)

    IMAGE_NAME=$1; shift

    docker rmi `docker_image_of ${IMAGE_NAME}`
}