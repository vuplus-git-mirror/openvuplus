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
PR = "r4"

require openplugins-distutils.inc

SRC_URI += " file://openwebif_solo4k.patch;striplevel=1 "
SRC_URI += " file://openwebif_block_in_qpip.patch"

# Just a quick hack to "compile" it
do_compile() {
	cheetah-compile -R --nobackup ${S}/plugin
	python -O -m compileall ${S}
}

PLUGINPATH = "/usr/lib/enigma2/python/Plugins/Extensions/${MODULE}"
do_install_append() {
	install -d ${D}${PLUGINPATH}
	cp -rp ${S}/plugin/* ${D}${PLUGINPATH}
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
  ('vuultimo4k', 'unknown.jpg', 'vu_normal.png'),
  ('vuuno4k', 'unknown.jpg', 'vu_normal.png'),
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

