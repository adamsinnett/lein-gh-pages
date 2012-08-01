(ns leiningen.gh-pages.help)

(defn print-help
    "Display usage message when asked for or no option is given"
    (println "This will be a friendly help message at some point"))

(defn unknown-task
    "Display a help message when an unknown task is given"
    [task]
    (println ("I do not know how to do " task ". Do you need help?")
     print-help))
