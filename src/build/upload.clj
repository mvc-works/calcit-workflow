
(ns build.upload
  (:require [clojure.java.shell :refer [sh]]))

(defn -main []
  (println (sh "rsync" "-avr --progress dist/* tiye.me:cdn/coworkflow"))
  (println (sh "rsync" "-avr --progress dist/{index.html,manifest.json} tiye.me:repo/mvc-works/coworkflow/")))
