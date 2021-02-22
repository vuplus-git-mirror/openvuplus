require vuplus-bootlogo.inc

COMPATIBLE_MACHINE = "^(vuzero)$"

PR = "${INC_PR}.0"
SRCDATE = "20141117"

SRC_URI += "\
	http://code.vuplus.com/download/release/kernel/vmlinuz-initrd_${MACHINE}_${SRCDATE}.tar.gz \
	file://splash_cfe_auto.bin \
"

do_install_append() {
	install -m 0755 ${S}/vmlinuz-initrd-7362a0 ${D}/boot/initrd_cfe_auto.bin
        install -m 0755 ${S}/splash_cfe_auto.bin ${D}/boot/splash_cfe_auto.bin
}

SRC_URI[md5sum] = "670219b09ba2cace6ebe0492e514f340"
SRC_URI[sha256sum] = "fb23c93b727dd89e767e1d52c879045d8f40aecad049ec1d5b917843dfb0930e"
