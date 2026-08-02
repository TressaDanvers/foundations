package logic.implication

import logic.*
import logic.proof.proof

val id = proof {
  assuming(phi)
  qed
}

val mp = proof {
  assuming(phi)
  val argument = assuming(phi implies psi)
  argue(argument)
  qed
}

val aInt = proof {
  val position = assuming(phi)
  assuming(psi)
  argue(position)
  qed
}

val aDist = proof {
  val interimB = assuming(phi implies (psi implies chi))
  val interimA = assuming(phi implies psi)
  assuming(phi)
  argue(interimA)
  argue(interimB)
  qed
}

val mpd = proof {
  assuming(phi implies psi)
  assuming(phi implies (psi implies chi))
  argue(aDist)
  qed
}

val syl = proof {
  assuming(phi implies psi)
  assuming(psi implies chi)
  argue(aInt(psi implies chi, phi))
  argue(mpd)
  qed
}

val mpi = proof {
  assuming(phi implies (psi implies chi))
  assuming(psi)
  argue(aInt(psi, phi))
  argue(mpd)
  qed
}