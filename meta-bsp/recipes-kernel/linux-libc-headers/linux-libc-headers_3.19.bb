FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

require linux-libc-headers.inc

SRC_URI += " file://linux_3.19_dmx_source_dvr.patch "

SRC_URI[md5sum] = "d3fc8316d4d4d04b65cbc2d70799e763"
SRC_URI[sha256sum] = "be42511fe5321012bb4a2009167ce56a9e5fe362b4af43e8c371b3666859806c"
