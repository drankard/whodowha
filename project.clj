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

  :aliases {"uberjar"   ["with-profile", "clj", "uberjar"]}

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

  :profiles {:cljs    {:dependencies [[org.clojure/clojurescript "1.7.170"]
                                      [lein-cljsbuild "1.1.1"]]

                       :plugins      [[lein-cljsbuild "1.1.1"]]
                       :cljsbuild
                                     {:builds
                                      {:dev {:source-paths ["src/cljs" "test/cljc" "test/cljs"]
                                             :compiler     {:output-to    "target/whodowha.js"
                                                            :pretty-print true}}}}}
             :uberjar {:aot  :all
                       :main whodowha.system
                       :hooks [leiningen.cljsbuild]
                       }}
  )
