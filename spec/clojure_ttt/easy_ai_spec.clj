; (ns clojure-ttt.easy_ai-spec
;   (:require [speclj.core :refer :all]
;             [clojure-ttt.easy_ai :refer :all]))

; (describe "easy ai"
;   (it "should pick the first empty spot"
;     (should= 0 (choose_empty_spot [nil nil nil
;                                    nil nil nil
;                                    nil nil nil])))

;   (it "should pick the first empty spot"
;     (should= 1 (choose_empty_spot ["X" nil nil
;                                    nil nil nil
;                                    nil nil nil])))

; )