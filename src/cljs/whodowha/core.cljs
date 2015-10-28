(ns ^:figwheel-always whodowha.core
  (:require [om.core :as om :include-macros true]))

(enable-console-print!)

(def big-o-atom (atom {}))

(defcomponent hello [_ owner]
              (render [_]
                      (d/div {:class "application"} "Hellow...")))

(om/root hello big-o-atom
         {:target (. js/document (getElementById "app"))})
