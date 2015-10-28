(ns whodowha.server
  (:require [compojure.core :refer :all]
            [compojure.handler :as handler]
            [compojure.route :as route]))

(defroutes api-routes
           (context "/api" []
                    (GET "/ping" []
                         (str "pong"))
                    (ANY "*" []
                         (route/not-found "Route not found..."))))

(def rest-api
  (handler/api api-routes))