(ns gershwin.test-gershwin.core
  (:require-words [gershwin.test :refer [unit-test]]))

: suite [-- ?]
  ;; Invocation/Application
  #[ 42 ] #[ {:answer 42} :answer apply ] unit-test
  #[ 42 ] #[ 21 21 clojure.core/+ apply2 ] unit-test
  #[ "bazbarfoo" ] #[ "foo" "bar" "baz" clojure.core/str apply3 ] unit-test
  #[ 1 ] #[ 3 2 clojure.core/- apply-swap ] unit-test .
