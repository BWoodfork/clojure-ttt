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

(defn get_combo_set [position ttt_board]
  (map ttt_board position))

(defn get_all_combo_sets [combination ttt_board]
  (map (fn [index] (get_combo_set index ttt_board)) combination))

(defn all_spaces_filled? [space]
  (if (some nil? space) false true))

(defn winning_combination? [combo]
  (and (= (count (set combo)) 1) 
    (all_spaces_filled? combo)))

(defn game_winner? [ttt_board]
  (filter winning_combination? 
    (get_all_combo_sets (all_winning_combinations ttt_board 3) ttt_board)))

(defn get_winning_token [ttt_board]
  (first (first (game_winner? ttt_board))))