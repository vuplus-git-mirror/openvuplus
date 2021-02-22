require vuplus-bootlogo.inc

COMPATIBLE_MACHINE = "^(vuuno4k)$"

PR = "${INC_PR}.3"
SRCDATE = "20170209"

SRC_URI += "\
	http://code.vuplus.com/download/release/kernel/vmlinuz-initrd_${MACHINE}_${SRCDATE}.tar.gz \
	file://splash_auto.bin \
"

do_install_append() {
	install -m 0755 ${S}/vmlinuz-initrd-7439b0 ${D}/boot/initrd_auto.bin
	install -m 0755 ${S}/splash_auto.bin ${D}/boot/splash_auto.bin
}

SRC_URI[md5sum] = "2b972c86995ad48212a25386966658a4"
SRC_URI[sha256sum] = "c383a7f67d05655c54822b1f7a89e54601831efdb530ecb6b903320e9539e9fa"
