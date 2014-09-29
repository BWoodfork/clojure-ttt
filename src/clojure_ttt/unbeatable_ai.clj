(ns clojure-ttt.unbeatable_ai
  (:use [clojure-ttt.ttt_rules :only [game_over?]])
  (:use [clojure-ttt.ttt_rules :only [tie_game?]]))

(defn minimax [ttt_board]
  (if (game_over? ttt_board) 0)
  (if (tie_game? ttt_board) -1))



; defn minimax
; return 0 if tie game
; return -1 if game over

; loop through empty spaces
; fill a space with the token that is up
; assign a -1 score to that space, multiply times minimax adding 1 to the depth
; reset spaces to nil

