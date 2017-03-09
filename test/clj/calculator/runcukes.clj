(ns calculator.runcukes
  (:require [clojure.test :refer [deftest is]])
  (:import (cucumber.runtime.io MultiLoader)
           (cucumber.runtime RuntimeOptions)))

(deftest run-cukes
  (let [classloader (.getContextClassLoader (Thread/currentThread))
        runtime-options (RuntimeOptions.
                          (System/getProperties)
                          (into-array ["--format"
                                       "pretty"
                                       "--glue"
                                       "test/acceptance/step_definitions"
                                       "test/acceptance/features"]))
        runtime (cucumber.runtime.Runtime.
                  (MultiLoader. classloader)
                  classloader
                  runtime-options)]
    (doto runtime
      (.writeStepdefsJson)
      (.run))
    (is (= 0 (.exitStatus runtime)))
    ))