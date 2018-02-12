
(ns build.main
  (:require [shadow.cljs.devtools.api :as shadow]
            [clojure.java.shell :refer [sh]]))

(def configs {:orgization "mvc-works"
              :name "calcit-workflow"})

(defn sh! [command]
  (println (sh "bash" "-c" command)))

(defn build []
  (sh! "rm -rf dist/*")
  (shadow/release :browser)
  (shadow/compile :ssr)
  (sh! "node target/ssr.js")
  (sh! "cp entry/manifest.json dist/"))

(defn gen-html []
  (shadow/compile :ssr)
  (sh! "env=dev node target/ssr.js")
  (sh! "cp entry/manifest.json target/"))

(defn upload []
  (sh! (str "rsync -avr --progress dist/* tiye.me:cdn/" (:name configs)))
  (sh!
    (str "rsync -avr --progress dist/{index.html,manifest.json} tiye.me:repo/"
      (:orgization configs) "/"
      (:name configs) "/")))
