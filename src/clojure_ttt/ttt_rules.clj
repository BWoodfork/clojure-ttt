(ns clojure-ttt.ttt_rules)

(def game_tokens ["X" "O"])

(defn current_token [ttt_board]
  (if (even? (count(remove nil? ttt_board))) "X" "O"))

(defn row_winner [ttt_board]
  )