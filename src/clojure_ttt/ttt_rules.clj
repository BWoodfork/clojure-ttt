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

(defn all_winning_combinations [ttt_board board_length]
  (reduce into [(rows ttt_board board_length) 
                (columns ttt_board board_length) 
                (diagonals ttt_board board_length)]))

(defn all_spaces_filled_by_same_piece? [ttt_board token]
  (if (every? #{token} ttt_board)
    true
    false))

(defn get_board_tokens [position ttt_board]
  (map ttt_board position))

(defn get_board_win_set [combination ttt_board]
  (map (fn [index] (get_board_tokens index ttt_board)) combination))

