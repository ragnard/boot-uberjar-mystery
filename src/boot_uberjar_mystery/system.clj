(ns boot-uberjar-mystery.system
  (:require [clojure.string :as string]
            [com.stuartsierra.component :as component]
            [boot-uberjar-mystery.test-component :as test-component]))


(defn make-system
  []
  (println "Creating system")
  (component/system-map
   :component (test-component/map->TestComponent {})))

