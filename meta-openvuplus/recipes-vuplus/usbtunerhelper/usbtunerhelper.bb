DESCIPTION = "helper tool to use usb dvb frontends"
MAINTAINER = "PLi team"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"

PV = "1.0+git${SRCPV}"
PR = "r9"
SRC_REV = ""

SRC_URI = " \
	git://code.vuplus.com/git/vtuner.git;protocol=git;tag=${SRC_REV} \
	file://no_usb_device.patch;striplevel=1 \
	file://fix_set_delsys.patch \
	file://fix_getopt_error.patch \
	file://get_avail_vtuner.patch \
	file://setfrontend_ofdm_fecauto.patch \
	file://pump_proc_checksize.patch \
	file://fix_delayed_loading.patch \
	file://${PN}.sh \
	"

SRC_URI += "${@base_version_less_or_equal('VUPLUS_KERNEL_VERSION', '3.13.5', '', 'file://fix_vtuner_def.patch', d)}"

do_configure_prepend() {
        sed -i 's/AM_INIT_AUTOMAKE.*$/AM_INIT_AUTOMAKE([foreign subdir-objects])/' ${S}/configure.ac
}

S = "${WORKDIR}/git"

inherit autotools update-rc.d

INITSCRIPT_NAME = "${PN}"
INITSCRIPT_PARAMS = "defaults"
INITSCRIPT_PARAMS = "start 21 2 3 4 5 . stop 20 0 1 6 ."

do_install_append() {
	install -d ${D}/etc/init.d
	install -m 0755 ${WORKDIR}/${PN}.sh ${D}/etc/init.d/${PN}
}
