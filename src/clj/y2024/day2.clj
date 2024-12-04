(ns y2024.day2
  (:require [c3kit.apron.corec :as ccc]
            [clojure.string :as str]))

(defn- parse-report [report]
  (map (comp long bigdec) report))

(defn parse [in]
  (->> (str/split-lines in)
       (map #(str/split % #"\s"))
       (map parse-report)))

(defn decreasing? [report]
  (every? #(apply < %) (partition 2 1 report)))
(defn increasing? [report]
  (every? #(apply > %) (partition 2 1 report)))
(defn gradual? [report]
  (every? #(> 4 (abs (apply - %))) (partition 2 1 report)))

(defn safe? [report]
  (and (gradual? report)
       (or (decreasing? report)
           (increasing? report))))

(defn pt-1 [in]
  (let [reports (parse in)]
    (count (filter safe? reports))))

(defn almost-safe? [report]
  ;(prn "report: " report)
  (let [reports (for [n (range (count report))]
                  (concat (take n report) (drop (inc n) report)))]
    ;(prn "reports: " reports)
    (some safe? reports)))

(defn pt-2 [in]
  (let [reports (parse in)
        reports (group-by safe? reports)
        [safe unsafe] [(get reports true) (get reports false)]]
    (count (concat safe (filter almost-safe? unsafe)))))