
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.core
             :refer
             [defcomp cursor-> action-> mutation-> <> div button textarea span input]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]
            [respo-md.comp.md :refer [comp-md]]
            [app.config :refer [dev?]]))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel), states (:states store)]
   (div
    {:style (merge ui/global ui/row)}
    (textarea
     {:value (:content store),
      :placeholder "Content",
      :style (merge ui/expand ui/textarea {:height 320}),
      :on-input (action-> :content (:value %e))})
    (=< "8px" nil)
    (div
     {:style ui/expand}
     (comp-md "This is some content with `code`")
     (=< "8px" nil)
     (button
      {:style ui/button,
       :inner-text (str "run"),
       :on-click (fn [e d! m!] (println (:content store)))}))
    (when dev? (cursor-> :reel comp-reel states reel {})))))
