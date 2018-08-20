(ns ch3shortener.routes
  (:require [ch3shortener.handler :as handler]
            [ch3shortener.middleware :as mw]
            [compojure.route :as route]
            [compojure.core :refer :all]))

(defroutes app-routes
           (GET "/" [] "Hello World")
           (route/not-found "Not Found"))
