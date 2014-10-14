(ns clojure-ttt.core-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.core :refer :all]
            [clojure-ttt.player :refer :all]
            [clojure-ttt.ttt_rules :refer :all]))

(describe "player input in game loop"
  (it "should get player move in game loop"
    (let [board [nil nil nil
                 nil nil nil
                 nil nil nil]
          turn 0]
        (with-redefs [read-line (constantly "0")]
          (should= 0
            (get-current-player-move board turn)))))
)