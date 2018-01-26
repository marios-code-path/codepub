function exitfn {
	MSG=$1; shift
	echo >&2 ${MSG}
	exit 1
}

function exists_or_bail {
	COMMAND=$1; shift
	type $COMMAND > /dev/null 2>&1 || { exitfn "${COMMAND} is required." }
}

[[ -z ${RIFF_HOME} || ${RIFF_HOME} == .* ]] && exitfn "Set env \$RIFF_HOME to (absolute) root of local RIFF clone."

exists_or_bail minikube
exists_or_bail docker