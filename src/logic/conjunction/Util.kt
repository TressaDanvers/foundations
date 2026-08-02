package logic.conjunction

import logic.*

infix fun Logeme.and(other: Logeme) = Conjunction(this, other)