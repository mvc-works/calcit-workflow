
(defn read-password [guide]
  (String/valueOf (.readPassword (System/console) guide nil)))

(set-env!
  :resource-paths #{"src"}
  :dependencies '[]
  :repositories #(conj % ["clojars" {:url "https://clojars.org/repo/"
                                     :username "jiyinyiyong"
                                     :password (read-password "Clojars password: ")}]))

(def +version+ "0.1.0")

(deftask deploy []
  (comp
    (pom :project     'mvc-works/calcit-workflow
         :version     +version+
         :description "Workflow"
         :url         "https://github.com/mvc-works/calcit-workflow"
         :scm         {:url "https://github.com/mvc-works/calcit-workflow"}
         :license     {"MIT" "http://opensource.org/licenses/mit-license.php"})
    (jar)
    (install)
    (push :repo "clojars" :gpg-sign false)))
