(ns composed.templates)

(def templates {
 "container" {
  :id "system", :type :box, :layout nil
  :props {}
  :attrs {}
  :presets #{}
  :style {"border" "1px solid #ccc", "padding" "8px", "margin" "8px", "background-color" "white"}
  :children {
   "T" {
    :id "T", :type :box, :layout :row-parted
    :props {}
    :attrs {}
    :presets #{}
    :style {}
    :children {
     "T" {
      :id "T", :type :text, :layout nil
      :props {"value" "some header"}
      :attrs {}
      :presets #{:font-fancy}
      :style {}
      :children {}
     }
     "j" {
      :id "j", :type :icon, :layout nil
      :props {"name" "settings"}
      :attrs {}
      :presets #{}
      :style {}
      :children {}
     }
    }
   }
  }
 }
})
