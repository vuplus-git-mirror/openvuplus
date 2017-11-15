MODULE = "OpenWebif"
DESCRIPTION = "Control your receiver with a browser"
LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://README;firstline=10;lastline=12;md5=9c14f792d0aeb54e15490a28c89087f7"

DEPENDS = "python-cheetah-native"
RDEPENDS_${PN} = "python-cheetah python-json python-unixadmin python-misc python-pyopenssl \
		python-shell aio-grab python-compression python-numbers python-zopeinterface \
"

SRCREV_pn-${PN}="d84307958746e6a597b43defe5bd1cb78fd745c8"
inherit gitpkgv
PV = "1+git${SRCPV}"
PKGV = "1+git${GITPKGV}"
PR = "r6"

require openplugins-distutils.inc

SRC_URI = "git://github.com/E2OpenPlugins/e2openplugin-${MODULE}.git;protocol=git \
	file://openwebif_support_vumodels.patch \
	file://openwebif_block_in_qpip.patch \
	file://openwebif_vu_box_remote.patch \
	file://rc_brown.png \
	file://box_solo4k.png \
	file://box_uno4k.png \
	file://box_ultimo4k.png \
	file://box_uno4kse.png \
"

# Just a quick hack to "compile" it
do_compile() {
	cheetah-compile -R --nobackup ${S}/plugin
	python -O -m compileall ${S}
}

PLUGINPATH = "/usr/lib/enigma2/python/Plugins/Extensions/${MODULE}"
do_install_append() {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
	install -m 0755 ${WORKDIR}/rc_brown.png ${D}${PLUGINPATH}/public/images/remotes/vu_brown.png
	install -m 0755 ${WORKDIR}/box_solo4k.png ${D}${PLUGINPATH}/public/images/boxes/solo4k.png
	install -m 0755 ${WORKDIR}/box_uno4k.png ${D}${PLUGINPATH}/public/images/boxes/uno4k.png
	install -m 0755 ${WORKDIR}/box_ultimo4k.png ${D}${PLUGINPATH}/public/images/boxes/ultimo4k.png
	install -m 0755 ${WORKDIR}/box_uno4kse.png ${D}${PLUGINPATH}/public/images/boxes/uno4kse.png
}

python do_package_prepend () {
  boxtypes = [
  ('bm750', 'duo.jpg', 'vu_normal.png'),
  ('vuduo2', 'duo2.jpg', 'vu_duo2.png'),
  ('vusolo', 'solo.jpg', 'vu_normal.png'),
  ('vusolo2', 'solo2.jpg', 'vu_normal.png'),
  ('vusolose', 'solose.jpg', 'vu_normal.png'),
  ('vuzero', 'zero.jpg', 'vu_normal.png'),
  ('vuultimo', 'ultimo.jpg', 'vu_ultimo.png'),
  ('vuuno', 'uno.jpg', 'vu_normal.png'),
  ('vusolo4k', 'solo4k.png', 'vu_normal.png'),
  ('vuuno4k', 'uno4k.png', 'vu_normal.png'),
  ('vuultimo4k', 'ultimo4k.png', 'vu_normal.png'),
  ('vuuno4kse', 'uno4kse.png', 'vu_brown.png'),
  ]
  import os
  top = '${D}${PLUGINPATH}/public/images/'
  target_box = 'unknown.jpg'
  target_remote = 'ow_remote.png'
  for x in boxtypes:
    if x[0] == '${MACHINE}':
      target_box = x[1]
      target_remote = x[2]
      break
  for root, dirs, files in os.walk(top + 'boxes', topdown=False):
    for name in files:
      if target_box != name and name != 'unknown.jpg':
        os.remove(os.path.join(root, name))
  for root, dirs, files in os.walk(top + 'remotes', topdown=False):
    for name in files:
      if target_remote != name and name != 'ow_remote.png':
        os.remove(os.path.join(root, name))
}

FILES_${PN} = "${PLUGINPATH}"

do_populate_sysroot[noexec] = "1"

PACKAGE_ARCH = "${MACHINE_ARCH}"

