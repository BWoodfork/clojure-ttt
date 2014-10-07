(ns clojure-ttt.core
  (:use [clojure-ttt.presenter :only [display_game_board]])
  (:use [clojure-ttt.ttt_rules :only [game_over?]])
  (:use [clojure-ttt.ttt_rules :only [current_token]])
  (:use [clojure-ttt.board :only [ttt_board]])
  (:use [clojure-ttt.board :only [board_length]])
  (:use [clojure-ttt.board :only [fill_space]]))

(defn run_game []
  (while (not= (game_over? ttt_board) true)
    (display_game_board (ttt_board board_length))
    (fill_space ttt_board (read-line) (current_token (ttt_board)))
    ;:take_turn
    (display_game_board (ttt_board board_length))))




(defn -main []
  (run_game))