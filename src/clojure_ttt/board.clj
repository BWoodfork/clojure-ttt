(ns clojure-ttt.board)

(defn ttt_board [size]
  (take (* size size) (repeat nil)))

(defn fill_space [ttt_board index token]
  (assoc ttt_board index token))