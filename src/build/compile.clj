
(ns build.compile
  (:require [shadow.cljs.devtools.api :as api]
            [shadow.cljs.devtools.server :as server]
            [clojure.java.shell :refer [sh]]))

(defn -main []
  (api/with-runtime
    (api/watch :browser)))

