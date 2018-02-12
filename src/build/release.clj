
(ns build.release
  (:require [shadow.cljs.devtools.api :as api]
            [clojure.java.shell :refer [sh]]))

(defn sh! [command]
  (println (sh "bash" "-c" command)))

(defn -main []
  (sh! "rm -rf dist/*")
  (api/release :browser)
  (api/compile :ssr)
  (sh! "node target/ssr.js")
  (sh! "cp entry/manifest.json dist/"))
