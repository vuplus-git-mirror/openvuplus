DESCRIPTION = "Chromium and YoutubeTV"
SECTION = "base"
PRIORITY = "required"
LICENSE = "CLOSED"
require conf/license/license-close.inc

PV = "1.1"
PR = "${SRCDATE}"
SRC_URI = "http://code.vuplus.com/download/chromium/chromium-vuplus_${MACHINE}_${SRCDATE}.tar.gz"

# Added to support the OE-Alliance.
PREFERRED_VERSION_nss = "3.17.3"

DEPENDS_${PN} = "nss python-subprocess libxslt"
RDEPENDS_${PN} = "nspr nss python-subprocess libxslt"

do_install() {
	install -d ${D}/usr/local/chromium
	cp -afR ${WORKDIR}/chromium/* ${D}/usr/local/chromium/
	chmod 755 ${D}/usr/local/chromium/run.sh
	chmod 755 ${D}/usr/local/chromium/bin/browser_shell
	chmod 755 ${D}/usr/local/chromium/bin/chrome
	chmod 755 ${D}/usr/local/chromium/bin/chrome-sandbox
	chmod 755 ${D}/usr/local/chromium/bin/goexit
}

do_package_qa() {
}

PROVIDES += "chromium-browser"
RPROVIDES_${PN} += "chromium-browser"

PACKAGE_ARCH := "${MACHINE_ARCH}"

FILES_${PN} = "/"

INHIBIT_PACKAGE_STRIP = "1"

