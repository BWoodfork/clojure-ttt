(ns clojure-ttt.core
  (:use clojure-ttt.game_engine))

(defn -main [ttt_board]
  (run_game ttt_board))