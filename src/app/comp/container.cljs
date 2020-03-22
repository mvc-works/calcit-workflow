
(ns app.comp.container
  (:require [hsl.core :refer [hsl]]
            [respo-ui.core :as ui]
            [respo.core :refer [defcomp defeffect <> >> div button textarea span input]]
            [respo.comp.space :refer [=<]]
            [reel.comp.reel :refer [comp-reel]]
            [respo-md.comp.md :refer [comp-md]]
            [app.config :refer [dev?]]))

(defcomp
 comp-container
 (reel)
 (let [store (:store reel)
       states (:states store)
       cursor (or (:cursor states) [])
       state (or (:data states) {:content ""})]
   (div
    {:style (merge ui/global ui/row)}
    (textarea
     {:value (:content state),
      :placeholder "Content",
      :style (merge ui/expand ui/textarea {:height 320}),
      :on-input (fn [e d!] (d! cursor (assoc state :content (:value e))))})
    (=< 8 nil)
    (div
     {:style ui/expand}
     (comp-md "This is some content with `code`")
     (=< "8px" nil)
     (button
      {:style ui/button,
       :inner-text "Run",
       :on-click (fn [e d!] (println (:content state)))}))
    (when dev? (comp-reel (>> states :reel) reel {})))))
