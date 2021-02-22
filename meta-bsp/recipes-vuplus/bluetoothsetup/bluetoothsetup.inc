DESCRIPTION = "Vuplus bluetooth plugin"

LICENSE = "CLOSED"
require conf/license/license-close.inc

DEPENDS = "python-native"
RDEPENDS_${PN} = "vuplus-bluetooth-util libusb-compat"

PROVIDES += "enigma2-plugin-systemplugins-bluetoothsetup"
RPROVIDES_${PN} += "enigma2-plugin-systemplugins-bluetoothsetup"

RREPLACES_${PN} = "enigma2-plugin-systemplugins-bluetoothsetup"

PR="${@base_version_less_or_equal('PYTHON_BASEVERSION', '2.7', "${SRCDATE}.${SRCDATE_PR}", "${SRCDATE_PY3}-py3.${SRCDATE_PY3_PR}", d)}"
CHECKSUM_NAME = "${@base_version_less_or_equal('PYTHON_BASEVERSION', '2.7', '', 'name=py3', d)}"

SRC_URI = " \
    http://code.vuplus.com/download/release/bt/enigma2-plugin-bluetoothsetup-${MACHINE}-${PR}.tar.gz;${CHECKSUM_NAME} \
"

S = "${WORKDIR}/plugin"

BLUETOOTH_PLUGIN_PATH = "/usr/lib/enigma2/python/Plugins/SystemPlugins/BluetoothSetup"

do_compile() {
	python -O -m compileall ${S}
}

do_install() {
	install -d  ${D}${BLUETOOTH_PLUGIN_PATH}
	cp -rp ${S}/* ${D}${BLUETOOTH_PLUGIN_PATH}
}

FILES_${PN} = "${BLUETOOTH_PLUGIN_PATH}"

do_populate_sysroot[noexec] = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

INSANE_SKIP_${PN} = "already-stripped"

