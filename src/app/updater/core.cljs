
(ns app.updater.core )

(defn updater [store op op-data] (case op :inc (update store :data inc) store))
