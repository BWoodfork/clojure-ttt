(ns clojure-ttt.unbeatable_ai-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.unbeatable_ai :refer :all]))

(describe "unbeatable ai"
  (xit "should return the game winning move"
    (should= 8 (minimax ["X" "O" nil
                         nil "X" "O"
                         nil nil nil])))

  (xit "should return the game winning move"
  (should= 6 (minimax ["X" "O" "O"
                       "X" nil nil
                       nil nil nil])))


)