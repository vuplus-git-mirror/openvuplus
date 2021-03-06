DESCRIPTION = "Linux kernel for vuplus"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PE = "1"
KV = "3.14.28"

INC_PR = "r7"
SRCREV = ""

MODULE = "linux-3.14.28"

KERNEL_CONFIG = "${MACHINE}_defconfig"

KSRC_VER = "3.14-1.8"
SRC_URI += "http://code.vuplus.com/download/release/kernel/stblinux-${KSRC_VER}.tar.bz2 \
	file://${KERNEL_CONFIG} \
	file://bcm_genet_disable_warn.patch \
	file://linux_dvb-core.patch \
	file://rt2800usb_fix_warn_tx_status_timeout_to_dbg.patch \
	file://usb_core_hub_msleep.patch \
	file://linux_3_1x_dvbs2x.patch \
	${@base_contains("VUPLUS_FEATURES", "dvbproxy", "file://linux_dvb_adapter.patch", "", d)} \
	"

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

SRC_URI[md5sum] = "1a62540fdd7f23aa2c1ebf119ca71e91"
SRC_URI[sha256sum] = "a464515d14dda772047ddba7900858f535057294903341e2c1774009eaf95005"

RM_WORK_EXCLUDE += "linux-vuplus-${MACHINE}"
