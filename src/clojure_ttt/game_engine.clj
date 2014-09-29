(ns clojure-ttt.game_engine
  (:use [clojure-ttt.presenter :only [display_game_board]])
  (:use [clojure-ttt.ttt_rules :only [game_over?]]))

(defn get_input [value]
  (read-string (read-line)))

(defn run_game [ttt_board]
    display_game_board ttt_board)

; (defn make_move [ttt_board]
    ;if current player is ai, get best move
    ;else fill_space with user input
    ;fill_space ttt_board get_input (current_token))

; (defn run_game [ttt_board]
;   (while (= (game_over? ttt_board) false)
;     (display_game_board ttt_board)
    ;make a move
    ;change turns
    ;print the game board again))

; while the game is in play (not over)
; print the board
; make a move
; change turns
; print the board after the move is made
