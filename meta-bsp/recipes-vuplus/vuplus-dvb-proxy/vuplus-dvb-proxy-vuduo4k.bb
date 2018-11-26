require vuplus-dvb-proxy.inc

COMPATIBLE_MACHINE = "^(vuduo4k)$"

SRCDATE = "20181126"
SRCDATE_PR = "r0"

pkg_postinst_${PN}_append () {
	if [ ! -f $D/lib/modules/${KERNEL_VERSION}/extra/dvb-bcm.ko ]; then
		ln -s /lib/modules/${KERNEL_VERSION}/extra/dvb-bcm7278.ko $D/lib/modules/${KERNEL_VERSION}/extra/dvb-bcm.ko
	fi
}

SRC_URI[md5sum] = "5b14bac5cd37255fd4f5ee833f09403b"
SRC_URI[sha256sum] = "b67c62149614a89755ebcbe079479d6f0e0ca28bb47cec4ac1bd89839d14c873"
