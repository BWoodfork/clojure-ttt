(ns clojure-ttt.player-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.player :refer :all]))

(describe "player"
  (around [it]
    (with-out-str (it)))

(describe "get move from the current player"
  (it "gets the move from the current player"
    (should= 8
      (with-in-str "8"
        (get-move-number))))

  (it "gets the move from the current player"
    (should= 2
      (with-in-str "2"
        (get-move-number))))

  (it "gets the move of the computer player on the board"
    (let [board ["X" nil nil
                 nil "O" nil
                 "X" nil nil]]
          (should= 3
            (with-in-str "3"
              (get-computer-move board)))))

  ; (it "should return the human player move when the turn count is even"
  ;   (let [board [nil nil nil
  ;                nil nil nil
  ;                nil nil nil]
  ;         turn 0]
  ;     (should= (get-player-move board)
  ;                 (get-current-player-move board turn))))

  ; (it "gets the move of the current human player on the board"
  ;   (let [board ["X" nil nil
  ;                nil nil nil
  ;                nil nil nil]]
  ;         (should= "some string"
  ;           (with-out-str "some string"
  ;             (get-player-move board)))))

)


)