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

    (it "should return the indexes of the board spots"
      (should= [0 1 2 3 4 5 6 7 8] (get_board_indexes [nil nil nil
                                                       nil nil nil
                                                       nil nil nil])))

)