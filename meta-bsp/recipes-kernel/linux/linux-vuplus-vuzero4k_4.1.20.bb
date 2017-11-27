KERNEL_SRC_VERSION = "1.9"
require linux-vuplus-4.1.20.inc

COMPATIBLE_MACHINE = "^(vuzero4k)$"

PR = "${INC_PR}.9"

SRC_URI[md5sum] = "9403441e47266f37ce8d9e2cdf34159d"
SRC_URI[sha256sum] = "5f5a43e222716962336df55eb98bd96001de2caf7b7dce538e266f5ba6851af6"

pkg_postinst_kernel-image () {
        if [ -d /proc/stb ] ; then
                dd if=/${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE} of=/dev/mmcblk0p4
        fi
        rm -f /${KERNEL_IMAGEDEST}/${KERNEL_IMAGETYPE}
        true
}
