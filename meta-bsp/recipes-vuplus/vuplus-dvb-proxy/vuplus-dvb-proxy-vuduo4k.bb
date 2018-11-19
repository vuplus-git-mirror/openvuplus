require vuplus-dvb-proxy.inc

COMPATIBLE_MACHINE = "^(vuduo4k)$"

SRCDATE = "20181119"
SRCDATE_PR = "r1"

pkg_postinst_${PN}_append () {
	if [ ! -f $D/lib/modules/${KERNEL_VERSION}/extra/dvb-bcm.ko ]; then
		ln -s /lib/modules/${KERNEL_VERSION}/extra/dvb-bcm7278.ko $D/lib/modules/${KERNEL_VERSION}/extra/dvb-bcm.ko
	fi
}

SRC_URI[md5sum] = "5b3e8a44857350a0885599c56dc1d7a3"
SRC_URI[sha256sum] = "39b119ed8d070b0221e3c7e435fa52f5988d758886f47062a85afbe0ec7af4fb"
