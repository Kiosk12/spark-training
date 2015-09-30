def fizzBuzz (x):
	remainder_3 = x % 3
	remainder_5 = x % 5 
	if (remainder_3 == 0 and remainder_5 == 0): 
		return "FizzBuzz"
	elif (remainder_3 == 0): 
		return "Fizz"
	elif (remainder_5 == 0): 
		return "Buzz"
	else: 
		return `x`



for num in range(1, 101):
	print(fizzBuzz(num))
