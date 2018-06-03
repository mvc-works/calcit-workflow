
(ns build.upload
  (:require ["child_process" :as child-process]
            [app.config :as config]))

(defn sh! [command]
  (println command)
  (println (.toString (child-process/execSync command))))

(defn -main []
  (sh! (str "rsync -avr --progress dist/* " (:cdn-folder config/site)))
  (sh! (str "rsync -avr --progress dist/{index.html,manifest.json} "
            (:upload-folder config/site))))
