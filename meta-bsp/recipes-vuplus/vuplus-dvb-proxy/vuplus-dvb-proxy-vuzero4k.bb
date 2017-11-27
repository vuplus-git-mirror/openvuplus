require vuplus-dvb-proxy.inc

COMPATIBLE_MACHINE = "^(vuzero4k)$"

SRCDATE = "20171124"
SRCDATE_PR = "r0"

pkg_postinst_${PN}_append () {
	if [ ! -f $D/lib/modules/${KERNEL_VERSION}/extra/dvb-bcm.ko ]; then
		ln -s /lib/modules/${KERNEL_VERSION}/extra/dvb-bcm72604.ko $D/lib/modules/${KERNEL_VERSION}/extra/dvb-bcm.ko
	fi
}

SRC_URI[md5sum] = "eb3af6d798a9e0c8bd26dcc8b50c8144"
SRC_URI[sha256sum] = "4654df8a538c588b4cecf25c6e9ec2a015d03b0d7f21aa966b422173264909f7"
