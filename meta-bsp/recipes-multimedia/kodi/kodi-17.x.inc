SUMMARY = "Kodi Media Center"

LICENSE = "GPLv2"
LIC_FILES_CHKSUM = "file://LICENSE.GPL;md5=930e2a5f63425d8dd72dbd7391c43c46"

DEFAULT_PREFERENCE = "-1"
#FILESPATH =. "${FILE_DIRNAME}/kodi-${PV}:"
PACKAGE_ARCH = "${MACHINE}"

PROVIDES += "kodi"
RPROVIDES_${PN} += "kodi"

BRANCH = "Krypton"
PV = "17.0"
PR = "r1"

SRC_URI = " \
	http://archive.vuplus.com/download/build_support/kodi/kodi-${PV}-Krypton.tar.gz;name=Src \
	http://archive.vuplus.com/download/build_support/kodi/xbmc-${PV}-Util.tar.gz;name=Util \
	file://xbmc-${PV}-vuplus-patch.diff \
	"

SRC_URI[Src.md5sum] = "86ebb2f148090f12beb1e573dfd55e53"
SRC_URI[Src.sha256sum] = "4bfffa2493973ae15ab1d922632c09a2583908d6140bc4f58ec8f9314e4f6545"	

SRC_URI[Util.md5sum] = "8f1b23f87d8e64c9b59cf49ff23652e0"
SRC_URI[Util.sha256sum] = "2bc48ecd8ea2886ca13b483066dee16e5390e1a6733adc00b719b7f2d9e810f4"

DEPENDS = " \
	libgles \
	cmake-native \
	curl-native \
	gperf-native \
	nasm-native \
	swig-native \
	yasm-native \
	zip-native \
	avahi \
	boost \
	bzip2 \
	curl \
	libdcadec \
	enca \
	expat \
	faad2 \
	ffmpeg \
	fontconfig \
	fribidi \
	giflib \
	jasper \
	libass \
	libcdio \
	libcec \
	libmad \
	libmicrohttpd \
	libmms \
	libmodplug \
	libpcre \
	libplist \
	libsamplerate0 \
	libsdl-image \
	libsdl-mixer \
	libsquish \
	libssh \
	libtinyxml \
	libusb1 \
	libxslt \
	lzo \
	mpeg2dec \
	python \
	samba \
	sqlite3 \
	taglib \
	virtual/libsdl \
	wavpack \
	yajl \
	zlib \
	kodiegl \
	"

RDEPENDS_${PN} = "python"
RDEPENDS_${PN} += "\
	python-distutils \
	python-subprocess \
	python-robotparser \
	python-mechanize \
	python-threading \
	python-shell \
	python-zlib \
	python-sqlite3 \
	python-json \
	python-xml \
	python-html \
	python-netserver \
	python-misc \
	python-pygobject \
	python-pygobject-lib \
	python-textutils \
	python-simplejson \
	python-xmlrpc   \
	python-pprint \
	python-difflib \
	python-email \
	python-compression \
	python-compile \
	python-compiler \
	python-numbers \
	python-pkgutil \
	nfs-utils-client \
	libshairport \
	glibc-gconv-utf-32 \
	xz \
	tiff \
	yajl \
	libxslt \
	libupnp \
	libplist \
	librtmp \
	libbluray \
	libnfs \
	libtinyxml \
	alsa-lib \
	shairplay \
	kodiegl \
"

inherit autotools-brokensep gettext pythonnative

ACCEL ?= ""
ACCEL_x86 = "vaapi vdpau"
ACCEL_x86-64 = "vaapi vdpau"

PACKAGECONFIG ??= "${ACCEL}"
PACKAGECONFIG_append += "${@bb.utils.contains('DISTRO_FEATURES', 'x11', ' x11', '', d)}"
PACKAGECONFIG_append += "${@bb.utils.contains('DISTRO_FEATURES', 'opengl', ' opengl', ' openglesv2', d)}"

PACKAGECONFIG[opengl] = "--enable-gl,--enable-gles,"
PACKAGECONFIG[openglesv2] = "--enable-gles,--enable-gl"
PACKAGECONFIG[vaapi] = "--enable-vaapi,--disable-vaapi,libva"
PACKAGECONFIG[vdpau] = "--enable-vdpau,--disable-vdpau,libvdpau"
PACKAGECONFIG[mysql] = "--enable-mysql,--disable-mysql,mysql5"
PACKAGECONFIG[x11] = "--enable-x11,--disable-x11,libxinerama libxmu libxrandr libxtst"
PACKAGECONFIG[lcms] = "--enable-lcms2,--disable-lcms2,lcms"

EXTRA_OECONF_append_rpi = " --disable-openmax --enable-player=omxplayer --with-platform=raspberry-pi2"
EXTRA_OECONF_remove_aarch64 = "--with-platform=raspberry-pi2"
LDFLAGS_append_rpi = " -lvchostif "

S = "${WORKDIR}/xbmc-${PV}-${BRANCH}"

EXTRA_OECONF = " \
	--disable-debug \
	--disable-libcap \
	--disable-ccache \
	--disable-mid \
	--enable-libusb \
	--disable-alsa \
	--enable-airplay \
	--disable-optical-drive \
	--enable-texturepacker=no \
	--enable-optimizations \
	--disable-lirc \
	--disable-dbus \
	--disable-gtest \
	--enable-libusb \
	--disable-ssh \
	--enable-pulse=no \
	--disable-libcec \
	"

FULL_OPTIMIZATION_armv7a = "-fexpensive-optimizations -fomit-frame-pointer -O3 -ffast-math"
FULL_OPTIMIZATION_armv7ve = "-fexpensive-optimizations -fomit-frame-pointer -O3 -ffast-math"
BUILD_OPTIMIZATION = "${FULL_OPTIMIZATION}"

EXTRA_OECONF_append = " LIBTOOL=${STAGING_BINDIR_CROSS}/${HOST_SYS}-libtool"

# for python modules
export HOST_SYS
export BUILD_SYS
export STAGING_LIBDIR
export STAGING_INCDIR
export PYTHON_DIR
export PARALLEL_MAKE

do_configure() {
	cp -af ${WORKDIR}/xbmc-${PV}-Util/ffmpeg-3.1.6-Krypton.tar.gz ${S}/tools/depends/target/ffmpeg/
	cp -af ${WORKDIR}/xbmc-${PV}-Util/crossguid-8f399e8bd4.tar.gz ${S}/tools/depends/target/crossguid/
	cp -af ${WORKDIR}/xbmc-${PV}-Util/libdvdcss-2f12236bc1c92f73c21e973363f79eb300de603f.tar.gz ${S}/tools/depends/target/libdvdcss/
	cp -af ${WORKDIR}/xbmc-${PV}-Util/libdvdnav-981488f7f27554b103cca10c1fbeba027396c94a.tar.gz ${S}/tools/depends/target/libdvdnav/
	cp -af ${WORKDIR}/xbmc-${PV}-Util/libdvdread-17d99db97e7b8f23077b342369d3c22a6250affd.tar.gz ${S}/tools/depends/target/libdvdread/

	( for i in $(find ${S} -name "configure.*" ) ; do
		cd $(dirname $i) && gnu-configize --force || true
	done )
	make -C tools/depends/native/JsonSchemaBuilder
	make -C tools/depends/target/crossguid PREFIX=${STAGING_DIR_HOST}${prefix} BASE_URL=http://ftp.vim.org/mediaplayer/xbmc/build-deps/sources
	BOOTSTRAP_STANDALONE=1 make -f bootstrap.mk JSON_BUILDER="${S}/tools/depends/native/JsonSchemaBuilder/bin/JsonSchemaBuilder"
	BOOTSTRAP_STANDALONE=1 make -f codegenerator.mk JSON_BUILDER="${S}/tools/depends/native/JsonSchemaBuilder/bin/JsonSchemaBuilder"
	oe_runconf
}

INSANE_SKIP_${PN} = "rpaths"

FILES_${PN} = "${libdir}/kodi ${libdir}/xbmc"
FILES_${PN} += "${bindir}/kodi ${bindir}/xbmc"
FILES_${PN} += "${datadir}/icons ${datadir}/kodi ${datadir}/xbmc"
FILES_${PN} += "${bindir}/kodi-standalone ${bindir}/xbmc-standalone ${datadir}/xsessions"
FILES_${PN}-dev = "${includedir}"
FILES_${PN}-dbg += "${libdir}/kodi/.debug ${libdir}/kodi/*/.debug ${libdir}/kodi/*/*/.debug ${libdir}/kodi/*/*/*/.debug ${datadir}/applications"

# xbmc uses some kind of dlopen() method for libcec so we need to add it manually
# OpenGL builds need glxinfo, that's in mesa-demos
RRECOMMENDS_${PN}_append = " \
	libcec \
	python \
	python-lang \
	python-re \
	python-netclient \
	python-html \
	python-difflib \
	python-json \
	python-zlib \
	python-shell \
	python-sqlite3 \
	python-compression \
	libcurl \
	lsb \
	os-release \
	${@bb.utils.contains('PACKAGECONFIG', 'x11', 'xrandr xdpyinfo', '', d)} \
	"

RRECOMMENDS_${PN}_append_libc-glibc = " \
	glibc-charmap-ibm850 \
	glibc-gconv-ibm850 \
	glibc-gconv-unicode \
	glibc-gconv-utf-32 \
	glibc-charmap-utf-8 \
	glibc-localedata-en-us \
	"
