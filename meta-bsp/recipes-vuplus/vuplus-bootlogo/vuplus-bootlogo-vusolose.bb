require vuplus-bootlogo.inc

COMPATIBLE_MACHINE = "^(vusolose)$"

PR = "${INC_PR}.1"
SRCDATE = "20150821"

SRC_URI += "\
	http://code.vuplus.com/download/release/kernel/vmlinuz-initrd_${MACHINE}_${SRCDATE}.tar.gz \
	file://splash_cfe_auto.bin \
"

do_install_append() {
	install -m 0755 ${S}/vmlinuz-initrd-7241b0 ${D}/boot/initrd_cfe_auto.bin
        install -m 0755 ${S}/splash_cfe_auto.bin ${D}/boot/splash_cfe_auto.bin
}

SRC_URI[md5sum] = "eb5efad0435e7c455a2e8bf1a56eb551"
SRC_URI[sha256sum] = "e374477d429c901611e81c4b38d32228aa69f42edb002d0d555023d9ba6a6816"

