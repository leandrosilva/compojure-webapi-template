(ns {{name}}.core
  (:use [clojure.data.json :only (json-str)])
  (:use [compojure.core :only [defroutes GET POST]])
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            [ring.adapter.jetty :as ring]))

(defroutes main-routes
  ; curl -XGET http://localhost:8080/
  (GET "/" []
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (json-str {"info" "It's a Web API powered by Compojure"})})

  ; curl -X POST http://localhost:8080/hello/world
  (POST "/hello/:name" [name]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (json-str {"hello" name})})

  ; curl -X POST http://localhost:8080/echo -d 'text=Awesome, baby!'
  (POST "/echo" [text]
    {:status 200
     :headers {"Content-Type" "application/json"}
     :body (json-str {"received" text})})

  (route/resources "/")
  (route/not-found "Page not found"))

(def app
  (handler/site main-routes))

(defn -main []
  (let [port (Integer/parseInt (System/getenv "PORT"))]
    (ring/run-jetty #'{{name}}.core/app {:port port})))
