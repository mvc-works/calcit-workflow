
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.style :as ui]
            [respo.macros :refer [defcomp cursor-> <> div button span]]
            [verbosely.core :refer [verbosely!]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]))

(defn on-click [e dispatch!] (dispatch! :inc nil))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel), states (:states store)]
   (div
    {:style (merge ui/global ui/row)}
    (=< "8px" nil)
    (div
     {}
     (button
      {:style ui/button, :inner-text (str "inc " (:data store)), :on {:click on-click}}))
    (cursor-> :reel comp-reel states reel {}))))
