
(ns app.render
  (:require [respo.render.html :refer [make-string]]
            [shell-page.core :refer [make-page spit slurp]]
            [app.comp.container :refer [comp-container]]
            [app.schema :as schema]))

(def base-info
  {:title "CoWorkflow",
   :icon "http://repo-cdn.b0.upaiyun.com/logo/mvc-works.png",
   :ssr nil,
   :inline-html nil})

(defn dev-page []
  (make-page
   ""
   (merge
    base-info
    {:styles ["http://localhost:8100/main.css"],
     :scripts ["/main.js" "/browser/lib.js" "/browser/main.js"]})))

(def previews? (= "preview" js/process.env.prod))

(defn prod-page []
  (let [html-content (make-string (comp-container schema/store))
        webpack-info (.parse js/JSON (slurp "dist/webpack-manifest.json"))
        cljs-info (.parse js/JSON (slurp "dist/cljs-manifest.json"))
        cdn (if previews? "" "http://repo-cdn.b0.upaiyun.com/coworkflow/")
        prefix-cdn (fn [x] (str cdn x))]
    (make-page
     html-content
     (merge
      base-info
      {:styles ["http://repo-cdn.b0.upaiyun.com/favored-fonts/main.css"
                (prefix-cdn (aget webpack-info "main.css"))],
       :scripts (map
                 prefix-cdn
                 [(-> cljs-info (aget 0) (aget "js-name"))
                  (-> cljs-info (aget 1) (aget "js-name"))]),
       :ssr "respo-ssr"}))))

(defn main! []
  (if (= js/process.env.env "dev")
    (spit "target/index.html" (dev-page))
    (spit "dist/index.html" (prod-page))))
