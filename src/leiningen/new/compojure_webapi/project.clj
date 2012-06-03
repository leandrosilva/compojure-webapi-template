(defproject {{name}} "1.0.0-SNAPSHOT"
  :description "{{name}}, a Web API powered by Compojure"
  :dependencies [[org.clojure/clojure "1.4.0"]
                 [org.clojure/data.json "0.1.2"]
                 [ring/ring-jetty-adapter "1.1.0"]
                 [compojure "1.0.4"]]
  :plugins [[lein-ring "0.7.0"]]
  :ring {:handler compojure-webapi.core/app})

; To run:
; $ PORT=8080 lein run -m {{name}}.core
