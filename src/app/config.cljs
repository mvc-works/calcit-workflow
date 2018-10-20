
(ns app.config
  (:require [app.util :refer [get-env!]] [build.util :refer [get-ip!]])
  (:require-macros [clojure.core.strint :refer [<<]]))

(def bundle-builds #{"release" "local-bundle"})

(def dev?
  (if (exists? js/window)
    (do ^boolean js/goog.DEBUG)
    (not (contains? bundle-builds (get-env! "mode")))))

(def site
  {:storage "workflow",
   :dev-ui (let [ip (get-ip!)] (<< "http://~{ip}:8080/main.js")),
   :release-ui "http://cdn.tiye.me/favored-fonts/main.css",
   :cdn-url "http://cdn.tiye.me/calcit-workflow/",
   :cdn-folder "tiye.me:cdn/calcit-workflow",
   :title "Calcit",
   :icon "http://cdn.tiye.me/logo/mvc-works.png",
   :upload-folder "tiye.me:repo/mvc-works/calcit-workflow/"})
