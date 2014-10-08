(ns clojure-ttt.player)

(defn get_move_number []
  (Integer. (read-line)))

(defn get_player_move []
  (get_move_number))

; (defn switch-player [player-number ]

;   if the number passed is even, get the ai move
;   else get player move)