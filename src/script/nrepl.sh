#!/bin/bash

#
# Usage: nrepl.sh <port-number>
#

EXPECTED_ARGS=1
E_BADARGS=65

DO_showUsage() {
    echo "Usage: $(basename $0) <port-number>"
    exit $E_BADARGS
}

if [ $# -ne $EXPECTED_ARGS ]; then
    DO_showUsage
fi

java -cp $HOME/.m2/repository/org/gershwinlang/gershwin/0.2.0-master-SNAPSHOT/gershwin-0.2.0-master-SNAPSHOT.jar:$HOME/.m2/repository/org/gershwinlang/tools.nrepl/0.2.0-master-SNAPSHOT/tools.nrepl-0.2.0-master-SNAPSHOT.jar gershwin.main -e "(do (require '[clojure.tools.nrepl.server :refer [start-server]]) (start-server :port $1))"
