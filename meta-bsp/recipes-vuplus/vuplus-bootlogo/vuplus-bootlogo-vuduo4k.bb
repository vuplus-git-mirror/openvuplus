require vuplus-bootlogo.inc

COMPATIBLE_MACHINE = "^(vuduo4k)$"

PR = "${INC_PR}.5"
SRCDATE = "20181030"

SRC_URI += "\
	http://code.vuplus.com/download/release/kernel/vmlinuz-initrd_${MACHINE}_${SRCDATE}.tar.gz \
	file://splash_auto.bin \
"

do_install_append() {
	install -m 0755 ${S}/vmlinuz-initrd-7278b1 ${D}/boot/initrd_auto.bin
	install -m 0755 ${S}/splash_auto.bin ${D}/boot/splash_auto.bin
}

SRC_URI[md5sum] = "2280778c1a445ea7727268597ac559be"
SRC_URI[sha256sum] = "42d3bac078edfc0c80d82caad708fdb4eca5cef5d130e7fc2e6fafdb11e66b64"
