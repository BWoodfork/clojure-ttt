(ns clojure-ttt.game_engine
  (:use [clojure-ttt.presenter :only [display_game_board]])
  (:use [clojure-ttt.ttt_rules :only [game_over?]]))

(defn get_input [value]
  (read-string (read-line)))

(defprotocol Player
  (get-move [this board]))

(def human-player
  (reify Player
    (get-move [this board]
      (read))))

(def computer-player
  (reify Player
    (get-move [this board]
      (minimax [board]))))

(def mock-player
  (reify Player
    (get-move [this board]
      ([1 2 3 4 5]))))

(defprotocol Listener
  (move-made [this board]))

(def screen
  (reify Listener
    (move-made [this board]
      (print-screen! board))))

(def mock-screen
  (reify Listener
    (move-made [this board]
      (do-something-that-easy-to-test))))

(defn run-game [board players listener]
  (while (not (game-over? board))
    (doseq [player players]
      (let [move (get-move player)]
        (make-move board move)
        (move-made listener board)))))

(defn -main []
  (run-game empty-board 
            [human-player computer-player]))

; (defn run_game [ttt_board]
;   (if (= (game_over? ttt_board) false)
;     (display_game_board ttt_board)))

; (defn make_move [ttt_board]
    ;if current player is ai, get best move
    ;else fill_space with user input
    ;fill_space ttt_board get_input (current_token))

; (defn run_game [ttt_board]
;   (while (= (game_over? ttt_board) false)
;     (display_game_board ttt_board)
    ;make a move
    ;change turns
    ;print the game board again))

; while the game is in play (not over)
; print the board
; make a move
; change turns
; print the board after the move is made
