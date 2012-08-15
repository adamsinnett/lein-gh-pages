(ns leiningen.gh-pages.pages
  (:require clj-jgit.porcelain :as jgit))

(defn- find-repo
  "Return a repository object for the root-dir"
  [root-dir]
  (try (jgit/load-repo root-dir)
    (catch FileNotFoundException ((prn "Could not find the direcotry") (System/exit 1)))))

(defn- valid-status?
  "Returns true if the supplied repo is a valid git repo"
  [repo]
  (jgit/git-status repo)

(defn- valid-project?
  "Returns a lein project object"
  [project-or-nil]
  (if (nil? (:name project-or-nil))
      (nil)
      (project-or-nil)))

(defn- get-dir
  "Return the root directory of the repo"
   [root-dir project]
   (if-not (nil? root-dir)
      (root-dir)
      (:root project)))

(defn- find-branches
  "Return a vector of current branches in the repo"
  [repo]
  (jgit/git-branch-list repo))

(defn- template-or-default?
  [template-or-nil]
  (if (nil? template-or-nil)
    ({:template "default") 
    ({:template template-or-nil})))

(defn- gh-pages-exists?
    "Returns true if a gh-pages branch allready exists"
    [branches]
    (if (= -1 (.indexOf branches "gh-pages"))
        (true)
        (false)))

(defn- create-gh-pages-branch
    "Create a gh-pages branch in the current repo"
    [repo]
    (jgit/git-branch-create repo "gh-pages))
        
(defn new-pages
    "Generate a new pages directory and populate it with a pulp template"
    [project-or-nil root-dir template & args]
    (let [project (valid-project? project-or-nil)
          repo-dir (get-dir root-dir project)
          repo (find-repo repo-dir)
          site-template (template-or-default? template)
          status (valid-status? repo)
          branches (find-branches repo)]
          (if (gh-pages-exists? branches)
              ((prn "Github pages branch already exists) (System/exit 1))
              ((create-gh-pages-branch repo)
               (generate-site repo project template)))))
