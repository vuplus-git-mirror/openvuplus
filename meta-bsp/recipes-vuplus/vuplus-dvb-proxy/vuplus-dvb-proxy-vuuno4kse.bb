require vuplus-dvb-proxy.inc

COMPATIBLE_MACHINE = "^(vuuno4kse)$"

SRCDATE = "20171116"
SRCDATE_PR = "r0"

pkg_postinst_${PN}_append () {
	if [ ! -f $D/lib/modules/${KERNEL_VERSION}/extra/dvb-bcm.ko ]; then
		ln -s /lib/modules/${KERNEL_VERSION}/extra/dvb-bcm7252sse.ko $D/lib/modules/${KERNEL_VERSION}/extra/dvb-bcm.ko
	fi
}

SRC_URI[md5sum] = "dac4ac8fb64b2f53af553a980410fdc5"
SRC_URI[sha256sum] = "e0f1c37700adb9a1045a366260dae438298a546477a773b8b54e8d7a06f92a09"
