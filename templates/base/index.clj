[:html
  [:head
    [:title (:name config)]]

  [:body
    [:p "Title " (:name config)]
    [:p "Desciription " (:description config)]
    [:p "Dependencies " (:dependencies config)]
    [:p "Version " (:version config)]]]
