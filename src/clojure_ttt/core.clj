(ns clojure-ttt.core
  (:use [clojure-ttt.ttt_rules :only [game-over? current-token get-winning-token]])
  (:use [clojure-ttt.board :only [ttt-board board-length fill-space]])
  (:use [clojure-ttt.presenter :only [print-game-board]])
  (:use [clojure-ttt.player :only [get-player-move get-computer-move get-current-player-move]])
  (:use [clojure-ttt.ui]))

(defn run-game []
  (welcome-message)
  (add-empty-space)
  (print-game-board (ttt-board board-length))
  (loop [board-in-play (ttt-board board-length)
         turn-count 0]
          (if (not (game-over? board-in-play))
            (print-message (current-player-message board-in-play))
            (do (print-message (game-over-message))
              (print-message (is-the-winner board-in-play))
              (add-empty-space)))
        (if (game-over? board-in-play)
          (print-message (better-luck))
          (let [new-board (fill-space board-in-play (get-current-player-move board-in-play turn-count) (current-token board-in-play))]
            (add-extra-empty-space)
            (print-game-board new-board)
            (recur new-board
              (inc turn-count))))))

(defn -main []
 (run-game))