package logic.implication

import logic.*

infix fun Logeme.implies(other: Logeme) = Implication(this, other)