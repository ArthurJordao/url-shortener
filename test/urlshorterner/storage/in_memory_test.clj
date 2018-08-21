(ns urlshorterner.storage.in-memory-test
  (:require [clojure.test :refer :all])
  (:require [urlshorterner.storage-test :as stg-test])
  (:require [urlshorterner.storage.in-memory :refer [in-memory-storage]]))

(deftest in-memory-storage-test
  (let [stg (in-memory-storage)]
    (stg-test/is-valid-storage stg)))
