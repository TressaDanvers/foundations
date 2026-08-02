package logic.conjunction

import logic.*

infix fun Logim.and(other: Logim) = Conjunction(this, other)