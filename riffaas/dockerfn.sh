PARENT=${USERNAME}
DELIM=""

source ./bouncer.sh

function docker_detect {
    [[ -z ${DOCKER_HOST//} ]] && eval $(minikube docker-env)
}

# Single or Double namespace environment is assumed

[[ -z ${PARENT//} ]] && DELIM="/" 

function docker_images {

    docker_detect

    docker images --filter=reference=${PARENT}${DELIM}'*'
}

# input image container name 
function docker_image_by_name {

    IMAGE_NAME=$1; shift

    docker_detect

    docker images --filter=reference=${PARENT}${DELIM}${IMAGE_NAME} --format "{{.ID}}"
}

# input image container name
function docker_rmi_by_name {

    IMAGE_NAME=$1; shift

    docker_detect

    docker rmi `docker_image_by_name ${IMAGE_NAME}`
}