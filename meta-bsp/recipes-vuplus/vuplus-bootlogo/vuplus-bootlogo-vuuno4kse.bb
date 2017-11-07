require vuplus-bootlogo.inc

COMPATIBLE_MACHINE = "^(vuuno4kse)$"

PR = "${INC_PR}.4"
SRCDATE = "20170627"

SRC_URI += "\
	http://archive.vuplus.com/download/kernel/vmlinuz-initrd_${MACHINE}_${SRCDATE}.tar.gz \
	file://splash_auto.bin \
"

do_install_append() {
	install -m 0755 ${S}/vmlinuz-initrd-7439b0 ${D}/boot/initrd_auto.bin
	install -m 0755 ${S}/splash_auto.bin ${D}/boot/splash_auto.bin
}

SRC_URI[md5sum] = "8f96e5527503a4fe776c69887e93d613"
SRC_URI[sha256sum] = "055e0a3b1fed3a524f2ae41b93d77a024effcddf85dcbee9857749366d0823a4"

