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
        (get_move_number))))

  (it "gets the move from the current player"
    (should= 2
      (with-in-str "2"
        (get_move_number))))

  (it "gets the move of the current player on the board"
    (let [board [nil "X" "X"
                 "O" "O" nil
                 nil nil nil]]
          (should= 1
            (with-in-str "1"
              (get_player_move)))))

  (it "gets the move of the current player on the board"
    (let [board ["X" nil "X"
                 "O" "O" nil
                 nil nil nil]]
          (should= 2
            (with-in-str "2"
              (get_player_move)))))

  ; (it "should switch the player who's turn it is"
  ;   )

)


)