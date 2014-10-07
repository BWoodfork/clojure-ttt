(defproject clojure-ttt "0.1.0-SNAPSHOT"
  :description "Tic Tac Toe"
  :dependencies [[org.clojure/clojure "1.6.0"]]
  :profiles {:dev {:dependencies [[speclj "3.1.0"]]}}
  :plugins [[speclj "3.1.0"]]
  :test-paths ["spec"]
  :main clojure-ttt.core)