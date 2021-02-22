require vuplus-bootlogo.inc

COMPATIBLE_MACHINE = "^(vuultimo4k)$"

PR = "${INC_PR}.4"
SRCDATE = "20170209"

SRC_URI += "\
	http://code.vuplus.com/download/release/kernel/vmlinuz-initrd_${MACHINE}_${SRCDATE}.tar.gz \
	file://splash_auto.bin \
"

do_install_append() {
	install -m 0755 ${S}/vmlinuz-initrd-7445d0 ${D}/boot/initrd_auto.bin
	install -m 0755 ${S}/splash_auto.bin ${D}/boot/splash_auto.bin
}

SRC_URI[md5sum] = "eb886ac801f585b04cffc218c44b60bf"
SRC_URI[sha256sum] = "ec268609e4d062dd0e75d249445d41589e2d7cf68521642102cc8fd91c3a8161"
