(ns clojure-ttt.unbeatable_ai
  (:use [clojure-ttt.ttt_rules :only [game_over?]])
  (:use [clojure-ttt.ttt_rules :only [tie_game?]])
  (:use [clojure-ttt.board :only [get_empty_spaces]])
  (:use [clojure-ttt.board :only [fill_space]])
  (:use [clojure-ttt.ttt_rules :only [current_token]])
  (:use [clojure-ttt.ttt_rules :only [get_winning_token]])
  (:use [clojure-ttt.ttt_rules :only [opponent_token]]))

(declare minimax)
(declare get_best_scored_move)

(defn score_board [ttt_board player_mark]
  (cond 
    (= (get_winning_token ttt_board) player_mark) 1
    (and (not= (get_winning_token ttt_board) nil) (not= (get_winning_token ttt_board) player_mark)) 1
    (= (get_winning_token ttt_board) nil) 0
  ))

(defn get_moves [ttt_board]
  (get_empty_spaces ttt_board))

(defn board_after_move [ttt_board token index]
  (fill_space ttt_board index token))

(defn switch_player_mark [current_mark]
  (if (= current_mark "O")
    "X"
    "O"))

(defn minimax [ttt_board token index]
  (let [board_in_play (board_after_move ttt_board token index)]
    (if (game_over? board_in_play)
      [(score_board board_in_play token) index]
      [(* -1 (first (get_best_scored_move board_in_play (switch_player_mark token)))) index])))

(defn get_best_scored_move [ttt_board token]
  (apply max-key first (map (partial minimax ttt_board token) (get_moves ttt_board))))

(defn get_minimax_move [ttt_board token]
  (second (get_best_scored_move ttt_board token)))
