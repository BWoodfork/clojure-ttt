(ns clojure-ttt.board)

(defn ttt_board [size]
  (take (* size size) (repeat nil)))