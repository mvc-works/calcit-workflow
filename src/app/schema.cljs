
(ns app.schema )

(def config {:storage "workflow"})

(def dev? (do ^boolean js/goog.DEBUG))

(def store {:states {}, :content ""})
