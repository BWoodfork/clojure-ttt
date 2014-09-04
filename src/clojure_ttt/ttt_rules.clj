(ns clojure-ttt.ttt_rules)

(def game_tokens ["X" "O"])

(defn current_token [ttt_board]
  (if (even? (count(remove nil? ttt_board))) "X" "O"))

(defn game_over? [ttt_board]
  (if (some nil? ttt_board) false true))

(defn rows [ttt_board board_length]
  (mapv vec (partition board_length 
    (range (count ttt_board)))))

(defn columns [ttt_board board_length]
  (apply mapv vector (rows ttt_board board_length)))

(defn diagonals [ttt_board board_length]
  (mapv vec [(take board_length (iterate (partial + (+ 1 board_length)) 0))
             (take board_length (iterate (partial + (- board_length 1)) (- board_length 1)))]))

(defn row_winner [ttt_board board_length]
  (if (= (mapv (fn [index] (ttt_board index)) [0 1 2]) ["X" "X" "X"]) 
    true 
    false))
