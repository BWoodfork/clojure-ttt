(ns clojure-ttt.ttt_rules)

(def x-mark "X")

(def o-mark "O")

(defn current-token [ttt-board]
  (if (even? (count(remove nil? ttt-board))) x-mark o-mark))

(defn opponent-token [ttt-board]
  (if (odd? (count(remove nil? ttt-board))) o-mark x-mark))

(defn rows [ttt-board board-length]
  (mapv vec (partition board-length 
    (range (count ttt-board)))))

(defn columns [ttt-board board-length]
  (apply mapv vector (rows ttt-board board-length)))

(defn diagonals [ttt-board board-length]
  (mapv vec [(take board-length (iterate (partial + (+ 1 board-length)) 0))
             (take board-length (iterate (partial + (- board-length 1)) (- board-length 1)))]))

(defn all-winning-combinations [ttt-board board-length]
  (reduce into [(rows ttt-board board-length) 
                (columns ttt-board board-length) 
                (diagonals ttt-board board-length)]))

(defn get-combo-set [position ttt-board]
  (map ttt-board position))

(defn get-all-combo-sets [combination ttt-board]
  (map (fn [index] (get-combo-set index ttt-board)) combination))

(defn all-spaces-filled? [space]
  (if (some nil? space) false true))

(defn winning-combination? [combo]
  (and (= (count (set combo)) 1) 
    (all-spaces-filled? combo)))

(defn winning-set [ttt-board]
  (filter winning-combination? 
    (get-all-combo-sets (all-winning-combinations ttt-board 3) ttt-board)))

(defn get-winning-token [ttt-board]
  (first (first (winning-set ttt-board))))

(defn game-over? [ttt-board]
  (if 
    (not (= (winning-set ttt-board) ())) true 
      (if (all-spaces-filled? ttt-board) true false)))

(defn tie-game? [ttt-board]
  (and (= (winning-set ttt-board) ())
          (game-over? ttt-board)))
