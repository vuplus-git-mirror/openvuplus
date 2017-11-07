PR .= "-vuplus4"

do_install_append() {
	rm -rf ${D}/hdd
        rm -rf ${D}/mnt
        ln -sf media/hdd ${D}/hdd
        ln -sf media ${D}/mnt

        ln -sf var/run ${D}/run

        install -m 0755 -d ${D}/media/net
        install -m 0755 -d ${D}/media/hdd
}

FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

