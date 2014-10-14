(ns clojure-ttt.presenter
  (:use [clojure-ttt.board :only [board-length]]))

(defn display-spot [index spot]
  (if (= spot nil) index spot))

(defn make-rows [index]
  (if (= (rem (+ 1 index) board-length) 0) \newline "|"))

(defn display-game-board [ttt-board]
  (apply str 
    (map-indexed 
      (fn [index spot] 
        (str (display-spot index spot) 
             (make-rows index))) 
      ttt-board)))

(defn print-game-board [ttt-board]
  (println (display-game-board ttt-board)))