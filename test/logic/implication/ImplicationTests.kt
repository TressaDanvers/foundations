package logic.implication

import logic.*
import kotlin.test.*
import logic.implication.implies as i

class ImplicationTests {
  @Test fun wi() { assertIs<Implication>(phi i psi) }

  @Test fun mp() { assertEquals((phi i psi) i (phi i psi), axmp) }
  @Test fun a1() { assertEquals(phi i (psi i phi), ax1) }
  @Test fun a2() { assertEquals((phi i (psi i chi)) i ((phi i psi) i (phi i chi)), ax2) }
}