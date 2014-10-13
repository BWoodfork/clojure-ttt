(ns clojure-ttt.presenter)

(defn display-spot [spot]
  (if (= spot nil) "_" spot))

(defn make-rows [index]
  (if (= (rem index 3) 2) \newline "|"))

(defn display-game-board [ttt-board]
  (apply str 
    (map-indexed 
      (fn [index spot] 
        (str (display-spot spot) 
             (make-rows index))) 
      ttt-board)))

(defn print-game-board [ttt-board]
  (println (display-game-board ttt-board)))