(ns clojure-ttt.core
  (:use [clojure-ttt.ttt_rules :only [game-over? current-token get-winning-token]])
  (:use [clojure-ttt.board :only [ttt-board board-length fill-space]])
  (:use [clojure-ttt.presenter :only [print-game-board]])
  (:use [clojure-ttt.player :only [get-player-move get-computer-move]])
  (:use [clojure-ttt.ui]))

(defn get-current-player-move [ttt-board turn]
  (if (even? turn)
    (get-player-move ttt-board)
    (get-computer-move ttt-board)))

(defn run-game []
  (add-space)
  (welcome-message)
  (add-space)
  (print-game-board (ttt-board board-length))
  (loop [board-in-play (ttt-board board-length)
         turn-count 0]
        (if (game-over? board-in-play)
          (let [new-board (fill-space board-in-play (get-current-player-move board-in-play turn-count) (current-token board-in-play))]
            (print-game-board new-board)
            (recur new-board
              (inc turn-count))))))

(defn -main []
 (run-game))