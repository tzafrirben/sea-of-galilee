#!/usr/bin/env bb
(ns update-surveys
  (:require
   [clojure.edn :as edn]
   [clojure.string :as string]
   [cheshire.core :as json])
  (:import [java.time LocalDate]
           [java.time.format DateTimeFormatter]))

(def src-date-pattern (DateTimeFormatter/ofPattern "d/M/yyyy"))
(def out-date-pattern (DateTimeFormatter/ofPattern "yyyy-MM-dd"))

(defn format-date
  [^String date]
  (let [d (LocalDate/parse date src-date-pattern)]
    (.format d out-date-pattern)))

;; https://stackoverflow.com/a/62915361/3592771
(defn remove-non-printable-chars
  [^String s]
  (string/replace s #"\p{C}" ""))

;;; parsed csv file with history water levels and render into JSON
;;; file downloaded from:
;;; https://data.gov.il/dataset/https-www-data-gov-il-dataset-682/resource/2de7b543-e13d-4e7e-b4c8-56071bc4d3c8
(let [input  (slurp (first *command-line-args*))
      output (second *command-line-args*)
      parsed (reduce
              (fn [arr line]
                (let [[d l] (string/split line #", ")]
                  (conj arr
                        {:date  (format-date (remove-non-printable-chars d))
                         :level (edn/read-string l)})))
              []
              (string/split-lines input))]
  (spit output (json/generate-string parsed)))
