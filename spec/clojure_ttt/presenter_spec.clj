(ns clojure-ttt.presenter-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.presenter :refer :all]))

(describe "presenter"
  (it "display an empty string if spot is nil"
    (should= 0 (display-spot 0 nil)))

  (it "should display game tokens"
    (should= "X" (display-spot 0 "X")))

  (it "should display all game tokens"
    (should= "O" (display-spot 0 "O")))

  (it "should create a new line if board index mod is 0"
    (should= \newline (make-rows 2)))

  (it "should insert a pipe when index is 1"
    (should= "|" (make-rows 1)))

  (it "should display a 3x3 game board"
    (should= "0|1|2\n3|4|5\n6|7|8\n" (display-game-board [nil nil nil
                                                          nil nil nil
                                                          nil nil nil])))

  ; (it "should display a 4x4 game board"
  ;   (should= "0|1|2|3\n4|5|6|7\n8|9|10|11\n12|13|14|15\n" (display-game-board [nil nil nil nil
  ;                                                                              nil nil nil nil
  ;                                                                              nil nil nil nil
  ;                                                                              nil nil nil nil])))
)