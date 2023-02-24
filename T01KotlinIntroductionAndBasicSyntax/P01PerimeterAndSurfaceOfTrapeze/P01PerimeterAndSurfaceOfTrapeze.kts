/*
* Task 1
* Find perimeter and surface of trapeze
* (a = 5, b = 6.25, c = 4.5, d = 5.5, h = 3.825)
 */
val sideA: Int = 5
val sideB: Int = 6
val sideC: Double = 4.5
val sideD: Double = 5.5
val h:Double = 3.825

val perimeterOfTrapeze = sideA + sideB + sideC + sideD
val surfaceOfTrapeze = (sideA + sideB) * h / 2

perimeterOfTrapeze
surfaceOfTrapeze