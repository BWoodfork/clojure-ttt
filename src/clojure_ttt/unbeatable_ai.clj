(ns clojure-ttt.unbeatable_ai
  (:use [clojure-ttt.ttt_rules :only [game_over?]])
  (:use [clojure-ttt.ttt_rules :only [tie_game?]])
  (:use [clojure-ttt.board :only [get_empty_spaces]])
  (:use [clojure-ttt.board :only [fill_space]]))

(defn score_board [ttt_board]
  (cond 
    (and (game_over? ttt_board)
    (not (tie_game? ttt_board))) 
      -1
    (tie_game? ttt_board) 
      0))

(defn minimax [ttt_board]
  (let [current_board (atom ttt_board)]
    (doseq [space (get_empty_spaces current_board)]
      (fill_space current_board space "X"))))  



; defn minimax
; return 0 if tie game
; return -1 if game over

; loop through empty spaces
; fill a space with the token that is up
; assign a -1 score to that space, multiply times minimax adding 1 to the depth
; reset spaces to nil

