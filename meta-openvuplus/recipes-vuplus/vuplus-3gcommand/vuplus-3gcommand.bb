DESCIPTION = "3gcommand"
MAINTAINER = "vuplus team"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PV = "1.2"
PR = "r1"

SRC_URI = "http://archive.vuplus.com/download/utils/vuplus-3gcommand-${PV}.tar.gz"

do_install() {
	install -d ${D}/usr/lib/enigma2/python/Plugins/SystemPlugins/3GModemManager
	install -m 0755 ${WORKDIR}/3gcommand ${D}/usr/lib/enigma2/python/Plugins/SystemPlugins/3GModemManager/3gcommand
}

do_install_arm() {
	install -d ${D}/usr/lib/enigma2/python/Plugins/SystemPlugins/3GModemManager
	install -m 0755 ${WORKDIR}/3gcommand_arm ${D}/usr/lib/enigma2/python/Plugins/SystemPlugins/3GModemManager/3gcommand
}

PACKAGES = "${PN}"
FILES_${PN} = "/"

do_populate_sysroot[noexec] = "1"
INSANE_SKIP_${PN} = "already-stripped"

SRC_URI[md5sum] = "f6a4be1ebfa405918ac5b645f7ff7d6d"
SRC_URI[sha256sum] = "e37a6aaf2e9853326986aa8ab7cc28df17200e0a2cd1ec3f21e59b9483c73485"

