DESCRIPTION = "Linux kernel for vuplus"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PE = "1"
KV = "4.1.20"

INC_PR = "r2"
SRCREV = ""

MODULE = "linux-4.1.20"

KERNEL_CONFIG = "${MACHINE}_defconfig"

SRC_URI += "http://code.vuplus.com/download/release/kernel/stblinux-4.1-${KERNEL_SRC_VERSION}.tar.bz2 \
	file://${KERNEL_CONFIG} \
	file://linux_dvb-core.patch \
	file://bcmgenet-recovery-fix.patch \
	file://linux_4_1_1_9_dvbs2x.patch \
"

SRC_URI += "${@base_contains("VUPLUS_FEATURES", "dvbproxy", "file://linux_dvb_adapter.patch;patch=1;pnum=1", "", d)}"

inherit kernel

S = "${WORKDIR}/linux"

RREPLACES_${PN} = "linux-vuplus"
RCONFLICTS_${PN} = "linux-vuplus"

export OS = "Linux"
KERNEL_IMAGETYPE = "zImage"
KERNEL_OBJECT_SUFFIX = "ko"
KERNEL_IMAGEDEST = "tmp"
KERNEL_OUTPUT = "arch/${ARCH}/boot/${KERNEL_IMAGETYPE}"

FILES_kernel-image = "/${KERNEL_IMAGEDEST}/zImage"

do_configure_prepend() {
	oe_machinstall -m 0644 ${WORKDIR}/${KERNEL_CONFIG} ${WORKDIR}/defconfig
}

kernel_do_install_append() {
        install -d ${D}/${KERNEL_IMAGEDEST}
        install -m 0755 ${KERNEL_OUTPUT} ${D}/${KERNEL_IMAGEDEST}
}

kernel_do_compile() {
        unset CFLAGS CPPFLAGS CXXFLAGS LDFLAGS MACHINE
        oe_runmake ${KERNEL_IMAGETYPE_FOR_MAKE} ${KERNEL_ALT_IMAGETYPE} CC="${KERNEL_CC}" LD="${KERNEL_LD}"
        if test "${KERNEL_IMAGETYPE_FOR_MAKE}.gz" = "${KERNEL_IMAGETYPE}"; then
                gzip -9c < "${KERNEL_IMAGETYPE_FOR_MAKE}" > "${KERNEL_OUTPUT}"
        fi
}

pkg_postinst_kernel-image () {
        if [ -d /proc/stb ] ; then
                dd if=/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} of=/dev/mmcblk0p1
        fi
        rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
        true
}

pkg_postrm_kernel-image () {
}

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-vuplus-${KV}:"

SRC_URI[md5sum] = "b3e5d84c2d1b16d191a7adfe96951b2f"
SRC_URI[sha256sum] = "74648ddfe77e95e06ca3ab1b398ff26f7dd317767dbab3d27ebdd2b9d33bba51"


RM_WORK_EXCLUDE += "linux-vuplus-${MACHINE}"
