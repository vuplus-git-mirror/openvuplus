require linux-vuplus-3.13.5.inc

COMPATIBLE_MACHINE = "^(vuzero)$"

PR = "${INC_PR}.4"

SRC_URI += " \
	file://linux_nand_bcm.patch \
"

SRC_URI += "${@base_contains("VUPLUS_FEATURES", "dvbproxy", "", "file://linux_dvb_adapter.patch;patch=1;pnum=1", d)}"

