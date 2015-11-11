(ns ^:figwheel-always whodowha.core
  (:require [om.core :as om :include-macros true]
            [om-tools.core :refer-macros [defcomponent defcomponentk]]
            [om-tools.dom :as dom :include-macros true]))

(enable-console-print!)

(println "Edits to this text should show up in your developer console.")

;; define your app data so that it doesn't get over-written on reload

(defonce app-state (atom {:text "Hello world!s"}))

(defcomponent button [data owner]
  (render [_]
    (dom/button #js {:onClick #(js/alert "Cliiiick.. !!")} "Add contact")))

(defcomponent input-text [data owner]
  (render [_]
    (dom/input )))

(defcomponentk label [[:data text] state owner]
  (render [_]
    (dom/span {:style {:width (-> (/ text (- max min))
                                         (* 100)
                                         (int)
                                         (str "%"))}
             :on-mouse-enter #(swap! state assoc :show-text? true)
             :on-mouse-leave #(swap! state assoc :show-text? false)
             }
            (dom/label
              (when (:show-text? @state)
                (str text "/" text))))))

(defcomponentk progress-bar
  [[:data value {min 0} {max 100}] state]
  (render [_]
    (dom/div nil
             (dom/span
               {:style          {:width (-> (/ value (- max min))
                                            (* 100)
                                            (int)
                                            (str "%"))}
                :on-mouse-enter #(swap! state assoc :show-value? true)
                :on-mouse-leave #(swap! state assoc :show-value? false)}
             (when (:show-value? @state)
               (str value "/100"))))))

(defcomponent  load-indicator [data owner]
              (render [_]
                (dom/div
                  (om/build label {:text 300 :noget-state "state"})
                  (om/build progress-bar {:value 66})
                  (om/build button nil)
                  (om/build input-text nil))))

(om/root load-indicator app-state
         {:target (. js/document (getElementById "whodowha"))})

(defn on-js-reload []

  ;; optionally touch your app-state to force rerendering depending on
  ;; your application
  ;; (swap! app-state update-in [:__figwheel_counter] inc)
)

