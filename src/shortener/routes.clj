(ns shortener.routes
  (:require [shortener.handler :as handler]
            [shortener.middleware :as mw]
            [compojure.route :as route]
            [compojure.core :refer :all]))

(defn shortener-routes
  [stg]
  (-> (routes
        (POST "/links/:id" [id :as request] (handler/create-link stg id request))
        (GET "/links/:id" [id] (handler/get-link stg id))
        (PUT "/links/:id" [id :as request] (handler/update-link stg id request))
        (DELETE "/links/:id" [id] (handler/delete-link stg id))
        (GET "/links" [] (handler/list-links stg))
        (route/not-found "Not Found"))
      (wrap-routes mw/wrap-slurp-body)))
