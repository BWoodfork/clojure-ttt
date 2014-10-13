(ns clojure-ttt.board-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.board :refer :all]))

  (describe "the game board"
    (it "should have a board with 9 empty spaces"
      (should= [nil nil nil
                nil nil nil
                nil nil nil] (ttt_board 3)))

    (it "should convert to a 4x4 board"
      (should= [nil nil nil nil
                nil nil nil nil
                nil nil nil nil
                nil nil nil nil] (ttt_board 4)))

    (it "should fill an empty space on the board"
      (should= ["X" nil nil
                nil nil nil
                nil nil nil] (fill_space [nil nil nil
                                          nil nil nil
                                          nil nil nil] 0 "X")))

    (it "should fill an empty space on the board after a move has been made"
      (should= ["X" "O" nil
                nil nil nil
                nil nil nil] (fill_space ["X" nil nil
                                          nil nil nil
                                          nil nil nil] 1 "O")))
    (it "should check to see if move is valid"
       (let [board [nil nil nil
                    nil nil nil
                    nil nil nil]] 
                (should= true (valid_move? board 0))))

    (it "should return false if move is invalid"
       (let [board [nil nil nil
                    nil nil nil
                    nil nil nil]] 
                (should= false (valid_move? board 10))))

    (it "should return false if move is already filled"
       (let [board ["X" nil nil
                    nil nil nil
                    nil nil nil]] 
                (should= false (valid_move? board 0))))

    (it "should return the indexes of the board spots"
      (should= [0 1 2 3 4 5 6 7 8] (get_board_indexes [nil nil nil
                                                       nil nil nil
                                                       nil nil nil])))

    (it "should return the token at a given index"
      (should= "X" (get_token ["X" nil nil
                               nil nil nil
                               nil nil nil] 0)))

    (it "should return the token at any given index"
      (should= "O" (get_token [nil "O" nil
                               nil nil nil
                               nil nil nil] 1)))

    (it "should return the indexes for empty spaces on the board"
      (should= [0 1 2] (get_empty_spaces [nil nil nil
                                          "X" "O" "X"
                                          "X" "O" "X"])))

    (it "should return the indexes for empty spaces on the board"
      (should= [3 4 5] (get_empty_spaces ["X" "O" "X"
                                          nil nil nil
                                          "X" "O" "X"])))

)