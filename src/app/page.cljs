
(ns app.page
  (:require [respo.render.html :refer [make-string]]
            [shell-page.core :refer [make-page spit slurp]]
            [app.comp.container :refer [comp-container]]
            [app.schema :as schema]
            [reel.schema :as reel-schema]
            [cljs.reader :refer [read-string]]
            [app.config :as config]))

(def base-info
  {:title (:title config/site), :icon (:icon config/site), :ssr nil, :inline-html nil})

(defn dev-page []
  (make-page
   ""
   (merge
    base-info
    {:styles ["/entry/main.css" (:dev-ui config/site)],
     :scripts ["/main.js"],
     :inline-styles []})))

(def preview? (= "preview" js/process.env.prod))

(defn prod-page []
  (let [reel (-> reel-schema/reel (assoc :base schema/store) (assoc :store schema/store))
        html-content (make-string (comp-container reel))
        assets (read-string (slurp "dist/assets.edn"))
        cdn (if preview? "" (str "http://cdn.tiye.me/" (:cdn-path config/site) "/"))
        prefix-cdn (fn [x] (str cdn x))]
    (make-page
     html-content
     (merge
      base-info
      {:styles [(:release-ui config/site)],
       :scripts (map #(-> % :output-name prefix-cdn) assets),
       :ssr "respo-ssr",
       :inline-styles [(slurp "./entry/main.css")]}))))

(defn main! []
  (if (= js/process.env.env "dev")
    (spit "target/index.html" (dev-page))
    (spit "dist/index.html" (prod-page))))
