(ns clojure-ttt.core
  (:use [clojure-ttt.ttt_rules :only [game-over? current-token get-winning-token]])
  (:use [clojure-ttt.board :only [ttt-board board-length fill-space]])
  (:use [clojure-ttt.presenter :only [print-game-board]])
  (:use [clojure-ttt.player :only [get-player-move get-computer-move get-current-player-move]])
  (:use [clojure-ttt.ui]))

(defn game-loop [ttt-board]
  (loop [board-in-play ttt-board
         turn-count 0]
          (if (game-over? board-in-play)
            (do
              (end-game-messages board-in-play))
          (let [new-board (fill-space board-in-play (get-current-player-move board-in-play turn-count) (current-token board-in-play))]
            (print-message (current-player-message board-in-play))
            (print-game-board new-board)
            (recur new-board
              (inc turn-count))))))

(defn run-game []
  (print-message (welcome-message))
  (print-game-board (ttt-board board-length))
  (game-loop (ttt-board board-length)))

(defn -main []
 (run-game))