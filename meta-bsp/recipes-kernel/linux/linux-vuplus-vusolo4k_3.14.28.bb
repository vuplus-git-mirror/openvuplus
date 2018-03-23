require linux-vuplus-3.14.28.inc

COMPATIBLE_MACHINE = "^(vusolo4k)$"

PR = "${INC_PR}.8"

SRC_URI += "\
	file://linux_rpmb_not_alloc.patch \
"
