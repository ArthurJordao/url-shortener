(ns urlshorterner.storage.in-memory-test
  (:require [clojure.test :refer :all]
            [urlshorterner.storage-test :as stg-test]
            [urlshorterner.storage.in-memory :refer [in-memory-storage]]))

(deftest in-memory-storage-test
  (let [stg (in-memory-storage)]
    (stg-test/is-valid-storage stg)))
