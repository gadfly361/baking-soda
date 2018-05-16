(defproject baking-soda "0.1.4"
  :description "baking-soda is an interface between clojurescript's reagent
                and reactstrap (i.e., bootstrap 4 react components)"
  :url "https://github.com/gadfly361/baking-soda"
  :license {:name "MIT"}
  :scm {:name "git"
        :url  "https://github.com/gadfly361/baking-soda"}

  :min-lein-version "2.5.3"

  :dependencies
  [[org.clojure/clojure "1.9.0"]
   [org.clojure/clojurescript "1.10.238"]
   [cljsjs/react "16.3.2-0"]
   [cljsjs/react-dom "16.3.2-0"]
   [cljsjs/react-transition-group "2.3.1-0"]
   [cljsjs/react-popper "0.10.4-0"]
   [reagent "0.8.0" :exclusions [cljsjs/react
                                 cljsjs/react-dom]]
   [cljsjs/reactstrap "6.0.1-0" :exclusions [cljsjs/react
                                             cljsjs/react-dom
                                             cljsjs/react-transition-group
                                             cljsjs/react-popper]]
   [cljsjs/react-bootstrap "0.30.7-0"]])
