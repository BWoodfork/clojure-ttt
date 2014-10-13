(ns clojure-ttt.player
  (:use [clojure-ttt.board :only [valid_move?]])
  (:use [clojure-ttt.board :only [fill_space]])
  (:use [clojure-ttt.ttt_rules :only [current_token]])
  (:use [clojure-ttt.unbeatable_ai :only [get_minimax_move]]))

(defn get_move_number []
  (Integer. (read-line)))

(defn convert_computer_move [ttt_board]
  (Integer. (get_minimax_move ttt_board (current_token ttt_board))))

(defn player_move []
  (get_move_number))

(defn get_player_move [ttt_board]
  (player_move))

(defn get_computer_move [ttt_board]
  (convert_computer_move ttt_board))