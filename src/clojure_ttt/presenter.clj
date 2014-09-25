(ns clojure-ttt.presenter)

(defn display_spot [spot]
  (if (= spot nil) "_" spot))

(defn make_rows [index]
  (if (= (rem index 3) 0) \n "|"))

(defn display_game_board [ttt_board]
  "_|_|_\n_|_|_\n_|_|_")