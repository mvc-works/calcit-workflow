
(ns app.comp.container
  (:require-macros [respo.macros :refer [defcomp <> div button span]]
                   [verbosely.core :refer [verbosely!]])
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo.core :refer [create-comp]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]))

(defn on-click [e dispatch!] (dispatch! :inc nil))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel)]
   (div
    {:style (merge ui/global ui/row)}
    (=< "8px" nil)
    (div
     {}
     (button
      {:style ui/button, :inner-text (str "inc " (:data store)), :on {:click on-click}}))
    (comp-reel reel {}))))
