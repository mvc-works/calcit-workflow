
(ns app.updater (:require [respo.cursor :refer [update-states]]))

(defn updater [store op data op-id op-time]
  (case op :states (update-states store data) :hydrate-storage data store))
