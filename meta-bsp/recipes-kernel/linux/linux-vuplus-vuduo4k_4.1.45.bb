require linux-vuplus-4.1.45.inc

COMPATIBLE_MACHINE = "^(vuduo4k)$"

SRC_URI += " \
	file://bcmsysport_4_1_45.patch \
	file://linux_usb_hub.patch \
"

PR = "${INC_PR}.3"

