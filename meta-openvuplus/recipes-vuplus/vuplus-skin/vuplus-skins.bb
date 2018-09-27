DESCRIPTION = "vuplus skins."
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PV = "1.0"
PR = "r7"

RDEPENDS_${PN} = "enigma2"

BRANCH ?= "master"
SRCREV = ""

SRC_URI = " \
	git://code.vuplus.com/git/vuplus-skins.git;protocol=git;branch=${BRANCH};rev=${SRCREV} \
	file://fix_standby_name.patch \
"

S = "${WORKDIR}/git"

FILES_${PN} = "/usr"

do_install() {
	install -d ${D}/usr/
	cp -rp ${S}/usr/* ${D}/usr
	chmod -R a+rX ${D}/usr/share/enigma2/
}

do_package_qa() {
}

sysroot_stage_all() {
}

