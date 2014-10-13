(ns clojure-ttt.core
  (:use [clojure-ttt.presenter :only [display_game_board]])
  (:use [clojure-ttt.ttt_rules :only [game_over?]])
  (:use [clojure-ttt.ttt_rules :only [current_token]])
  (:use [clojure-ttt.board :only [ttt_board]])
  (:use [clojure-ttt.board :only [board_length]])
  (:use [clojure-ttt.board :only [fill_space]])
  (:use [clojure-ttt.presenter :only [print_game_board]])
  (:use [clojure-ttt.player :only [get_player_move]])
  (:use [clojure-ttt.player :only [get_computer_move]]))

(defn get_move []
  (Integer. (read-line)))

(defn get_current_player_move [ttt_board number]
  (if (even? number)
    (get_computer_move ttt_board)
    (get_player_move ttt_board)))

(defn run_game []
    (def board
      (loop [board_in_play (ttt_board board_length)
            turn_number 0]
        (when (not (game_over? board_in_play))
          (do 
            (print_game_board board_in_play)
            board_in_play)
          (println turn_number)
          (recur
            turn_number
            (fill_space board_in_play (get_current_player_move board_in_play turn_number) (current_token board_in_play))))))
    (print_game_board board))

(defn main []
 (print_game_board (run_game)))