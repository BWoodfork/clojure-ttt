(ns clojure-ttt.unbeatable_ai
  (:use [clojure-ttt.ttt_rules :only [game_over?]])
  (:use [clojure-ttt.ttt_rules :only [tie_game?]])
  (:use [clojure-ttt.board :only [get_empty_spaces]])
  (:use [clojure-ttt.board :only [fill_space]])
  (:use [clojure-ttt.ttt_rules :only [current_token]]))

(defn score_board [ttt_board]
  (cond 
    (not (game_over? ttt_board)) nil
    (and (game_over? ttt_board) (not (tie_game? ttt_board))) -1
    (tie_game? ttt_board) 0
  ))

(def scores
    {})

(def depth
  0)

(defn minimax [ttt_board]
  (map (fn [board]
    (score_board board))
    (map (fn [space]
            (fill_space ttt_board space (current_token ttt_board))) 
            (get_empty_spaces ttt_board))))

; (defn minimax
;   ([ttt_board depth]
;     [ttt_board]
;       (map (fn [space]
;         (fill_space ttt_board space (current_token ttt_board))
;         (assoc scores space (minimax ttt_board (inc depth)))
;           space = nil)
;       (get_empty_spaces ttt_board))))

; defn minimax
; return 0 if tie game
; return -1 if game over

; loop through empty spaces
; fill a space with the token that is up
; assign a -1 score to that space, multiply times minimax adding 1 to the depth
; reset spaces to nil

