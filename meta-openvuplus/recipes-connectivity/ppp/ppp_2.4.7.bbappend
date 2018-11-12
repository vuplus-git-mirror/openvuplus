PR .= "-vuplus1"

SRC_URI += " \
	${@base_version_less_or_equal('VUPLUS_KERNEL_VERSION', '4.1.20', '', 'file://ppp_compile_error.patch', d)} \
"

do_install_append() {
	rm ${D}/${sysconfdir}/ppp/options
	rm ${D}/${sysconfdir}/ppp/pap-secrets
}

CONFFILES_${PN} = "${sysconfdir}/ppp/chap-secrets"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"
