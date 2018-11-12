SUMMARY = "streamproxy manages streaming data to a Mobile device using enigma2"
PRIORITY = "required"
LICENSE = "GPLv3"
LIC_FILES_CHKSUM = "file://COPYING;md5=d32239bcb673463ab874e80d47fae504"

inherit gitpkgv

PR = "r11"

PV = "0.1+git${SRCPV}"
PKGV = "0.1+git${GITPKGV}"
SRCREV_pn-${PN} ?= "${AUTOREV}"

DEPENDS += "boost"
SRC_URI = "\
	git://code.vuplus.com/git/filestreamproxy.git;protocol=git;branch=transtreamproxy \
	"
inherit autotools-brokensep

EXTRA_OECONF_vusolo4k += " --enable-ext-pid "
EXTRA_OECONF_vuultimo4k += " --enable-ext-pid "
EXTRA_OECONF_vuuno4k += " --enable-ext-pid "
EXTRA_OECONF_vuuno4kse += " --enable-ext-pid "
EXTRA_OECONF_vuduo4k += " --enable-ext-pid "

S = "${WORKDIR}/git"

do_install() {
	install -d ${D}/usr/bin
	install -m 0755 ${S}/src/transtreamproxy ${D}/usr/bin/transtreamproxy
}

PACKAGE_ARCH = "${MACHINE_ARCH}"

