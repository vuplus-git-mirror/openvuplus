require linux-vuplus-3.13.5.inc

COMPATIBLE_MACHINE = "^(vuzero)$"

PR = "${INC_PR}.3"

SRC_URI += " \
	file://linux_nand_bcm.patch \
"


