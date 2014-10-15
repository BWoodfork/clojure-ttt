(ns clojure-ttt.ui
  (:use [clojure-ttt.ttt_rules])
  (:use [clojure-ttt.board]))

(defn print-message [message]
  (println message))

(defn print-messages [messages]
  (print-str messages))

(defn is-the-winner [ttt-board]
  (print-str (get-winning-token ttt-board) "is the winner of this game sucka!"))

(defn wrong-move []
  (print-message "Wrong move bro. Pick another spot."))

(defn game-over-message []
  (interpose "" "Game over"))

(defn add-empty-space []
  (newline))

(defn current-player-message [ttt-board]
  (print-str "The current player is:" (current-token ttt-board) "select a space number to make a move."))

(defn better-luck []
  (print-str "Better luck next time =)"))

(defn welcome-message []
  (print-str (add-empty-space) "Welcome to the game of Tic-Tac-Toe.\nThe board's empty spots are labeled from 0 - 8.\nSelect the spot number that you would like to play to begin.\n
It's you, versus an unbeatable AI.\nThink you can beat a genius? Make a move and see.\nPlayer 'X' has the first move." ))

(defn add-extra-empty-space []
  (add-empty-space)
  (add-empty-space)
  (add-empty-space))