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

  (it "should check for a row win for 'X'"
    (should= true (row_winner ["X" "X" "X"
                               nil nil nil
                               nil nil nil] 3)))

  (it "should return false if there is no winner"
    (should= false (row_winner [nil nil nil
                                nil nil nil
                                nil nil nil] 3)))

  )