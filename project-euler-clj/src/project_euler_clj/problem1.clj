(ns project-euler-clj.core)

(defn div-by-5?
  "a function that finds if a number is divisible by 5"
  [x]
  (zero? (rem x 5))
 )

(defn div-by-3?
  "a function that finds if a number is divisible by 3"
  [x]
  (zero? (rem x 3))
)

(defn div-by-3-5?
  "a function that finds if a number is divisible by 3 or 5, and returns the number if it is else returns 0"
  [x]
  (if (or (div-by-3? x) (div-by-5? x)) x 0) 
)

(defn iterator 
  "Iterates from the input number to 1, and finds the sum of all numbers divisible by 3 nd 5 on the way"
  [x sum]
  (loop [y 1 sum 0]
    (if  (= y x)
      sum
      (recur (inc y) (+ (div-by-3-5? y) sum)))
    )
)