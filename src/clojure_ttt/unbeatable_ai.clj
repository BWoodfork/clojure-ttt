(ns clojure-ttt.unbeatable_ai
  (:use [clojure-ttt.ttt_rules :only [game-over? tie-game? current-token get-winning-token opponent-token]])
  (:use [clojure-ttt.board :only [get-empty-spaces fill-space]]))

(declare minimax)
(declare get-best-scored-move)

(defn score-board [ttt-board player-mark]
  (cond 
    (= (get-winning-token ttt-board) player-mark) 1
    (and (not= (get-winning-token ttt-board) nil) (not= (get-winning-token ttt-board) player-mark)) 1
    (= (get-winning-token ttt-board) nil) 0))

(defn get-moves [ttt-board]
  (get-empty-spaces ttt-board))

(defn board-after-move [ttt-board token index]
  (fill-space ttt-board index token))

(defn minimax [ttt-board token index]
  (let [board-in-play (board-after-move ttt-board token index)]
    (if (game-over? board-in-play)
      [(score-board board-in-play token) index]
      [(* -1 (first (get-best-scored-move board-in-play (opponent-token board-in-play)))) index])))

(defn get-best-scored-move [ttt-board token]
  (apply max-key first (map (partial minimax ttt-board token) (get-moves ttt-board))))

(defn get-minimax-move [ttt-board token]
  (second (get-best-scored-move ttt-board token)))
