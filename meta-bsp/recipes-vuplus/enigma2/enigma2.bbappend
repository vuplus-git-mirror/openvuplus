FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"

PR .= "-bsp27"

SRC_URI_append_vusolo = " \
	file://enigma2_vuplus_misc.patch \
"

SRC_URI_append_vuultimo = " \
	file://analog.ttf \
	file://skin_user.xml \
	file://vfd_icons \
"

SRC_URI_append_vuduo2 = " \
	file://skin_user_vuduo2.xml \
	file://vfd_icons_vuduo2 \
"

SRC_URI_append_vusolose = " \
"

SRC_URI_append_vuzero = " \
"

SRC_URI_append_vusolo4k = " \
	file://skin_user_vusolo4k.xml \
	file://lcd_icons_vusolo4k \
"

SRC_URI_append_vuultimo4k = " \
	file://skin_user_vuultimo4k.xml \
	file://lcd_icons_vuultimo4k \
	file://enigma2_network_sys0.patch \
"

SRC_URI_append_vuuno4k = " \
"

SRC_URI_append_vuuno4kse = " \
	file://skin_user_vuuno4kse.xml \
	file://lcd_icons_vuuno4kse \
"

SRC_URI_append_vuzero4k = " \
"

do_install_append_vuultimo() {
        install -m 0755 ${WORKDIR}/analog.ttf ${D}/usr/share/fonts/
        install -m 0755 ${WORKDIR}/skin_user.xml ${D}/usr/share/enigma2/defaults/
        install -d ${D}/usr/share/enigma2/vfd_icons/
        install -m 0755 ${WORKDIR}/vfd_icons/*.png ${D}/usr/share/enigma2/vfd_icons/
}

do_install_append_vuduo2() {
        install -m 0755 ${WORKDIR}/skin_user_vuduo2.xml ${D}/usr/share/enigma2/defaults/skin_user.xml
        install -d ${D}/usr/share/enigma2/vfd_icons/
        install -m 0755 ${WORKDIR}/vfd_icons_vuduo2/*.png ${D}/usr/share/enigma2/vfd_icons/
}

do_install_append_vusolo4k() {
        install -m 0755 ${WORKDIR}/skin_user_vusolo4k.xml ${D}/usr/share/enigma2/defaults/skin_user.xml
        install -d ${D}/usr/share/enigma2/lcd_icons/
        install -m 0755 ${WORKDIR}/lcd_icons_vusolo4k/*.png ${D}/usr/share/enigma2/lcd_icons/
}

do_install_append_vuultimo4k() {
        install -m 0755 ${WORKDIR}/skin_user_vuultimo4k.xml ${D}/usr/share/enigma2/defaults/skin_user.xml
        install -d ${D}/usr/share/enigma2/lcd_icons/
        install -m 0755 ${WORKDIR}/lcd_icons_vuultimo4k/*.png ${D}/usr/share/enigma2/lcd_icons/
}

do_install_append_vuuno4kse() {
        install -m 0755 ${WORKDIR}/skin_user_vuuno4kse.xml ${D}/usr/share/enigma2/defaults/skin_user.xml
        install -d ${D}/usr/share/enigma2/lcd_icons/
        install -m 0755 ${WORKDIR}/lcd_icons_vuuno4kse/*.png ${D}/usr/share/enigma2/lcd_icons/
}

