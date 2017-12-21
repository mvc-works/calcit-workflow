
(ns build.watch
  (:require [shadow.cljs.devtools.api :as api]
            [shadow.cljs.devtools.server :as server]
            [clojure.java.shell :refer [sh]]))

(defn -main []
  (server/start!)
  (api/watch :browser))

