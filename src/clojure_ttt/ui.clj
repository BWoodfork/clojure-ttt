(ns clojure-ttt.ui
  (:use [clojure-ttt.ttt_rules])
  (:use [clojure-ttt.board]))

(defn print-message [message]
  (println message))

(def get_winning_player_mark
  (println (get-winning-token (ttt-board board-length)) ))