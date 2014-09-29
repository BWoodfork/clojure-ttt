(ns clojure-ttt.board)

(def board_length 3)

(defn ttt_board [board_length]
  (take (* board_length board_length) (repeat nil)))

(defn fill_space [ttt_board index token]
  (assoc ttt_board index token))

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