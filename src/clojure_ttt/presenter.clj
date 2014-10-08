(ns clojure-ttt.presenter)

(defn display_spot [spot]
  (if (= spot nil) "_" spot))

(defn make_rows [index]
  (if (= (rem index 3) 2) \newline "|"))

(defn display_game_board [ttt_board]
  (apply str 
    (map-indexed 
      (fn [index spot] 
        (str (display_spot spot) 
             (make_rows index))) 
      ttt_board)))

(defn print_game_board [ttt_board]
  (println (display_game_board ttt_board)))