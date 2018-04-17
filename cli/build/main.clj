
(ns build.main
  (:require [shadow.cljs.devtools.api :as shadow]
            [clojure.java.shell :refer [sh]]))

(defn sh! [command]
  (println command)
  (println (sh "bash" "-c" command)))

(defn watch []
  (shadow/watch :client))

(defn build []
  (sh! "rm -rf dist/*")
  (shadow/release :client)
  (shadow/compile :page)
  (sh! "node target/page.js")
  (sh! "cp entry/manifest.json dist/"))

(defn build-local []
  (sh! "rm -rf dist/*")
  (shadow/release :client)
  (shadow/compile :page)
  (sh! "prod=preview node target/page.js")
  (sh! "cp entry/manifest.json dist/"))

(defn page []
  (shadow/compile :page)
  (sh! "env=dev node target/page.js")
  (sh! "cp entry/manifest.json target/"))
