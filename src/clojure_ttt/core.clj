(ns clojure-ttt.core
  (:use [clojure-ttt.presenter :only [display_game_board]])
  (:use [clojure-ttt.ttt_rules :only [game_over?]])
  (:use [clojure-ttt.ttt_rules :only [current_token]])
  (:use [clojure-ttt.board :only [ttt_board]])
  (:use [clojure-ttt.board :only [board_length]])
  (:use [clojure-ttt.board :only [fill_space]])
  (:use [clojure-ttt.presenter :only [print_game_board]])
  (:use [clojure-ttt.player :only [get_player_move]]))

(defn get_move []
  (Integer. (read-line)))

(defn run_game []
  (let [board_in_play (ttt_board board_length)
        updated_board (fill_space (ttt_board board_length) (get_player_move) (current_token (ttt_board board_length)))]
    (def board
      (loop [board_in_play board_in_play
            updated_board updated_board]
        (when (not (game_over? board_in_play))
          (print_game_board board_in_play)
          (recur 
            (fill_space board_in_play (get_player_move) (current_token board_in_play))
              updated_board))
        ))
    (print_game_board board)))

(defn -main []
 (run_game))