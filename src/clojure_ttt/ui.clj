(ns clojure-ttt.ui
  (:use [clojure-ttt.ttt_rules])
  (:use [clojure-ttt.board]))

(defn print-message [message]
  (println message))

(defn welcome-message []
  (print-message "Welcome to the game of Tic-Tac-Toe.\nThe board's empty spots are labeled from 0 - 8.\nSelect the spot number that you would like to play to begin.\n
It's you, versus an unbeatable AI.\nThink you can beat a genius? Make a move and see.\nPlayer 'X' has the first move."))

(defn is-the-winner []
  (print-message "is the winner of this game sucka!"))

(defn wrong-move []
  (print-message "Wrong move bro. Pick another spot."))

(defn add-space []
  (newline))