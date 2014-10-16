(ns clojure-ttt.unbeatable_ai-spec
  (:require [speclj.core :refer :all]
            [clojure-ttt.unbeatable_ai :refer :all]))

(describe "unbeatable ai"
  (it "should return a score of 1 if the game is over"
    (let [gameover-board ["X" "X" "X"
                          "O" "O" nil
                          nil nil nil]]
          (should= 1 (score-board gameover-board "O"))))
  (it "should return a score of 1 if there is a tie game"
    (let [tie-board ["X" "O" "X"
                     "O" "X" "O"
                     "O" "X" "O"]]
          (should= 0 (score-board tie-board "O"))))

  (it "should return a score of 1 if there is a tie game"
    (let [tie-board ["O" "O" nil
                     "O" "X" "X"
                     "O" nil "X"]]
          (should= 1 (score-board tie-board "O"))))

  (it "should return the updated board after a move has been made"
    (let [old-board ["X" "O" "X"
                     "X" "O" "O"
                     "O" nil "X"]
          new-board ["X" "O" "X"
                     "X" "O" "O"
                     "O" "X" "X"]]
           (should= new-board 
            (with-in-str "7"
              (board-after-move old-board "X" 7)))))

  (it "should return the updated board after two moves have been made"
    (let [old-board ["X" "O" "X"
                     "X" "O" "O"
                     nil nil "X"]
          new-board ["X" "O" "X"
                     "X" "O" "O"
                     nil "O" "X"]]
           (should= new-board (board-after-move old-board "O" 7))))

    (it "should return the score of the board and the move if the game is over"
      (let [game-over-board ["X" "O" "X"
                             "O" "O" "X"
                             "X" nil nil]]
              (should= [1 7] (minimax game-over-board "O" 7))))

    (it "should return a score of 0 for index 4 after one move has been made"
      (let [one-move-board ["X" nil nil
                            nil nil nil
                            nil nil nil]]
              (should= [0 4] (minimax one-move-board "O" 4))))

    (it "should return score of 0 at index 3 when game is a potential tie or win for 'O' in the future"
      (let [game-over-board ["X" nil nil
                             nil "O" nil
                             "X" nil nil]]
              (should= [0 3] (minimax game-over-board "O" 3))))

    (it "should return score and the move for a potential win for 'O'"
      (let [random-board ["X" nil nil
                          nil "O" nil
                          "X" nil nil]]
              (should= [0 3] (get-best-scored-move random-board "O"))))

    (it "should return score and the move for a potential win for 'O'"
      (let [random-board ["X" nil nil
                          nil "O" nil
                          "X" nil nil]]
              (should= 3 (get-minimax-move random-board "O"))))

)