
(ns app.updater (:require [respo.cursor :refer [mutate]]))

(defn updater [store op op-data]
  (case op
    :states (update store :states (mutate op-data))
    :inc (update store :data (fn [x] (+ x 1)))
    store))
