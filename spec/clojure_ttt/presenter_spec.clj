(ns clojure-ttt.presenter-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.presenter :refer :all]))

(describe "presenter"
  (it "display an empty string if spot is nil"
    (should= "_" (display-spot nil)))

  (it "should display game tokens"
    (should= "X" (display-spot "X")))

  (it "should display all game tokens"
    (should= "O" (display-spot "O")))

  (it "should create a new line if board index mod is 0"
    (should= \newline (make-rows 2 )))

  (it "should insert a pipe when index is 1"
    (should= "|" (make-rows 1)))

  (it "should display the game board"
    (should= "_|_|_\n_|_|_\n_|_|_\n" (display-game-board [nil nil nil
                                                          nil nil nil
                                                          nil nil nil])))

)