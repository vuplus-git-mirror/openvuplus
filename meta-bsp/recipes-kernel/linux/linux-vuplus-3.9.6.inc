DESCRIPTION = "Linux kernel for vuplus"
SECTION = "kernel"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"

PE = "1"
KV = "3.9.6"

INC_PR = "r6"
SRCREV = ""

MODULE = "linux-3.9.6"

SRC_URI += "http://code.vuplus.com/download/release/kernel/stblinux-${KV}.tar.bz2 \
        file://fix_fuse_for_linux_mips_3-9.patch \
	file://rt2800usb_fix_warn_tx_status_timeout_to_dbg.patch \
        file://${MACHINE}_defconfig \
	"

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
        oe_machinstall -m 0644 ${WORKDIR}/${MACHINE}_defconfig ${WORKDIR}/defconfig
}

kernel_do_install_append() {
        mv ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}-${KERNEL_VERSION} ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
        gzip -9c ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} > ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
        rm ${D}/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
}

pkg_postinst_kernel-image () {
        if [ -d /proc/stb ] ; then
                flash_erase /dev/mtd1 0 0
                nandwrite -p /dev/mtd1 /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
        fi
        rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}.gz
        true
}

FILESEXTRAPATHS_prepend := "${THISDIR}/linux-vuplus-${KV}:"

SRC_URI[md5sum] = "33142378c8387a87190156be1cb1a254"
SRC_URI[sha256sum] = "47799db9e2658906e532981ec8111a915426b8453762561029733f2406c3e297"

RM_WORK_EXCLUDE += "linux-vuplus-${MACHINE}"
