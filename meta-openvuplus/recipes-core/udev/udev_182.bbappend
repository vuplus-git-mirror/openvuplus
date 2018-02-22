PR .= "-vuplus7"

SRC_URI += " \
	file://99_vuplus.rules \
	file://automount.py \
	file://autoumount.py \
	file://udev_scan_sys_block.patch \
"

do_install_append () {
	rm ${D}${sysconfdir}/udev/rules.d/*.rules || /bin/true
	install -m 0755 ${WORKDIR}/99_vuplus.rules ${D}${sysconfdir}/udev/rules.d
	install -m 0755 ${WORKDIR}/automount.py ${D}${sysconfdir}/udev
	install -m 0755 ${WORKDIR}/autoumount.py ${D}${sysconfdir}/udev
	sed -i s@udev_run=\"\/var\/run\/udev\"@\#udev_run=\"\/var\/run\/udev\"@ -i ${D}${sysconfdir}/udev/udev.conf
}

FILESEXTRAPATHS_prepend := "${THISDIR}/${P}:"
