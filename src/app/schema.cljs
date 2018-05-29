
(ns app.schema )

(def config
  {:storage "workflow",
   :dev-ui "http://localhost:8100/main.css",
   :release-ui "http://cdn.tiye.me/favored-fonts/main.css",
   :cdn "http://cdn.tiye.me/calcit-workflow/"})

(def dev? (do ^boolean js/goog.DEBUG))

(def store {:states {}, :content ""})
