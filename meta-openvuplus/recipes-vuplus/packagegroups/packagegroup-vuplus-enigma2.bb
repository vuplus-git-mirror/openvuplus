SUMMARY = "Enigma2 set of packages for Vuplus"
SECTION = "vuplus/base"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://${COREBASE}/meta/files/common-licenses/GPL-2.0;md5=801f80980d171dd6425610833a22dbe6"
PR = "r23"

PACKAGE_ARCH = "${MACHINE_ARCH}"

inherit packagegroup

RDEPENDS_${PN} += " \
  enigma2 \
  enigma2-defaultservices \
  enigma2-streamproxy \
  tuxbox-tuxtxt-32bpp \
  showiframe \
  enigma2-meta \
  enigma2-plugins-meta \
  enigma2-skins-meta \
  enigma2-plugin-extensions-mediascanner \
  enigma2-plugin-systemplugins-crashreport \
  enigma2-plugin-extensions-remotestreamconvert \
  enigma2-plugin-systemplugins-zappingmodeselection \
  enigma2-plugin-extensions-addstreamurl \
  enigma2-plugin-systemplugins-devicemanager \
  enigma2-plugin-systemplugins-videomode \
  enigma2-plugin-systemplugins-netdrive \
"

RRECOMMENDS_${PN} += " \
  glib-networking \
  dvbsnoop \
"

RDEPENDS_${PN} += " \
  aio-grab \
  python-misc python-shell python-ctypes \
  python-crypt \
  python-netserver \
  python-twisted-core \
  python-twisted-protocols \
  python-twisted-web \
  ${@base_contains("MACHINE_FEATURES", "wifi", "packagegroup-vuplus-wlan", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "webmanual", "vuplus-manual", "", d)} \
  enigma2-plugin-extensions-mediaplayer \
  enigma2-plugin-extensions-pictureplayer \
  enigma2-plugin-systemplugins-skinselector \
  enigma2-plugin-systemplugins-ui3dsetup \
  enigma2-plugin-systemplugins-uipositionsetup \
  enigma2-plugin-systemplugins-hdmicec \
  enigma2-plugin-extensions-openwebif \
  enigma2-plugin-extensions-satipclient \
  ${@base_contains("MACHINE_FEATURES", "wifi", "enigma2-plugin-systemplugins-wirelessaccesspoint", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "fan_simple", "enigma2-plugin-systemplugins-fancontrol","", d)} \
  ${@base_contains("VUPLUS_FEATURES", "fan_manual", "enigma2-plugin-systemplugins-manualfancontrol", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "rc_code", "enigma2-plugin-systemplugins-remotecontrolcode", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "led", "enigma2-plugin-systemplugins-ledbrightnesssetup", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "blindscan", "enigma2-plugin-systemplugins-blindscan  vuplus-blindscan-utils", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "fpgaupgrade", "enigma2-plugin-systemplugins-fpgaupgrade", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "firmwareupgrade", "enigma2-plugin-systemplugins-firmwareupgrade", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "hbbtv", "enigma2-plugin-extensions-hbbtv", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "webkithbbtv", "webkit-hbbtv-browser", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "streamtv", "enigma2-plugin-extensions-streamtv", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "dlna", "enigma2-plugin-extensions-dlnaserver enigma2-plugin-extensions-dlnabrowser", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "3gmodem", "enigma2-plugin-systemplugins-3gmodemmanager", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "autoshutdown", "enigma2-plugin-systemplugins-autoshutdown", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "transcoding", "enigma2-plugin-systemplugins-transcodingsetup enigma2-transtreamproxy", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "wol", "enigma2-plugin-systemplugins-wolsetup", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "wowl", "enigma2-plugin-systemplugins-wolsetup", "", d)} \
  ${@base_conditional("MACHINE", "vuduo2", "duo2lcd4linux lcd4linuxsupport", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "audioeffect", "enigma2-plugin-systemplugins-audioeffect", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "uianimation", "enigma2-plugin-systemplugins-animationsetup", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "xbmc", "enigma2-plugin-extensions-xbmc", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "kodi", "enigma2-plugin-extensions-kodi", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "minitv", "enigma2-plugin-extensions-minitv", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "chromiumos", "enigma2-plugin-extensions-chromium", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "fcc", "enigma2-plugin-systemplugins-fastchannelchange", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "bluetooth", "bluetoothsetup-${MACHINE}", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "bluetooth", "enigma2-plugin-extensions-witaispeechtotext", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "scrambledplayback", "enigma2-plugin-systemplugins-pvrdescrambleconvert", "", d)} \
  ${@base_contains("VUPLUS_FEATURES", "quadpip", "enigma2-plugin-extensions-quadpip", "", d)} \
"

PACKAGE_ARCH = "${MACHINE_ARCH}"

