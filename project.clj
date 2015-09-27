(defproject figwheel-example "0.1.0-SNAPSHOT"
  :description "Figwheel starter example"
  :url "https://github.com/tristanstraub/figwheel-example"
  :license {:name "GNU General Public License"
            :url "http://www.gnu.org/licenses/gpl.html"}
  :jvm-opts ["-XX:MaxPermSize=256m"]
  :dependencies [[org.clojure/clojure "1.7.0"]
                 [org.clojure/clojurescript "1.7.122"]
                 [compojure "1.4.0"]
                 [http-kit "2.2.0-SNAPSHOT"]]
  :profiles {:dev {:plugins [[lein-cljsbuild "1.0.6"]
                             [lein-figwheel "0.4.0"]]
                   :dependencies [[figwheel "0.4.0"]
                                  [figwheel-sidecar "0.4.0"]
                                  ;;[com.cemerick/piggieback "0.2.1"]
                                  ]
                   :source-paths ["dev"]}}

  :source-paths ["src"]

  :cljsbuild {:builds [{:source-paths ["src" "dev"]
                        :figwheel true
                        :compiler {:output-to "target/classes/public/app.js"
                                   :output-dir "target/classes/public/out"
                                   :optimizations :none
                                   :recompile-dependents true
                                   :source-map "target/classes/public/app.js.map"
                                   :asset-path "out"
                                   :main figwheel-example.core}}]})
