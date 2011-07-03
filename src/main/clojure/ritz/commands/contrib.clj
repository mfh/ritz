(ns ritz.commands.contrib
  (:use
   [ritz.logging :as logging]
   [ritz.repl-utils.helpers :as helpers]
   [ritz.swank.commands :only [defslimefn]]))

(defslimefn swank-require [connection keys]
  (binding [*ns* (the-ns 'ritz.commands.contrib)]
    (doseq [k (if (seq? keys) keys (list keys))]
      (try
        (require (symbol (str "ritz.commands.contrib." (name k))))
        (catch java.io.FileNotFoundException e
          (logging/trace
           "Exception: %s\n%s" e (helpers/stack-trace-string e)))
        (catch Exception e
          (logging/trace
           "Exception: %s\n%s" e (helpers/stack-trace-string e)))))))
