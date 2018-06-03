
(def config {:clojars-user "jiyinyiyong"
             :package 'mvc-works/calcit-workflow
             :version "0.1.0"
             :github-url "https://github.com/mvc-works/calcit-workflow"
             :description "Workflow"})

(defn read-password [guide]
  (String/valueOf (.readPassword (System/console) guide nil)))

(set-env!
  :resource-paths #{"src"}
  :dependencies '[]
  :repositories #(conj % ["clojars" {:url "https://clojars.org/repo/"
                                     :username (:clojsrs-user config)
                                     :password (read-password "Clojars password: ")}]))

(deftask deploy []
  (comp
    (pom :project     (:package config)
         :version     (:version config)
         :description (:description config)
         :url         (:github-url config)
         :scm         {:url (:github-url config)}
         :license     {"MIT" "http://opensource.org/licenses/mit-license.php"})
    (jar)
    (install)
    (push :repo "clojars" :gpg-sign false)))
