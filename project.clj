(defproject whodowha "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url  "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ring/ring-core "1.4.0"]
                 [ring-server "0.4.0"]
                 [compojure "1.4.0"]
                 [cheshire "5.5.0"]]

  :ring {:handler       whodowha.services/app
         :init          whodowha.services/init
         :destroy       whodowha.services/destroy
         :port          8080
         :open-browser? false}

  :plugins [[lein-ring "0.9.7"]]
  :uberjar-name "whodowha.jar"
  :min-lein-version "2.0.0"

  :source-paths ["src/clj"]
  :test-paths   ["test/clj"]
  :clean-targets ^{:protect false} ["resources/public/js/out"
                                    "resources/public/js/deploy"
                                    "resources/test/js"
                                    "target"]
  :profiles {
             :cljs    {:dependencies [[org.clojure/clojurescript "1.7.170"]
                                      [org.omcljs/om "0.9.0"]
                                      [lein-cljsbuild "1.1.1"]]

                       :plugins      [[lein-cljsbuild "1.1.1"]]
                       :cljsbuild
                                     {:builds
                                      {:dev {:source-paths ["src/cljs" "src/cljc" "test/cljs"]
                                             :figwheel true
                                             :compiler     {:main          whodowha.hello
                                                            :asset-path    "js/out"
                                                            :output-to     "resources/public/js/whodowha.js"
                                                            :output-dir    "resources/public/js/out"
                                                            :optimizations :none
                                                            :source-map    "resources/public/js/out.js.map"
                                                            :pretty-print  true}}}}}
             :uberjar {:aot  :all
                       :main whodowha.system
                       }}
  )
