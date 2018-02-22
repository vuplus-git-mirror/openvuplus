PR .= "-vuplus2"

SRC_URI += " \
	file://volatiles.99_autofs \
	file://auto.master \
	file://auto.hotplug \
	file://autofs.default \
"

EXTRA_OECONF += "--with-confdir=/etc/default --with-mapdir=/etc"

do_install_append() {
    sed -i 's/count -lt 15/count -lt 60/' ${D}/etc/init.d/autofs
    sed -i 's/sleep 20/sleep 1/' ${D}/etc/init.d/autofs
    install -d ${D}${sysconfdir}/default/volatiles
    install -m 644 ${WORKDIR}/volatiles.99_autofs ${D}${sysconfdir}/default/volatiles/99_autofs
    install -m 644 ${WORKDIR}/auto.master ${D}/etc/auto.master
    install -m 644 ${WORKDIR}/auto.hotplug ${D}/etc/auto.hotplug
    install -m 644 ${WORKDIR}/autofs.default ${D}/etc/default/autofs
}

CONFFILES_${PN} = "/etc/auto.hotplug"

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
