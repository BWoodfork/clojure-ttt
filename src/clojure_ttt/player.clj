(ns clojure-ttt.player
  (:use [clojure-ttt.board :only [valid-move?]])
  (:use [clojure-ttt.ttt_rules :only [current-token]])
  (:use [clojure-ttt.unbeatable_ai :only [get-minimax-move]])
  (:use [clojure-ttt.ui]))

(defn get-move-number []
  (Integer. (read-line)))

(defn- convert-computer-move-to-number [ttt-board]
  (Integer. (get-minimax-move ttt-board (current-token ttt-board))))

(defn player-move []
  (get-move-number))

(defn get-player-move [ttt-board]
  (loop [move (player-move)]
    (if (valid-move? ttt-board move)
      move
      (let [wrong-move (wrong-move)]
        (recur (player-move))))))

(defn get-computer-move [ttt-board]
  (convert-computer-move-to-number ttt-board))