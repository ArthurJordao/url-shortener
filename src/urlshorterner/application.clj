(ns urlshorterner.application
  (:require [ring.middleware.defaults :refer [wrap-defaults api-defaults]]
            [urlshorterner.routes :as routes]))
(def app
  (wrap-defaults routes/app-routes api-defaults))
