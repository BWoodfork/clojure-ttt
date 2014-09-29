(ns clojure-ttt.presenter-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.presenter :refer :all]))

(describe "presenter"
  (it "display an empty string if spot is nil"
    (should= "_" (display_spot nil)))

  (it "should display game tokens"
    (should= "X" (display_spot "X")))

  (it "should display all game tokens"
    (should= "O" (display_spot "O")))

  (it "should create a new line if board index mod is 0"
    (should= \newline (make_rows 2 )))

  (it "should insert a pipe when index is 1"
    (should= "|" (make_rows 1)))

  (it "should display the game board"
    (should= "_|_|_\n_|_|_\n_|_|_\n" (display_game_board [nil nil nil
                                                          nil nil nil
                                                          nil nil nil])))

)