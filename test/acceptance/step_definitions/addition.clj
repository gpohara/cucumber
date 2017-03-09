(use 'calculator.core) ;; yes, no namespace declaration
(use 'clojure.test)

(def world (atom {:inputs []
                  :actual-result nil}))

(Given #"^I have a new calculator$" []
       (swap! world assoc :inputs []))

(Given #"^I have entered (\d+) into the calculator$" [input]
       (swap! world update-in [:inputs] conj (bigdec input)))

(When #"^I press add$" []
      (swap! world assoc :actual-result (reduce add (:inputs @world))))

(When #"^I press sub$" []
      (swap! world assoc :actual-result (reduce sub (:inputs @world))))

(Then #"^the result should be (\d+) on the screen$" [result]
      (assert (= (bigdec result) (:actual-result @world))))
