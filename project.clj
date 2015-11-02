(defproject whodowha "0.1.0-SNAPSHOT"
  :description "FIXME: write description"
  :url "http://example.com/FIXME"
  :license {:name "Eclipse Public License"
            :url "http://www.eclipse.org/legal/epl-v10.html"}
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [ring/ring-core "1.4.0"]
                 [ring-server "0.4.0"]
                 [compojure "1.4.0"]
                 [cheshire "5.5.0"]]

  :ring {:handler       whodowha.services/app
         :init          whodowha.services/init
         :destroy       whodowha.services/destroy
         :port 8080
         :open-browser? false}

  :plugins [[lein-ring "0.9.7"]]

  :profiles {:uberjar {:aot :all}}
  )
