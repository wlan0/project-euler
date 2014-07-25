(ns project-euler-clj.core)


(defn is_prime
        "checks if a number is prime or not"
        [n]
        (if (zero? (rem n 2)) false 
          (loop [i 3] 
            (if (> i (java.lang.Math/sqrt n)) true
            (if (zero? (rem n i)) false (recur (+ i 2))))
        )
))


(defn get_prime_val 
  "augments numbers[n] that are prime only"
  [n result]
  (if (is_prime n) (conj result n) result)
  )


(defn find_prime
  "finds all the prime numbers less than n"
  [n]
  (loop [i 3 result [2]]
    (if (> i n) result (recur (+ i 2) (get_prime_val i result))
      )
    )
)

(defn add_if_prime_factor 
  "adds the number to a list if it is a prime factor"
  [head n p_f]
  (if (zero? (rem n head)) (conj p_f head) p_f)    
)

(defn divide_if_prime_factor 
  "returns the quotient of division if it is a prime factor"
  [head n]
  (if (zero? (rem n head)) (/ n head) n)
)

(defn find_prime_factors 
  "finds the prime factors of a given number"
  [n]
  (loop [[head & remaining] (find_prime 100000) p_f [] pseudo_n n]
    (if (not (and (not (nil? head)) (not (> head pseudo_n)))) p_f (recur remaining (add_if_prime_factor head pseudo_n p_f) (divide_if_prime_factor head pseudo_n))
                       )
    )
)