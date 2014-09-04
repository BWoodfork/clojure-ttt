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

  (it "should check if the game is over"
    (should= false (game_over? ["X" "O" nil
                                nil nil nil
                                nil nil nil])))

  (it "should check if the game is over"
    (should= true (game_over? ["X" "O" "X"
                               "O" "X" "O"
                               "X" "O" "X"])))

  (it "should slice the board into rows of 3"
    (should= [[0 1 2] 
              [3 4 5] 
              [6 7 8]] (rows [nil nil nil
                              nil nil nil
                              nil nil nil] 3)))

  (it "should slice the board into rows of 4"
    (should= [[0 1 2 3]
              [4 5 6 7]
              [8 9 10 11]] (rows [nil nil nil nil
                                  nil nil nil nil
                                  nil nil nil nil] 4)))

  (it "should slice the board into columns of 3"
    (should= [[0 3 6] 
              [1 4 7] 
              [2 5 8]] (columns [nil nil nil
                                 nil nil nil
                                 nil nil nil] 3)))

  



  )