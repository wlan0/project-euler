(ns project-euler-clj.core)

(defn div-by-2?
     "a function that finds if a number is even, and returns the number if it is else 0"
     [x]
     (if (zero? (rem x 2)) x 0)
)

(defn fib 
  "computes the fibonacci upto n"
  [n]
  (loop [firstx 1 secondx 2 result [firstx secondx]] 
    (if (>= secondx n) result 
      (recur (let [firstx secondx] firstx) (let [secondx (+ firstx secondx)] secondx) (conj result (+ firstx secondx)))))
)

(defn sum-even-fib
  "finds the sum of even fibonacci numbers less than n"
  [n]
  (let [complete-seq (fib n) fib-seq (subvec complete-seq 0 (dec (count complete-seq)))] 
    (loop [[fib-num & remaining] fib-seq rem [] sum 0]
      (if (empty? remaining) (+ sum (div-by-2? fib-num))
        (recur remaining (conj rem remaining) (+ sum (div-by-2? fib-num)))
        )
      )
  )
)