(set-env!
 :source-paths #{"src"}
 :resource-paths #{"resources"}
 :dependencies '[[org.clojure/clojure "1.7.0-RC1"]
                 [com.stuartsierra/component "0.2.3"]])

(deftask build
  []
  (comp (aot :namespace '#{boot-uberjar-mystery.main})
        (pom :project 'boot-uberjar-mystery
             :version "0.1.0")
        (uber)
        (jar :file "boot-uberjar-mystery.jar")))


