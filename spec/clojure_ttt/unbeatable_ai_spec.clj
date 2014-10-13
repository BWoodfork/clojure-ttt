(ns clojure-ttt.unbeatable_ai-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.unbeatable_ai :refer :all]))

(describe "unbeatable ai"
  (it "should return a score of _1 if the game is over"
    (let [gameover_board ["X" "X" "X"
                          "O" "O" nil
                          nil nil nil]]
          (should= 1 (score_board gameover_board "O"))))
  (it "should return a score of _1 if there is a tie game"
    (let [tie_board ["X" "O" "X"
                     "O" "X" "O"
                     "O" "X" "O"]]
          (should= 0 (score_board tie_board "O"))))

  (it "should return a score of _1 if there is a tie game"
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
           (should= new_board 
            (with-in-str "7"
              (board_after_move old_board "X" 7)))))

  (it "should return the updated board after two moves have been made"
    (let [old_board ["X" "O" "X"
                     "X" "O" "O"
                     nil nil "X"]
          new_board ["X" "O" "X"
                     "X" "O" "O"
                     nil "O" "X"]]
           (should= new_board (board_after_move old_board "O" 7))))

    (it "should return the score of the board and the move if the game is over"
      (let [game_over_board ["X" "O" "X"
                             "O" "O" "X"
                             "X" nil nil]]
              (should= [1 7] (minimax game_over_board "O" 7))))

    (it "should return a score of 0 for index 4 after one move has been made"
      (let [one_move_board ["X" nil nil
                            nil nil nil
                            nil nil nil]]
              (should= [0 4] (minimax one_move_board "O" 4))))

    (it "should return score and the move for a potential win for 'X'"
      (let [game_over_board ["X" nil nil
                             nil "O" nil
                             "X" nil nil]]
              (should= [0 3] (minimax game_over_board "O" 3))))

    (it "should return score and the move for a potential win for 'X'"
      (let [game_over_board ["X" nil nil
                             nil "O" nil
                             "X" nil nil]]
              (should= [0 3] (minimax game_over_board "O" 3))))

    (it "should return score and the move for a potential win for 'X'"
      (let [game_over_board ["X" nil nil
                             nil "O" nil
                             "X" nil nil]]
              (should= [0 3] (get_best_scored_move game_over_board "O"))))

    (it "should return score and the move for a potential win for 'X'"
      (let [random_board ["X" nil nil
                          nil "O" nil
                          "X" nil nil]]
              (should= [0 3] (get_best_scored_move random_board "O"))))

    (it "should return score and the move for a potential win for 'X'"
      (let [random_board ["X" nil nil
                          nil "O" nil
                          "X" nil nil]]
              (should= 3 (get_minimax_move random_board "O"))))

)