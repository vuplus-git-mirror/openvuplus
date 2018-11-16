require vuplus-dvb-proxy.inc

COMPATIBLE_MACHINE = "^(vuduo4k)$"

SRCDATE = "20181116"
SRCDATE_PR = "r0"

pkg_postinst_${PN}_append () {
	if [ ! -f $D/lib/modules/${KERNEL_VERSION}/extra/dvb-bcm.ko ]; then
		ln -s /lib/modules/${KERNEL_VERSION}/extra/dvb-bcm7278.ko $D/lib/modules/${KERNEL_VERSION}/extra/dvb-bcm.ko
	fi
}

SRC_URI[md5sum] = "38de2d4505c5311e9162d48303883911"
SRC_URI[sha256sum] = "0618868750e48b4f1ffa22ab5a0be97a63172a4f837d605a8d0f4ab6f2106b33"
