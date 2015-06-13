(defproject boot-uberjar-mystery "0.1.0-SNAPSHOT"
  :dependencies [[org.clojure/clojure "1.7.0-RC1"]
                 [com.stuartsierra/component "0.2.3"]]
  :uberjar-name "boot-uberjar-mystery.jar"
  :profiles {:uberjar {:aot :all}})
