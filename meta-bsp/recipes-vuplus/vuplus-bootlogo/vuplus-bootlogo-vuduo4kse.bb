require vuplus-bootlogo.inc

COMPATIBLE_MACHINE = "^(vuduo4kse)$"

PR = "${INC_PR}.4"
SRCDATE = "20200326"

SRC_URI += "\
	http://code.vuplus.com/download/release/kernel/vmlinuz-initrd_${MACHINE}_${SRCDATE}.tar.gz \
	file://splash_auto.bin \
"

do_install_append() {
	install -m 0755 ${S}/vmlinuz-initrd-7445d0 ${D}/boot/initrd_auto.bin
	install -m 0755 ${S}/splash_auto.bin ${D}/boot/splash_auto.bin
}

SRC_URI[md5sum] = "9daa46bc7e318e5bcbd4524e7f7ba013"
SRC_URI[sha256sum] = "0d78b95dfa3ae156aa1142393eb6bd624ee7bdace98de6a3c5a9ef9b3533f04f"
