(ns figwheel-example.server
  (:require [compojure
             [core :refer [GET routes]]
             [route :refer [files resources]]]
            [org.httpkit.server :refer [run-server]]))

(defn wrap-dir-index [handler]
  (fn [req]
    (handler
     (update-in req [:uri]
                #(if (= "/" %) "/index.html" %)))))

(defn create-app []
  (routes
   ;; javascript files, assets, etc
   (resources "/")))

(defn start []
  (run-server (-> (create-app)
                  ;; rewrite "/" path to "/index.html"
                  wrap-dir-index) {:port 8081}))
