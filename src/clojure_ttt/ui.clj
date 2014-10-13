(ns clojure-ttt.ui
  (:use [clojure-ttt.ttt_rules])
  (:use [clojure-ttt.board]))

(defn print-message [message]
  (println message))

(defn print-message [message]
  (println message))

(defn welcome-message []
  (print-message "Welcome to Tic-Tac-Toe. The grid is numbered from 0-8. Select a number to fill in a space with your token."))

(defn is-the-winner []
  (print-message "is the winner of this game sucka!"))

(defn wrong-move []
  (print-message "Wrong move bro. Pick another spot."))