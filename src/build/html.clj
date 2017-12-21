
(ns build.html
  (:require [shadow.cljs.devtools.api :as shadow]
            [clojure.java.shell :refer [sh]]))

(defn -main []
  (println "sleep start")
  (sh "sleep 4")
  (println "sleep end ")
  (shadow/watch :browser))