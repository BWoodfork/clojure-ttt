(ns clojure-ttt.unbeatable_ai-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.unbeatable_ai :refer :all]))

(describe "unbeatable ai"
  (it "should return a score of -1 if the game is over"
    (let [gameover_board ["X" "X" "X"
                          nil nil nil
                          nil nil nil]]
          (should= -1 (score_board gameover_board))))
  (it "should return a score of -1 if there is a tie game"
    (let [tie_board ["X" "O" "X"
                     "O" "X" "O"
                     "O" "X" "O"]]
          (should= 0 (score_board tie_board))))

  (it "should return the move to tie the game"
    (let [almost_won_board ["X" "O" "X"
                            "X" "O" "O"
                            "O" "X" nil]]
          (should= 8 (minimax almost_won_board))))

  ; (it "should return the winning move"
  ;   (let [almost_won_board ["X" "O" "X"
  ;                           "X" "O" "O"
  ;                           "O" "X" nil]]
  ;         (should= 8 (minimax almost_won_board))))

  ; (it "should return the winning move"
  ;   (let [almost_won_board [nil "O" "X"
  ;                           "X" "O" "O"
  ;                           "O" "X" "X"]]
          ; (should= 0 (minimax almost_won_board))))



)