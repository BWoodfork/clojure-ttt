(ns clojure-ttt.unbeatable_ai-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.unbeatable_ai :refer :all]))

(describe "unbeatable ai"
  (it "should return a score of -1 if the game is over"
    (let [gameover_board ["X" "X" "X"
                          "O" "O" nil
                          nil nil nil]]
          (should= -1 (score_board gameover_board "O"))))
  (it "should return a score of -1 if there is a tie game"
    (let [tie_board ["X" "O" "X"
                     "O" "X" "O"
                     "O" "X" "O"]]
          (should= 0 (score_board tie_board "O"))))

  (it "should return a score of -1 if there is a tie game"
    (let [tie_board ["O" "O" nil
                     "O" "X" "X"
                     "O" nil "X"]]
          (should= 1 (score_board tie_board "O"))))

  (it "should return the move [8] that has been made on board"
    (let [board ["X" "O" "X"
                 "X" "O" "O"
                 "O" "X" nil]]
          (should= '(8) (get_moves board))))

  (it "should return the move [7] that has been made on board"
    (let [board ["X" "O" "X"
                 "X" "O" "O"
                 "O" nil "X"]]
          (should= '(7) (get_moves board))))

  (it "should return the move [7] and [8] that has been made on board"
    (let [board ["X" "O" "X"
                 "X" "O" "O"
                 "O" nil nil]]
          (should= '(7 8) (get_moves board))))

  (it "should return the moves 2 4 5 7 that has been made on board"
    (let [board ["X" "O" nil
                 nil "X" nil
                 "X" nil "O"]]
          (should= '(2 3 5 7) (get_moves board))))

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
          (should= '(0) (score_moves almost_tie_board "O"))))

  (it "should return the top corner move to tie the game"
      (let [almost_tie_board [nil "O" "X"
                              "X" "O" "O"
                              "O" "X" "X"]]
            (should= '(0) (score_moves almost_tie_board "O"))))

  (it "should return the score 1 if result is a win"
      (let [almost_won_board ["O" "O" "X"
                              "X" "X" nil
                              "O" "O" "X"]]
            (should= '(-1) (score_moves almost_won_board "O"))))

    (it "should return the score 0 if the game is not over"
      (let [almost_won_board ["O" nil "X"
                              "X" "X" nil
                              "O" "O" "X"]]
            (should= '(0 0) (score_moves almost_won_board "O"))))

    (it "should return multiple scores if result is almost a win"
      (let [almost_won_board ["X" "O" nil
                              "O" "X" nil
                              "X" "O" nil]]
            (should= '(-1 0 -1) (score_moves almost_won_board "O"))))

    (it "should return multiple scores if result is almost a loss"
      (let [almost_loss_board ["O" "X" nil
                               "X" "O" "X"
                               "O" "X" nil]]
            (should= '(1 1) (score_moves almost_loss_board "O"))))

    (it "should return the score of the board and the move if the game is over"
      (let [game-over-board ["X" "O" "X"
                             "O" "O" "X"
                             "X" nil nil]]
              (should= [-1 7] (minimax game-over-board "O" 7 0))))

    (it "should return score and the move for a potential win for 'X'"
      (let [game-over-board ["X" nil nil
                             nil nil nil
                             nil nil nil]]
              (should= ['(0 0 0 0 0 0 0) 4] (minimax game-over-board "O" 4 0))))

    (it "should return score and the move for a potential win for 'X'"
      (let [game-over-board ["X" nil nil
                             nil "O" nil
                             "X" nil nil]]
              (should= ['(0 0 0 0 0) 3] (minimax game-over-board "O" 3 0))))

)