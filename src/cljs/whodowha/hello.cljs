(ns whodowha.hello
      (:require [om.core :as om :include-macros true]
                [whodowha.hello-cljc :as h]))

(enable-console-print!)

(defonce state (atom {}))

(defn hello-cljs []
      (println (h/hello-cljc))
      (println "hello-cljs"))


(defcomponent hello-view [data owner]
              (render [_]
                      (dom/div "Hellow from om")))


(om/root hello-view state
         {:target (. js/document (getElementById "whodowha"))})