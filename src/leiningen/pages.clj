(ns leiningen.gh-pages.pages
  (:require clj-jgit.porcelain :as jgit))

(defn find-repo
  "Return a repository object for the root-dir"
  [root-dir]
  (try (jgit/load-repo root-dir)
    (catch FileNotFoundException ((prn "Could not find the direcotry") (System/exit 1)))))

(defn valid-status?
  "Returns true if the supplied repo is a valid git repo"
  [repo]
  (jgit/git-status repo)

(defn valid-project?
  "Returns a lein project object"
  [project-or-nil]
  ());;todo

(defn new-pages
    "Generate a new pages directory and populate it with a pulp template"
    [project-or-nil root-dir template & args]
    (let [repo (find-repo root-dir)
          status (valid-status? repo)
          project (valid-project? project-or-nil)]
          ))
