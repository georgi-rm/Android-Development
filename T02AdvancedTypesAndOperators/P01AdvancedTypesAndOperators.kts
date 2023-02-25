var counterEven:Int = 0
var counterOdd:Int = 0
var counterPrime:Int = 0

numbers@ for (i in 2..100) {
    if(i % 2 == 0) {
        counterEven++
    } else {
        counterOdd++
    }

    val dividers = i - 1
    for (j in 2..dividers){
        if(i % j == 0) {
            continue@numbers
        }
    }

    counterPrime++
    println(i)
}

println("Counter for Even numbers: $counterEven")
println("Counter for Odd numbers: $counterOdd")
println("Counter for Prime numbers: $counterPrime")