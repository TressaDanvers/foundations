package logic.implication

import logic.*

val mp = phi implies ((phi implies psi) implies psi)
val aInt = phi implies (psi implies phi)
val aDist = (phi implies (psi implies chi)) implies
    ((phi implies psi) implies (phi implies chi))

val mpd = Proof {
  assuming(phi implies psi)
  assuming(phi implies (psi implies chi))
  argue(aDist)
  argue(mp(phi implies psi, phi implies chi))
  qed
}

val syl = Proof {
  assuming(phi implies psi)
  assuming(psi implies chi)
  argue(aInt(psi implies chi, phi))
  argue(mpd)
  qed
}

val mpi = Proof {
  assuming(phi implies (psi implies chi))
  assuming(psi)
  argue(aInt(psi, phi))
  argue(mpd)
  qed
}