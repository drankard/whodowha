(defproject whodowha "0.1.0-SNAPSHOT"
  :description "Combining Clojure and ClojureScript Libraries"

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.48"]
                 [ring "1.3.2"]
                 [compojure "1.3.2"]
                 [org.omcljs/om "0.8.8"]]

  :plugins []


  :source-paths ["src/clj"]
  :test-paths   ["test/clj"]

  :cljsbuild {:builds {:app {:source-paths ["src/cljs"]
                             :test-paths ["test/cljs"]
                             :compiler {:output-to     "resources/public/js/app.js"
                                        :output-dir    "resources/public/js/out"
                                        :source-map    "resources/public/js/out.js.map"
                                        :preamble      ["react/react.min.js"]
                                        :optimizations :none
                                        :pretty-print  true}}}}

  :profiles {
             :dev  {:source-paths ["dev/clj"]
                    :dependencies [[figwheel "0.3.7"]
                                   [figwheel-sidecar "0.3.7" :exclusions [clj-time org.codehaus.plexus/plexus-utils]]]
                    :plugins [[lein-cljsbuild "1.1.0"]
                              [lein-figwheel "0.3.7" :exclusions [org.clojure/clojure org.codehaus.plexus/plexus-utils]]]

                    :figwheel {:http-server-root "public"
                               :server-port 3449
                               :css-dirs ["resources/public/css"]
                               :ring-handler whodowha.server/rest-api}
                    }
             })