package logic.equivalence

import logic.*

infix fun Logeme.equiv(other: Logeme) = Equivalence(this, other)