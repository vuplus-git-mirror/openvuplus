MODULE = "AddStreamUrl"
DESCRIPTION = "Add a stream url to your channellist"

PR="r0"

SRCREV_pn-${PN}="99b945be8bb370dccfcb3cde964483c5543f0152"
inherit gitpkgv
PV = "2.0+git${SRCPV}"
PKGV = "2.0+git${GITPKGV}"
PR = "r0"

require openplugins-distutils.inc

require assume-gplv2.inc

SRC_URI += "file://addstreamurl_uifix.patch"
