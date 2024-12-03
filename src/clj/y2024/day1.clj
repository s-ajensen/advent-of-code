(ns y2024.day1
  (:require [clojure.string :as str]))

(defn parse [in]
  (let [lines (str/split-lines in)]
    (reduce
      (fn [[list-1 list-2] line]
        (let [[f s] (map (comp long bigdec) (str/split line #"\s+"))]
          [(conj list-1 f) (conj list-2 s)]))
      [[] []] lines)))

(defn distances [lists]
  (let [[list-1 list-2] (map sort lists)]
    (map #(abs (- %1 %2)) list-1 list-2)))

(defn pt-1 [in]
  (->> in parse distances (reduce +)))

(defn pt-2 [in]
  (let [[list-1 list-2] (->> in parse)
        freqs (frequencies list-2)]
    (->> (map #(* % (get freqs % 0)) list-1) (reduce +))))