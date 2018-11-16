require vuplus-platform-util.inc

COMPATIBLE_MACHINE = "^(vuduo4k)$"

PV="18.1"
SRCDATE = "20181116"
SRCDATE_PR = "r0"

SRC_URI += "\
	file://bp3flash.tar.gz \
"

do_install_append() {
	install -m 0755 ${WORKDIR}/bp3flash.py ${D}${bindir}
}

SRC_URI[md5sum] = "8e6f68601aca1f73ae083b01891fa90c"
SRC_URI[sha256sum] = "2a1619691bddce610b715627057ba4614d2c5dca9fe919939e8ec03922858c2e"
