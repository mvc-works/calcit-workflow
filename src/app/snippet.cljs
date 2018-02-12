
(ns app.snippet )

(defn main! []
  (require '[clojure.string :as string])
  (println (string/join "&&" (range 1000)))
  (.clear js/console)
  (defn f [x y] (* x y))
  (println (f 2 4)))
