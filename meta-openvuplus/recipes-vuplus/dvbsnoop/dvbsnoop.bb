SUMMARY = "DVB / MPEG stream analyzer"
AUTHOR = "Rainer Scherg <rasc@users.sourceforge.net>"
LICENSE = "GPLv2+"
LIC_FILES_CHKSUM = "file://COPYING;md5=94d55d512a9ba36caa9b7df079bae19f"

PR = "r3"

SRCREV = "cdec570a010a9a9f26a4ff25aec0e544fbfc34c5"
SRC_URI = "git://github.com/PLi-metas/dvbsnoop.git;protocol=git"
 
S = "${WORKDIR}/git"

inherit autotools

