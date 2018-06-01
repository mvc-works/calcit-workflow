
(ns app.config )

(def dev? (do ^boolean js/goog.DEBUG))

(def site
  {:storage "workflow",
   :dev-ui "http://localhost:8100/main.css",
   :release-ui "http://cdn.tiye.me/favored-fonts/main.css",
   :cdn "http://cdn.tiye.me/calcit-workflow/",
   :cdn-path "calcit-workflow",
   :title "Calcit",
   :icon "http://cdn.tiye.me/logo/mvc-works.png",
   :upload-path "mvc-works/calcit-workflow"})
