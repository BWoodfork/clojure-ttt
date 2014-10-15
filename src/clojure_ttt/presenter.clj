(ns clojure-ttt.presenter
  (:use [clojure-ttt.board :only [board-length]])
  (:use [clojure-ttt.ui :only [print-message]]))

(defn display-spot [index spot]
  (if (= spot nil) index spot))

(defn make-rows [index]
  (if (= (rem index board-length) (- board-length 1)) \newline "  |  "))

(defn display-game-board [ttt-board]
  (apply str 
    (map-indexed 
      (fn [index spot] 
        (str (display-spot index spot) 
             (make-rows index))) 
      ttt-board)))

(defn print-game-board [ttt-board]
  (print-message (display-game-board ttt-board)))