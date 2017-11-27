require vuplus-bootlogo.inc

COMPATIBLE_MACHINE = "^(vuzero4k)$"

PR = "${INC_PR}.4"
SRCDATE = "20170522"

SRC_URI += "\
	http://archive.vuplus.com/download/kernel/vmlinuz-initrd_${MACHINE}_${SRCDATE}.tar.gz \
	file://splash_auto.bin \
"

do_install_append() {
	install -m 0755 ${S}/vmlinuz-initrd-7260a0 ${D}/boot/initrd_auto.bin
	install -m 0755 ${S}/splash_auto.bin ${D}/boot/splash_auto.bin
}

SRC_URI[md5sum] = "fb602c04f92d99c4109cdb4578dfb614"
SRC_URI[sha256sum] = "36a469463f5adef633dc0943a73c3989ec834393ca399cf1ad0d50aad0c01455"
