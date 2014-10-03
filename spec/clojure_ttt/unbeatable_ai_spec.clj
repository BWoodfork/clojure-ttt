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

  (it "should return the move [8] that has been made on board"
    (let [board ["X" "O" "X"
                 "X" "O" "O"
                 "O" "X" nil]]
          (should= '(8) (get_move board))))

  (it "should return the move [7] that has been made on board"
    (let [board ["X" "O" "X"
                 "X" "O" "O"
                 "O" nil "X"]]
          (should= '(7) (get_move board))))

  (it "should return the move [7] and [8] that has been made on board"
    (let [board ["X" "O" "X"
                 "X" "O" "O"
                 "O" nil nil]]
          (should= '(7 8) (get_move board))))

  (it "should return the moves 2 4 5 7 that has been made on board"
    (let [board ["X" "O" nil
                 nil "X" nil
                 "X" nil "O"]]
          (should= '(2 3 5 7) (get_move board))))

  (it "should return the updated board after a move has been made"
    (let [old_board ["X" "O" "X"
                     "X" "O" "O"
                     "O" nil "X"]
          new_board ["X" "O" "X"
                     "X" "O" "O"
                     "O" "X" "X"]]
           (should= new_board (board_after_move old_board "X" 7))))

  (it "should return the updated board after two moves have been made"
    (let [old_board ["X" "O" "X"
                     "X" "O" "O"
                     nil nil "X"]
          new_board ["X" "O" "X"
                     "X" "O" "O"
                     nil "X" "X"]]
           (should= new_board (board_after_move old_board "X" 7))))

  (it "should return the score of 0 when almost a tie game"
    (let [almost_tie_board ["X" "O" "X"
                            "X" "O" "O"
                            "O" "X" nil]]
          (should= 0 (minimax almost_tie_board))))

  (it "should return the top corner move to tie the game"
      (let [almost_tie_board [nil "O" "X"
                              "X" "O" "O"
                              "O" "X" "X"]]
            (should= 0 (minimax almost_tie_board))))

  (it "should return the score 1 if result is a win"
      (let [almost_won_board ["O" "O" "X"
                              "X" "X" nil
                              "O" "O" "X"]]
            (should= 1 (minimax almost_won_board))))

  (it "should return the score -1 if result is a loss"
      (let [almost_loss_board ["X" "O" nil
                               nil "X" nil
                               "X" nil "O"]]
            (should= -1 (minimax almost_loss_board)))) 

  ; (it "picks the winning move instead of a non-winning move"
  ;     (let [board_in_play [nil nil "X"
  ;                          "X" "O" "O"
  ;                          "X" "O" "X"]]
  ;           (should= 1 (minimax board_in_play))))

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