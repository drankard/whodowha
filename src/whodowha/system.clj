 (ns whodowha.system
  (:use whodowha.services
        ring.server.standalone)
  (:gen-class))

(defonce server (atom nil))

(defn get-handler []
 (-> #'app ))

(defn start-server [options]
 (reset! server
         (serve (get-handler) options))
 (println (str "You can view the site at http://localhost:" (:port options))))

(defn stop-server []
 (.stop @server)
 (reset! server nil))


(defn -main
 ([port]
  (start-server
   {:port (Integer/parseInt port)
    :init init
    :destroy destroy
    :auto-reload?  false
    :open-browser? false}))
 ([]
  (-main "8002")))
