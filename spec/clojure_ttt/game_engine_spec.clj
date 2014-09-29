(ns clojure-ttt.game_engine-spec
  (:use [clojure-ttt.presenter :only [display_game_board]])
  (:use [clojure-ttt.ttt_rules :only [game_over?]])
  (:require [speclj.core :refer :all]
            [clojure-ttt.game_engine :refer :all]))

(describe "game engine"
  (around [it]
    (with-out-str (it)))
  (it "should receive input from the command line"
    (should= 0 (with-in-str "0" (get_input (range 9)))))

  ; (it "should print the game board"
  ;   (should= "_|_|_\n_|_|_\n_|_|_\n" 
  ;     (run_game [nil nil nil
  ;                nil nil nil
  ;                nil nil nil])))

)