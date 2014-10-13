(ns clojure-ttt.ttt_rules-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.ttt_rules :refer :all]))

(describe "tic tac toe rules"
  (it "should return the 'X' token when board count is odd"
    (should= "X" (current-token [nil nil nil
                                 nil nil nil
                                 nil nil nil])))

  (it "should return the 'O' token when board count is even"
    (should= "O" (current-token ["X" nil nil
                                 nil nil nil
                                 nil nil nil])))

  (it "should return the 'X' token after two moves have been made"
    (should= "X" (current-token ["X" "O" nil
                                 nil nil nil
                                 nil nil nil])))

  (it "should return the 'O' token after 5 moves have been made"
    (should= "O" (current-token ["X" "O" nil
                                 nil "X" nil 
                                 "X" nil "O"])))

  (it "should return the 'O' token after 5 moves have been made"
    (should= "O" (opponent-token ["X" nil nil
                                  nil nil nil 
                                  nil nil nil])))

  (it "should return false if board is empty"
    (should= false (game-over? [nil nil nil
                                nil nil nil
                                nil nil nil])))

  (it "should return true if game is over and there are empty spaces left"
    (should= true (game-over? ["X" "O" "O"
                               nil "X" nil
                               nil nil "X"])))

  (it "should return true if game is over"
    (should= true (game-over? ["X" "O" "X"
                               "O" "X" "O"
                               "X" "O" "X"])))

  (it "should return true if game is over"
    (should= true (game-over? ["X" "O" "X"
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
              [2 4 6]] (all-winning-combinations [nil nil nil
                                                  nil nil nil
                                                  nil nil nil] 3)))

  (it "should return the elements at the given index set"
    (should= ["X" "O" "X"] (get-combo-set [0 1 2] ["X" "O" "X"
                                                   nil nil nil
                                                   nil nil nil])))

  (it "should return the elements at multiple index sets"
    (should= [["X" "O" "X"]
              ["O" "X" "X"]] (get-all-combo-sets [[0 1 2]
                                                  [3 4 5]] ["X" "O" "X"
                                                            "O" "X" "X"
                                                            nil nil nil])))

  (it "should return true if all spaces on the board are occupied by tokens"
    (should= true (all-spaces-filled? ["X" "O" "X"])))

  (it "should return false if one space is available"
    (should= false (all-spaces-filled? [nil "X" "O"])))

  (it "should return false if all spaces are nil"
    (should= false (all-spaces-filled? [nil nil nil])))

  (it "should return true if three elements are alike"
    (should= true (winning-combination? ["X" "X" "X"])))

  (it "should return true if three elements are alike"
    (should= true (winning-combination? ["O" "O" "O"])))

  (it "should return false if three elements are not alike"
    (should= false (winning-combination? ["O" "O" "X"])))

  (it "should return false is all elements are nil"
    (should= false (winning-combination? [nil nil nil])))

  (it "should return the winning moves"
    (should= [["X" "X" "X"]] (winning-set ["X" "X" "X"
                                           "O" nil nil
                                           nil nil nil])))

  (it "should return the winning moves"
    (should= [["O" "O" "O"]] (winning-set ["O" "X" "X"
                                           "O" nil nil
                                           "O" nil nil])))

  (it "returns an empty list if no winning set"
    (should= () (winning-set ["X" "O" "X"
                              "O" "X" "O"
                              nil nil nil])))

  (it "should return the token of the game winner"
    (should= "X" (get-winning-token ["X" "X" "X"
                                     nil nil "O"
                                     "O" nil nil])))

  (it "should return the 'O' token as a game winner"
    (should= "O" (get-winning-token ["O" "O" "O"
                                     nil nil "X"
                                     "X" nil nil])))

  (it "should return the 'O' token as a game winner"
    (should= "X" (get-winning-token ["X" nil nil
                                     "X" nil "O"
                                     "X" "O" nil])))

  (it "should return true if there is a tie game"
    (should= true (tie-game? ["O" "X" "O"
                              "X" "X" "O"
                              "X" "O" "X"])))

  (it "should return false if there is no tie game"
    (should= false (tie-game? ["X" "O" "O"
                               "X" "X" "O"
                               "X" "O" "X"])))

  (it "should return false if there is one space empty"
    (should= false (tie-game? ["X" "O" "O"
                               "X" "X" "O"
                               "X" "O" nil])))

  (it "should return false if there are three empty spaces"
    (should= false (tie-game? ["X" "O" "X"
                               "O" "X" "O"
                               nil nil nil])))

  )