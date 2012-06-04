(ns leiningen.new.compojure-webapi
  (:use [leiningen.new.templates :only [renderer sanitize year ->files]]))

(defn compojure
  "Create a new Compojure project to build a Web API"
  [name]
  (let [data {:name name
              :sanitized (sanitize name)
              :year (year)}
        render #((renderer "compojure_webapi") % data)]
    (->files data
             [".gitignore"                       (render "gitignore")]
             ["project.clj"                      (render "project.clj")]
             ["README.md"                        (render "README.md")]
             ["resources/public/index.html"      (render "resources/public/index.html")]
             ["src/{{sanitized}}/core.clj"       (render "src/webapi/core.clj")]
             ["test/{{sanitized}}/test/core.clj" (render "test/webapi/test/core.clj")])))
