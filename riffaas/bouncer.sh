function exitfn() {
	MSG=$1; shift
	echo >&2 $MSG
	exit 1
}

[[ -z ${RIFF_HOME} ]] && exitfn "Set env \$RIFF_HOME too root off local RIFF clone."

type minikube > /dev/null 2>&1 || { exitfn "minikube is required."; }
