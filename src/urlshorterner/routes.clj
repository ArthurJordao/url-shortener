(ns urlshorterner.routes
  (:require [urlshorterner.handler :as handler]
            [urlshorterner.middleware :as mw]
            [compojure.route :as route]
            [compojure.core :refer :all]))

(defroutes app-routes
           (GET "/" [] "Hello World")
           (route/not-found "Not Found"))
