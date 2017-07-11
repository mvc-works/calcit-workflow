
(ns app.comp.container
  (:require-macros [respo.macros :refer [defcomp <> div button span]])
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo.core :refer [create-comp]]
            [respo.comp.space :refer [=<]]))

(defn on-click [e dispatch!] (dispatch! :inc nil))

(defcomp
 comp-container
 (store)
 (div
  {:style (merge ui/global ui/row)}
  (=< "8px" nil)
  (div
   {}
   (button
    {:style ui/button, :inner-text (str "inc " (:data store)), :on {:click on-click}}))))
