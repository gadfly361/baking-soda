(defproject baking-soda "0.2.0"
  :description "baking-soda is an interface between clojurescript's reagent
                and reactstrap (i.e., bootstrap 4 react components)"
  :url "https://github.com/gadfly361/baking-soda"
  :license {:name "MIT"}
  :scm {:name "git"
        :url  "https://github.com/gadfly361/baking-soda"}

  :min-lein-version "2.5.3"

  :dependencies
  [[org.clojure/clojure "1.8.0"]
   [org.clojure/clojurescript "1.10.238"]

   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; Reactstrap (bootstrap 4)

   [cljsjs/reactstrap "6.0.1-0" :exclusions [cljsjs/react
                                             cljsjs/react-dom
                                             cljsjs/react-transition-group
                                             cljsjs/react-popper]]

   ;; Reacstrap now depends on react 16 and reagent 0.8+
   ;; i.e., need the following:

   ;; [reagent "0.8.1" :exclusions [cljsjs/react
   ;;                               cljsjs/react-dom]]
   ;; [cljsjs/react "16.3.2-0"]
   ;; [cljsjs/react-dom "16.3.2-0"]
   ;; [cljsjs/react-transition-group "2.3.1-0"]
   ;; [cljsjs/react-popper "0.10.4-0"]


   ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
   ;; React-bootstrap (boostrap 3)

   [cljsjs/react-bootstrap "0.31.5-0"
    :exclusions [cljsjs/react
                 cljsjs/react-dom]]

   ;; React-bootstrap still depends on react 15 and reagent 0.7
   ;; i.e., need the following:
   ;; [reagent "0.7.0"]
   ])
