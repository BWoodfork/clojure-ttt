(ns clojure-ttt.unbeatable_ai
  (:use [clojure-ttt.ttt_rules :only [game_over?]])
  (:use [clojure-ttt.ttt_rules :only [tie_game?]])
  (:use [clojure-ttt.board :only [get_empty_spaces]])
  (:use [clojure-ttt.board :only [fill_space]])
  (:use [clojure-ttt.ttt_rules :only [current_token]]))

(defn score_board [ttt_board]
  (cond 
    (and (game_over? ttt_board) (not (tie_game? ttt_board))) -1
    (tie_game? ttt_board) 0
  ))

(defn get_move [ttt_board]
  (get_empty_spaces ttt_board))

(defn board_after_move [ttt_board move index]
  (fill_space ttt_board index move))

(defn minimax [ttt_board]
  (* -1 (score_board (board_after_move ttt_board 
                  (current_token ttt_board)
                    (first (get_move ttt_board))))))



; (defn minimax
;   ([ttt_board]
;     (minimax ttt_board 0))
;   ([ttt_board depth]
;   (let [updated_board (board_after_move ttt_board)]
;     (println (get_move ttt_board))
;     (if (game_over? updated_board)
;       {(get_move ttt_board) (score_board updated_board)}
;       [(* -1 (minimax updated_board (inc depth)))]))))

; (defn minimax [ttt_board]
;   (let [updated_board (board_after_move ttt_board)]
;     (if (game_over? ttt_board)
;       [(score_board updated_board)])))

; (defn change_this [ttt_board move]
;   (let [updated_board (minimax ttt_board)]
;     (fill_space updated_board move (current_token ttt_board))
;       (if (game_over? updated_board)
;         [(score_board updated_board) move])))

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

