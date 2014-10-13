(ns clojure-ttt.board
  (:use [clojure-ttt.ttt_rules :only [current_token]]))

(def board_length 
  3)

(defn ttt_board [board_length]
  (into [] (take (* board_length board_length) (repeat nil))))

(defn valid_move? [ttt_board index]
  (and (nil? (get ttt_board index))
            (contains? [0 1 2 3 4 5 6 7 8] index)))

(defn fill_space [ttt_board index token]
  (if (valid_move? ttt_board index)
    (assoc ttt_board index (current_token ttt_board))))

(defn get_board_indexes [ttt_board]
  (into [] (range (count ttt_board))))

(defn get_token [ttt_board index]
  (get ttt_board index))

(defn get_empty_spaces [ttt_board]
  (remove nil? 
    (into [] 
    (map-indexed 
      (fn [idx itm] (if (= itm nil) idx)) 
    ttt_board))))