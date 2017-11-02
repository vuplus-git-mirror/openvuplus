DESCRIPTION = "vuplus web manual"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PROVIDES += "vuplus-manual"
RPROVIDES_${PN} += "vuplus-manual"

PR = "${SRC_DATE}_r1"
SRC_URI = "http://code.vuplus.com/download/vuplus_manual/${MACHINE}_${SRC_DATE}.tar.gz"

INHIBIT_PACKAGE_STRIP = "1"
S = "${WORKDIR}/${MACHINE}"

do_compile() {
}

do_install() {
	install -d ${D}/usr/local/manual;
	cp -a ${S}/* ${D}/usr/local/manual;
}

PACKAGE_ARCH := "${MACHINE_ARCH}"

PACKAGES = "${PN}"
FILES_${PN} = "/"

