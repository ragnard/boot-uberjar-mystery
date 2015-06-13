(ns boot-uberjar-mystery.test-component
  (:require [com.stuartsierra.component :as component]))


(defrecord TestComponent
  [thread]
  component/Lifecycle
  (start [this]
    (if thread
      this
      (do
        (println "Starting thread")
        (assoc this :thread (doto (Thread. (fn [] (while true
                                                    (println "Thread running")
                                                    (Thread/sleep 1000))))
                              (.start))))))
  (stop [this]
    (if-not thread
      this
      (do
        (println "Stopping thread")
        (.interrupt thread)
        (.join thread)
        (println "Thread stopped")))))
