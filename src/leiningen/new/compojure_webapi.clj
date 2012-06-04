(ns leiningen.new.compojure-webapi
  (:use [leiningen.new.templates :only [renderer sanitize year ->files]]))

(def render (renderer "compojure_webapi"))

(defn compojure_webapi
  "Create a new Compojure project to build a Web API"
  [name]
  (let [data {:name name
              :sanitized (sanitize name)
              :year (year)}]
    (println
      (str "Generating a project called " name "."))
    (->files data
             [".gitignore"                       (render "gitignore" data)]
             ["project.clj"                      (render "project.clj" data)]
             ["README.md"                        (render "README.md" data)]
             ["resources/public/index.html"      (render "resources/public/index.html" data)]
             ["src/{{sanitized}}/core.clj"       (render "src/webapi/core.clj" data)]
             ["test/{{sanitized}}/test/core.clj" (render "test/webapi/test/core.clj" data)])))
