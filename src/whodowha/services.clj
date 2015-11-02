 (ns whodowha.services
  (:use compojure.core
        ring.middleware.resource)
  (:require [compojure.route :as route]
            [compojure.handler :as handler]
            :require [cheshire.core :refer :all]))

(defn init []
 (println "Initializing..."))

(defn destroy []
 (println "Destroying..."))


(defroutes handler
           (GET ["/ping"] []
                (str "pong")))

(def app
 (->
  (handler/site handler)
  (wrap-resource "public")))