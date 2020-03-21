
(ns app.updater )

(defn updater [store op op-data op-id op-time]
  (case op
    :states
      (let [[cursor new-state] op-data]
        (assoc-in store (concat [:states] cursor [:data]) new-state))
    :content (assoc store :content op-data)
    :hydrate-storage op-data
    store))
