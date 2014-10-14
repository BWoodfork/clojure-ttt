(ns clojure-ttt.unbeatable_ai
  (:use [clojure-ttt.ttt_rules :only [game-over?]])
  (:use [clojure-ttt.ttt_rules :only [tie-game?]])
  (:use [clojure-ttt.board :only [get-empty-spaces]])
  (:use [clojure-ttt.board :only [fill-space]])
  (:use [clojure-ttt.ttt_rules :only [current-token]])
  (:use [clojure-ttt.ttt_rules :only [get-winning-token]])
  (:use [clojure-ttt.ttt_rules :only [opponent-token]]))

(declare minimax)
(declare get-best-scored-move)

(defn score-board [ttt-board player-mark]
  (cond 
    (= (get-winning-token ttt-board) player-mark) 1
    (and (not= (get-winning-token ttt-board) nil) (not= (get-winning-token ttt-board) player-mark)) 1
    (= (get-winning-token ttt-board) nil) 0
  ))

(defn get-moves [ttt-board]
  (get-empty-spaces ttt-board))

(defn board-after-move [ttt-board token index]
  (fill-space ttt-board index token))

(defn switch-player-mark [current-mark]
  (if (= current-mark "O")
    "X"
    "O"))

(defn minimax [ttt-board token index]
  (let [board-in-play (board-after-move ttt-board token index)]
    (if (game-over? board-in-play)
      [(score-board board-in-play token) index]
      [(* -1 (first (get-best-scored-move board-in-play (switch-player-mark token)))) index])))

(defn get-best-scored-move [ttt-board token]
  (apply max-key first (map (partial minimax ttt-board token) (get-moves ttt-board))))

(defn get-minimax-move [ttt-board token]
  (second (get-best-scored-move ttt-board token)))
