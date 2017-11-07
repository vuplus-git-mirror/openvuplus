DESCIPTION = "dinaserver"
MAINTAINER = "vuplus team"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PV = "1.2"
PR = "r1"

SRC_URI = "http://archive.vuplus.com/download/utils/vuplus-dlnaserver-${PV}.tar.gz"

do_install() {
	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/DLNAServer
	install -m 0755 ${WORKDIR}/dlnaserver ${D}/usr/lib/enigma2/python/Plugins/Extensions/DLNAServer/dlnaserver
}

do_install_arm() {
	install -d ${D}/usr/lib/enigma2/python/Plugins/Extensions/DLNAServer
	install -m 0755 ${WORKDIR}/dlnaserver_arm ${D}/usr/lib/enigma2/python/Plugins/Extensions/DLNAServer/dlnaserver
}

PACKAGES = "${PN}"
FILES_${PN} = "/"

do_populate_sysroot[noexec] = "1"
INSANE_SKIP_${PN} = "already-stripped"

SRC_URI[md5sum] = "215a700d00172a1637c2e9269b1c54ca"
SRC_URI[sha256sum] = "a73d83303b09fab93e53108fd93c8cfaa9011d3e3e564804d319e351ba1df985"

