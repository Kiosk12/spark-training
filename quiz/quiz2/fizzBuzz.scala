def fizzBuzz(x:Int): String = (x % 3, x % 5) match {
	case (0, 0) => "FizzBuzz"
	case (0, _) => "Fizz"
	case (_, 0) => "Buzz"
	case (_, _) => x.toString()
}

println((1 to 100).map(fizzBuzz).mkString("\n "))
