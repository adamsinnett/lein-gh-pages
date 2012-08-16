
(ns leiningen.gh-pages.push
  (:require clj-jgit.porcelain :as jgit))

(defn push
    "Push an existing gh-pages template directory to github, ensuring we've generated our static pages first"
    [root-dir & args]
    (let [repo-dir (get-dir root-dir)
          repo (find-repo repo-dir)]
        ((jgit/git-checkout repo "gh-pages")
         (jgit/git-status push)
         (jgit/git-checkout repo "master")))
