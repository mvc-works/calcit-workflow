
(ns app.main
  (:require [respo.core :refer [render! clear-cache! realize-ssr!]]
            [respo.cursor :refer [mutate]]
            [app.comp.container :refer [comp-container]]
            [cljs.reader :refer [read-string]]
            [app.updater.core :refer [updater]]
            [app.schema :as schema]
            [reel.util :refer [id!]]
            [reel.core :refer [reel-updater *code handle-reload!]]
            [reel.schema :as reel-schema]))

(defonce *reel
  (atom (-> reel-schema/reel (assoc :base schema/store) (assoc :store schema/store))))

(defn dispatch! [op op-data]
  (let [op-id (id!), next-reel (reel-updater updater @*reel op op-data op-id)]
    (reset! *reel next-reel)))

(def mount-target (.querySelector js/document ".app"))

(defn render-app! [renderer]
  (renderer mount-target (comp-container (:store @*reel)) dispatch!))

(def ssr? (some? (js/document.querySelector "meta.respo-ssr")))

(defn main! []
  (if ssr? (render-app! realize-ssr!))
  (render-app! render!)
  (add-watch *reel :changes (fn [] (render-app! render!)))
  (reset! *code {:updater updater, :view comp-container, :base schema/store})
  (println "App started."))

(defn reload! []
  (handle-reload! schema/store updater comp-container *reel clear-cache!)
  (render-app! render!)
  (println "Code updated."))

(set! (.-onload js/window) main!)
