(ns clojure-ttt.board-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.board :refer :all]))

  (describe "the game board"
    (it "should have a board with 9 empty spaces"
     (should= [nil, nil, nil,
               nil, nil, nil,
               nil, nil, nil] (ttt_board 3)))

    (it "should convert to a 4x4 board"
      (should= [nil, nil, nil, nil,
                nil, nil, nil, nil,
                nil, nil, nil, nil,
                nil, nil, nil, nil,] (ttt_board 4)))

)