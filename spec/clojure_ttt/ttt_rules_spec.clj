(ns clojure-ttt.ttt_rules-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.ttt_rules :refer :all]))

(describe "tic tac toe rules"
  (it "should return an 'X' and 'O' as valid game pieces"
    (should= ["X" "O"] game_tokens))

  (it "should return the 'X' token when board count is odd"
    (should= "X" (current_token [nil nil nil
                                 nil nil nil
                                 nil nil nil])))

  (it "should return the 'O' token when board count is even"
    (should= "O" (current_token ["X" nil nil
                                 nil nil nil
                                 nil nil nil])))

  (it "should return the 'X' token after two moves have been made"
    (should= "X" (current_token ["X" "O" nil
                                 nil nil nil
                                 nil nil nil])))

  (it "should return false if game is still in play"
    (should= false (game_over? ["X" "O" nil
                                nil nil nil
                                nil nil nil])))

  (it "should return true if game is over"
    (should= true (game_over? ["X" "O" "X"
                               "O" "X" "O"
                               "X" "O" "X"])))

  (it "should slice a 3x3 board into rows of 3"
    (should= [[0 1 2] 
              [3 4 5] 
              [6 7 8]] (rows [nil nil nil
                              nil nil nil
                              nil nil nil] 3)))

  (it "should slice a 4x4 board into rows of 4"
    (should= [[0 1 2 3]
              [4 5 6 7]
              [8 9 10 11]
              [12 13 14 15]] (rows [nil nil nil nil
                                    nil nil nil nil
                                    nil nil nil nil
                                    nil nil nil nil] 4)))

  (it "should slice the board into columns of 3"
    (should= [[0 3 6] 
              [1 4 7] 
              [2 5 8]] (columns [nil nil nil
                                 nil nil nil
                                 nil nil nil] 3)))

  (it "should slice a 3x3 board into diagonals"
    (should= [[0 4 8]
              [2 4 6]] (diagonals [nil nil nil
                                   nil nil nil
                                   nil nil nil] 3)))

  (it "should slice a 4x4 board into diagonals"
    (should= [[0 5 10 15]
              [3 6 9 12]] (diagonals [nil nil nil nil
                                      nil nil nil nil
                                      nil nil nil nil
                                      nil nil nil nil] 4)))

  (it "should return all of the winning index combinations"
    (should= [[0 1 2]
              [3 4 5]
              [6 7 8]
              [0 3 6]
              [1 4 7]
              [2 5 8]
              [0 4 8]
              [2 4 6]] (all_winning_combinations [nil nil nil
                                                  nil nil nil
                                                  nil nil nil] 3)))

  (it "should return true if all spaces are filled by the same token"
    (should= true (all_spaces_filled_by_same_piece? ["X" "X" "X"] "X")))

  (it "should return true if all spaces are filled by the same token"
    (should= true (all_spaces_filled_by_same_piece? ["O" "O" "O"] "O")))

  (it "should return the elements at the given index set"
    (should= ["X" "O" "X"] (get_board_tokens [0 1 2] ["X" "O" "X"
                                                      nil nil nil
                                                      nil nil nil])))

  (it "should return the elements at multiple index sets"
    (should= [["X" "O" "X"]
              ["O" "X" "X"]] (get_board_win_set [[0 1 2]
                                                 [3 4 5]] ["X" "O" "X"
                                                           "O" "X" "X"
                                                           nil nil nil])))



  )