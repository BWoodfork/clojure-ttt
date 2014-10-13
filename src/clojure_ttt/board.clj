(ns clojure-ttt.board
  (:use [clojure-ttt.ttt_rules :only [current-token]]))

(def board-length 
  3)

(defn ttt-board [board-length]
  (into [] (take (* board-length board-length) (repeat nil))))

(defn valid-move? [ttt-board index]
  (and (nil? (get ttt-board index))
            (contains? [0 1 2 3 4 5 6 7 8] index)))

(defn fill-space [ttt-board index token]
  (if (valid-move? ttt-board index)
    (assoc ttt-board index (current-token ttt-board))))

(defn get-empty-spaces [ttt-board]
  (remove nil? 
    (into [] 
    (map-indexed 
      (fn [idx itm] (if (= itm nil) idx)) 
    ttt-board))))