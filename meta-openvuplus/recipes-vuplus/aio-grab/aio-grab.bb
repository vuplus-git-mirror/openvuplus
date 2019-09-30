SUMMARY = "Screen grabber for Set-Top-Boxes"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE;md5=94d55d512a9ba36caa9b7df079bae19f"
SRCREV = "8394e1ba98c73d7c56d3235ef16cce253dc597cd"
PR = "r6"

DEPENDS = "jpeg libpng"

SRC_URI = " \
	git://schwerkraft.elitedvb.net/aio-grab/aio-grab.git;protocol=git;tag=${SRCREV} \
	file://aio-grab_vuplus_22f13d68e322e0609f457282ed5bf19376397f29.patch;striplevel=1 \
"

S = "${WORKDIR}/git"

inherit autotools git-project pkgconfig


