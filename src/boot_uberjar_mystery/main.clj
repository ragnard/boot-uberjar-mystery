(ns boot-uberjar-mystery.main
  (:require [com.stuartsierra.component :as component]
            [boot-uberjar-mystery.system :as system])
  (:gen-class))

(defn -main
  [& args]
  (println "Starting system")
  (let [system (component/start (system/make-system))]
    (println "System started")
    (.addShutdownHook (java.lang.Runtime/getRuntime)
                      (Thread. (fn []
                                 (println "Stopping system")
                                 (component/stop system)
                                 (println "System stopped"))))))
