(ns cljvaadin.core
  (:import [com.vaadin Application]
	   [com.vaadin.ui Window Label Button Button$ClickListener]))

(defn main []
  (proxy [Application] []
    (init []
	  (let [app this]
	    (.setMainWindow app
			    (doto (Window. "Test application")
			      (.addComponent
			       (Label. "Hello Vaadin/Clojure user!"))
			      (.addComponent
			       (doto (Button. "Click me")
				 (.addListener
				  (proxy [Button$ClickListener] []
				    (buttonClick [event]
						 (.. app
						     getMainWindow
						     (showNotification "button was clicked")))))))))))))