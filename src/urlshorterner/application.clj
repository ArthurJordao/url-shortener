(ns urlshorterner.application
  (:require [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [urlshorterner.storage.in-memory :refer [in-memory-storage]]
            [urlshorterner.routes :as routes]))
(def app
  (let [stg (in-memory-storage)
        app-routes (routes/shorterner-routes stg)]
    (wrap-defaults app-routes api-defaults)))