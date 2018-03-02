DESCRIPTION = "gstreamer dvbmediasink plugin"
SECTION = "multimedia"
PRIORITY = "optional"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://COPYING;md5=7fbc338309ac38fefcd64b04bb903e34"

DEPENDS = "gstreamer1.0 gstreamer1.0-plugins-base libdca"

GSTVERSION = "1.0"

PR = "r6"
SRCREV = "e83973478549ecb52067f30a3537b590d83401d6"
SRC_URI = " \
	git://github.com/OpenPLi/gst-plugin-dvbmediasink.git;protocol=git;branch=gst-1.0 \
	file://dvbmediasink_h265.patch \
	file://audiosink_change_message_mode_to_sync.diff \
	file://dvbmediasink_divx4.patch \
	file://audiosink_mpeg4_aac_header.patch \
	file://videosink_ffmpeg_mpeg4_nofourcc.patch \
"

S = "${WORKDIR}/git"

inherit gitpkgv

PV = "${GSTVERSION}+git${SRCPV}"
PKGV = "${GSTVERSION}+git${GITPKGV}"

inherit autotools pkgconfig

FILES_${PN} = "${libdir}/gstreamer-${GSTVERSION}/*.so*"
FILES_${PN}-dev += "${libdir}/gstreamer-${GSTVERSION}/*.la"
FILES_${PN}-staticdev += "${libdir}/gstreamer-${GSTVERSION}/*.a"
FILES_${PN}-dbg += "${libdir}/gstreamer-${GSTVERSION}/.debug"

PACKAGE_ARCH = "${MACHINE_ARCH}"

EXTRA_OECONF = "${DVBMEDIASINK_CONFIG} --with-gstversion=${GSTVERSION}"

RPROVIDES_${PN} = "gst-plugin-dvbmediasink"

DVBMEDIASINK_CONFIG = "--with-wmv --with-pcm --with-eac3"
