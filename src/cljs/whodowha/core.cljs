(ns ^:figwheel-always whodowha.core
  (:require [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent]]
            [om-tools.dom :as d :include-macros true]))

(enable-console-print!)

(println "Edits to this text should show up in your developer console.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!s"}))


(defcomponent load-indicator [data owner]
              (render [_]
                      (d/div "Hellow from component")))

(om/root load-indicator app-state
         {:target (. js/document (getElementById "whodowha"))})

(defn on-js-reload []

  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

