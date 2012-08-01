(ns leiningen.gh-pages
  (:use leiningen.gh-pages.pages
        leiningen.gh-pages.push)
  (:require [leiningen.gh-pages.help   :as help]))

(defn gh-pages
  "A leiningen plugin for generating a github page for the current project"
  ([]
     (help/print-help))
  ([task]
     (gh-pages nil task))
  ([project-or-nil task & args]
     (let [root-dir (common/get-root args)]
       (case task
         "new"      (apply new-pages project-or-nil args)
         "push"     (apply push root-dir args)
         (help/unknown task)))
   (shutdown-agents)))
