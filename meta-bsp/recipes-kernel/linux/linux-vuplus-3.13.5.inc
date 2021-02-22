DESCRIPTION = "Linux kernel for vuplus"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PE = "1"
KV = "3.13.5"

INC_PR = "r8"
SRCREV = ""

MODULE = "linux-3.13.5"

KERNEL_CONFIG = "${@base_contains("VUPLUS_FEATURES", "dvbproxy", "${MACHINE}_defconfig_proxy", "${MACHINE}_defconfig", d)}"

SRC_URI += "http://code.vuplus.com/download/release/kernel/stblinux-${KV}.tar.bz2 \
        file://rt2800usb_fix_warn_tx_status_timeout_to_dbg.patch \
        file://linux-tcp_output.patch \
        file://${KERNEL_CONFIG} \
	"

SRC_URI += "${@base_contains("VUPLUS_FEATURES", "dvbproxy", "file://linux_dvb_adapter.patch;patch=1;pnum=1", "", d)}"

inherit kernel

S = "${WORKDIR}/linux"

RREPLACES_${PN} = "linux-vuplus"
RCONFLICTS_${PN} = "linux-vuplus"

export OS = "Linux"
KERNEL_IMAGETYPE = "vmlinux"
KERNEL_OUTPUT = "vmlinux"
KERNEL_OBJECT_SUFFIX = "ko"
KERNEL_IMAGEDEST = "tmp"

FILES_kernel-image = "/${KERNEL_IMAGEDEST}/vmlinux.gz /${KERNEL_IMAGEDEST}/autoexec.bat"

do_configure_prepend() {
        oe_machinstall -m 0644 ${WORKDIR}/${KERNEL_CONFIG} ${WORKDIR}/defconfig
}

kernel_do_install_append() {
        mv ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION} ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
        gzip -9c ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} > ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
        rm ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
}

pkg_postinst_kernel-image () {
        if [ -d /proc/stb ] ; then
                flash_erase /dev/mtd2 0 0
                nandwrite -p /dev/mtd2 /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
        fi
        rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
        true
}

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-vuplus-${KV}:"

SRC_URI[md5sum] = "19e9956653437b99b4fa6ec3e16a3e99"
SRC_URI[sha256sum] = "ef7fb307582ff243aacff8a13025fe028634aaf650ada309991ae03622962f61"

RM_WORK_EXCLUDE += "linux-vuplus-${MACHINE}"
