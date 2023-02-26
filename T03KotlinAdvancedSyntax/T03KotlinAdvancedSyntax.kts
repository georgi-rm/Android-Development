fun executeFunctionAccordingToInteger(number: Int, firstFunction: (Int) -> Unit,
                                        secondFunction: (Int) -> Unit){
    if(number % 3 == 0) {
        firstFunction(number)
    } else {
        secondFunction(number)
    }
}

val functionOne = fun(number:Int){
    val validValues = arrayOf(2,3,4,5,6,12,13,14,15)
    val isPresent = if( validValues.filter { it == number }.isNotEmpty() )
        "YES"
    else
        "NO"

    println("$number -> $isPresent")
}

for (i in 0..20) {
    executeFunctionAccordingToInteger(i, functionOne) {
        val possibleDivisors = arrayOf(0,2,4,6,10,11,12,13)
        val listOfDivisors: ArrayList<Int> = ArrayList()
        possibleDivisors.forEach { divisor ->
            if(divisor != 0 && it % divisor == 0) {
                listOfDivisors.add(divisor)
            }
        }
        println("$it -> $listOfDivisors")
    }
}