(ns shortener.storage-test
  (:require [clojure.test :refer :all]
            [shortener.storage :refer :all]))

(defn is-valid-storage ;; note, not deftest
  "Given an implementation of the Storage protocol, assert that it fulfills the
  contract."
  [stg]
  (let [url "http://example.com/clojurebook"
        id "book"]
    (testing "can store and retrieve a link"
      (testing "create-link returns the id"
        (is (= id (create-link stg id url)))
        (testing "and it won't overwrite an existing id"
          (is (nil? (create-link stg id "bogus")))
          (is (= url (get-link stg id))))))
    (testing "can update a link"
      (let [new-url "http://example.com/nevermind"]
        (update-link stg id new-url)
        (is (= new-url (get-link stg id)))))
    (testing "can delete a link"
      (delete-link stg id)
      (is (nil? (get-link stg id)))))
  (testing "can list all links"
    (let [id-urls {"a" "http://example.com/a"
                   "b" "http://example.com/b"
                   "c" "http://example.com/c"}
          _ (doseq [[id url] id-urls]
              (create-link stg id url))
          links (list-links stg)]
      (testing "in a map"
        (is (map? links))
        (testing "equal to the links we created"
          (is (= id-urls links)))))))
