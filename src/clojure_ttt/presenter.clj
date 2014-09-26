(ns clojure-ttt.presenter)

(defn display_spot [spot]
  (or spot "_"))

(defn spots [ttt_board]
  (map display_spot ttt_board))

(defn- separators []
  (cycle "||\n"))

(defn display_game_board [ttt_board]
  (apply str 
    (interleave (spots ttt_board)
                (separators))))