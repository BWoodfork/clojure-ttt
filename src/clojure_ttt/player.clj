(ns clojure-ttt.player
  (:use [clojure-ttt.board :only [valid-move?]])
  (:use [clojure-ttt.board :only [fill-space]])
  (:use [clojure-ttt.ttt_rules :only [current-token]])
  (:use [clojure-ttt.unbeatable_ai :only [get-minimax-move]]))

(defn get-move-number []
  (Integer. (read-line)))

(defn convert-computer-move [ttt-board]
  (Integer. (get-minimax-move ttt-board (current-token ttt-board))))

(defn player-move []
  (get-move-number))

(defn get-player-move [ttt-board]
  (player-move))

(defn get-computer-move [ttt-board]
  (convert-computer-move ttt-board))