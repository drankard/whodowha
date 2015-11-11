(defproject whodowha "0.1.0-SNAPSHOT"
  :description "FIXME: write this!"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}

  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.122"]
                 [org.clojure/core.async "0.1.346.0-17112a-alpha"]
                 [ring/ring-core "1.4.0"]
                 [ring-server "0.4.0"]
                 [compojure "1.4.0"]
                 [cheshire "5.5.0"]
                 [org.omcljs/om "0.9.0"]
                 [prismatic/om-tools "0.3.12"]
                 [cljs-ajax "0.5.1" :exclusions [org.clojure/clojurescript]]]



  :source-paths ["src/clj"]
  :test-paths   ["test/clj"]

  :clean-targets ^{:protect false} ["resources/public/js/compiled" "target"]

  :ring {:handler       whodowha.services/app
         :init          whodowha.services/init
         :destroy       whodowha.services/destroy
         :port          8080
         :open-browser? false}

  :plugins [[lein-ring "0.9.7"]]
  :uberjar-name "whodowha.jar"
  :min-lein-version "2.0.0"

  :profiles {:dev {:dependencies []
                   :plugins [[lein-cljsbuild "1.1.0"]
                             [lein-figwheel "0.4.1"]]
                   :cljsbuild {
                               :builds [{:id           "dev"
                                         :source-paths ["src/cljs"]

                                         :figwheel     {:on-jsload "whodowha.core/on-js-reload"}

                                         :compiler     {:main                 whodowha.core
                                                        :asset-path           "js/compiled/out"
                                                        :output-to            "resources/public/js/compiled/whodowha.js"
                                                        :output-dir           "resources/public/js/compiled/out"
                                                        :source-map-timestamp true}}
                                        {:id           "min"
                                         :source-paths ["src/cljs"]
                                         :compiler     {:output-to     "resources/public/js/compiled/whodowha.js"
                                                        :main          whodowha.core
                                                        :optimizations :advanced
                                                        :pretty-print  false}}]}}
             :uberjar {:aot  :all
                       :main whodowha.system}}


  :figwheel {
             ;; :http-server-root "public" ;; default and assumes "resources" 
             ;; :server-port 3449 ;; default
             ;; :server-ip "127.0.0.1" 

             :css-dirs ["resources/public/css"]             ;; watch and update CSS

             ;; Start an nREPL server into the running figwheel process
             :nrepl-port 7888

             ;; Server Ring Handler (optional)
             ;; if you want to embed a ring handler into the figwheel http-kit
             ;; server, this is for simple ring servers, if this
             ;; doesn't work for you just run your own server :)
             :ring-handler whodowha.services/app

             ;; To be able to open files in your editor from the heads up display
             ;; you will need to put a script on your path.
             ;; that script will have to take a file path and a line number
             ;; ie. in  ~/bin/myfile-opener
             ;; #! /bin/sh
             ;; emacsclient -n +$2 $1
             ;;
             ;; :open-file-command "myfile-opener"

             ;; if you want to disable the REPL
             ;; :repl false

             ;; to configure a different figwheel logfile path
             ;; :server-logfile "tmp/logs/figwheel-logfile.log" 
             })
