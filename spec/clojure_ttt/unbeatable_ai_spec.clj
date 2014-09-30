(ns clojure-ttt.unbeatable_ai-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.unbeatable_ai :refer :all]))

(describe "unbeatable ai"
  (it "should return a score of -1 if the game is over"
    (let [current_board ["X" "X" "X"
                         nil nil nil
                         nil nil nil]]
          (should= -1 (minimax current_board)))))