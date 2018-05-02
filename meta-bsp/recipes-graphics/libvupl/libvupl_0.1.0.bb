DESCRIPTION = "Vu+ API for EGL/OpenGLES"
SECTION = "libs"
LICENSE = "CLOSED"
require conf/license/license-close.inc

RDEPENDS_${PN} = "libgles"

PR = "${SRCDATE}.${SRCDATE_PR}"

SRC_URI = "http://archive.vuplus.com/download/build_support/vuplus/${PN}-${PV}-${MACHINE}-${PR}.tar.gz"

require ${PN}-${MACHINE}.inc

INHIBIT_PACKAGE_STRIP = "1"
S = "${WORKDIR}/${PN}-${PV}-${MACHINE}"

inherit pkgconfig

do_install() {
	install -d ${D}${includedir}
	install -m 644 ${S}/include/* ${D}${includedir}/
	install -d ${D}${libdir}
	install -m 755 ${S}/lib/*.so ${D}${libdir}/
}

do_package_qa() {
}

PACKAGE_ARCH := "${MACHINE_ARCH}"

PACKAGES = "${PN}"
FILES_${PN}="/usr/lib /usr/include"
