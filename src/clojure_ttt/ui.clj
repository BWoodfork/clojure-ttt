(ns clojure-ttt.ui
  (:use [clojure-ttt.ttt_rules])
  (:use [clojure-ttt.board]))

(defn print-message [message]
  (println message))

(defn is-the-winner [ttt-board]
  (print-str (get-winning-token ttt-board) "is the winner of this game sucka!\n"))

(defn wrong-move []
  (print-message "Wrong move bro. Pick another spot."))

(defn game-over-message []
  (interpose "" "Game over"))

(defn current-player-message [ttt-board]
  (print-str "\nThe current player is:" (current-token ttt-board) "select a space number to make a move.\n \n"))

(defn better-luck []
  (print-str "Better luck next time =)\n"))

(defn welcome-message []
  (print-str "\nWelcome to the game of Tic-Tac-Toe.\nThe board's empty spots are labeled from 0 - 8.\nSelect the spot number that you would like to play to begin.\n
It's you, versus an unbeatable AI.\nThink you can beat a genius? Make a move and see.\nPlayer 'X' has the first move.\n" ))

(defn end-game-messages [ttt-board]
  (print-message (game-over-message))
  (print-message (is-the-winner ttt-board))
  (print-message (better-luck)))