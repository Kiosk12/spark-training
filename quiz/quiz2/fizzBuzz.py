def fizzBuzz (x):
	remainder_3 = x % 3
	remainder_5 = x % 5 
	if (remainder_3 == 0 and remainder_5 == 0) : print("FizzBuzz")
	elif (remainder_3 == 0) : print("Fizz")
	elif (remainder_5 == 0) : print("Buzz")
	else : print(`x`)


map(fizzBuzz, range(1, 101))
