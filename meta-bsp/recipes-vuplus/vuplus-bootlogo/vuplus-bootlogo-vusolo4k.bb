require vuplus-bootlogo.inc

COMPATIBLE_MACHINE = "^(vusolo4k)$"

PR = "${INC_PR}.9"
SRCDATE = "20170209"

SRC_URI += "\
	http://code.vuplus.com/download/release/kernel/vmlinuz-initrd_${MACHINE}_${SRCDATE}.tar.gz \
	file://splash_auto.bin \
"

do_install_append() {
	install -m 0755 ${S}/vmlinuz-initrd-7366c0 ${D}/boot/initrd_auto.bin
	install -m 0755 ${S}/splash_auto.bin ${D}/boot/splash_auto.bin
}

SRC_URI[md5sum] = "5baa24532311015aeb2b077ac23b9198"
SRC_URI[sha256sum] = "9180d7e73cf1f419a7919622e05092aacbc4c8fc7e876cc041d2dd4e7c2e2205"

