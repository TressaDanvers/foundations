package logic.implication

import logic.*

infix fun Logim.implies(other: Logim) = Implication(this, other)