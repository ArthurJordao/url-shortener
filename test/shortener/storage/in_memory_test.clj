(ns shortener.storage.in-memory-test
  (:require [clojure.test :refer :all]
            [shortener.storage-test :as stg-test]
            [shortener.storage.in-memory :refer [in-memory-storage]]))

(deftest in-memory-storage-test
  (let [stg (in-memory-storage)]
    (stg-test/is-valid-storage stg)))
