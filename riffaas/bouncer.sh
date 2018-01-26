function exitfn {
	MSG=$1; shift
	echo >&2 ${MSG}
	exit 1
}

function exists_or_bail {
	COMMAND=$1; shift
	if type $COMMAND > /dev/null 2>&1
	then : OK
	else 
		exitfn "${COMMAND} is required."
	fi
}

function exists_or {
	COMMAND=$1; shift
	if type $COMMAND > /dev/null 2>&1
	then : OK
	else 
		echo >&2 "${COMMAND} is required."	
		return 1
	fi
	return 0
}

[[ -z ${RIFF_HOME} || ${RIFF_HOME} == .* ]] && exitfn "Set env \$RIFF_HOME to (absolute) root of local RIFF clone."

exists_or_bail minikube
exists_or_bail docker